package com.jhonlee.music.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.jhonlee.music.listener.LyricListener;
import com.jhonlee.music.notifi.MusicNotification;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.pojo.SongToken;

import java.io.IOException;
import java.util.List;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class NetMusicService extends Service {

    private MediaPlayer player;
    private List<String> mp3Urls;
    private List<SongMenuDetail.TracksBean> mTracks;
    private GetMp3UrlReceiver mp3UrlReceiver;
    private MusicReceiver musicReceiver;

    private int currentIndex = 0;
    private int currentTime = 0;
    private int allTime = 0;
    private MusicNotification notification;

    private String url;
    private String imgUrl;
    private String name;
    private String author;

    @Override
    public void onCreate() {
        super.onCreate();
        player = new MediaPlayer();

        notification = MusicNotification.getMusicNotification();
        notification.setContext(NetMusicService.this);
        notification.setManager((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        notification.onCreateMusicNotifi();

        //点击播放音乐的广播
        musicReceiver = new MusicReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("startMusic");
        filter.addAction("seekbarUpdate");
        filter.addAction("seekbar");
        filter.addAction("MusicNext");
        filter.addAction("MusicPlay");
        filter.addAction("MusicPause");
        filter.addAction("MusicPrevious");
        filter.addAction("NotifiStart");
        registerReceiver(musicReceiver,filter);


        mp3UrlReceiver = new GetMp3UrlReceiver();
        IntentFilter mp3filter = new IntentFilter();
        mp3filter.addAction("getMp3Urls");
        registerReceiver(mp3UrlReceiver,mp3filter);

        player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                if(what==-1){
                    Toast.makeText(NetMusicService.this,"音频资源异常",Toast.LENGTH_SHORT);
                    //   play(mp3Urls.get(currentIndex));
                  /*  currentTime = 0;
                    handler.sendEmptyMessage(0);*/
                    nextMusic();
                }

                return false;
            }
        });

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextMusic();
            }
        });

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mp3UrlReceiver);
        unregisterReceiver(musicReceiver);
    }

    // 音乐播放
    private void play(final String musicUrl) {

        try {
            player.reset();
            player.setDataSource(musicUrl);
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    Intent intent = new Intent();
                    intent.setAction("getDuration");
                    allTime = player.getDuration();
                    intent.putExtra("isplay",true);
                    intent.putExtra("duration", allTime);  //通过Intent来传递歌曲的总长度
                    sendBroadcast(intent);
                    notification.onUpdataMusicNotifi(name,author,imgUrl,player.isPlaying());
                    handler.sendEmptyMessage(0);
                }
            });
        } catch (IOException e) {
        }
    }
    // 音乐暂停
    private void pause() {
        if (player.isPlaying()) {
            currentTime = player.getCurrentPosition();
            player.pause();
            sendIsplaying();

        }
        notification.onUpdataMusicNotifi(name,author,imgUrl,player.isPlaying());
    }
    // 音乐继续播放
    private void resume() {
        player.start();
        if (currentTime > 0) {
            player.seekTo(currentTime);
        }
        notification.onUpdataMusicNotifi(name,author,imgUrl,player.isPlaying());
        handler.sendEmptyMessage(0);
        sendIsplaying();

    }
    // 音乐停止
    private void stop() {
        player.stop();
        try {
            player.prepare();
        } catch (IOException e) {
        }
        notification.onUpdataMusicNotifi(name,author,imgUrl,player.isPlaying());
        notification.onCancelMusicNotifi();
    }
    //发送给播放页面player的播放状态
    private void sendIsplaying(){
        Intent intent = new Intent();
        intent.setAction("isplay");
        allTime = player.getDuration();
        intent.putExtra("isplay",player.isPlaying());//通过Intent来传递歌曲的总长度
        sendBroadcast(intent);
    }
    private class MusicReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("startMusic")){
                url = intent.getStringExtra("url");
                imgUrl = intent.getStringExtra("imgUrl");
                name = intent.getStringExtra("name");
                author = intent.getStringExtra("author");
                for (int i=0;i<mp3Urls.size();i++){
                    if(mp3Urls.get(i).equals(url))
                        currentIndex = i;
                }
                play(url);
            }else if (action.equals("MusicNext")){
                nextMusic();
            }else if (action.equals("MusicPause")){
                pause();
            }else if (action.equals("MusicPrevious")){
                musicPreviousMusic();
            }else if (action.equals("seekbar")){
                int progress = intent.getIntExtra("progress",0);
                if (progress!=0){
                    currentTime = progress;
                    resume();
                }
            }else if (action.equals("MusicPlay")){
                resume();
            }else if (action.equals("NotifiStart")){
                resume();
            }
        }
    }

    private class GetMp3UrlReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            mp3Urls = intent.getStringArrayListExtra("mp3Urls");
            mTracks = intent.getParcelableArrayListExtra("list");
        }
    }
    private Handler handler  = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                if (player.isPlaying()){
                    currentTime = player.getCurrentPosition();
                    Intent intent = new Intent();
                    intent.setAction("upadateSeekbar");
                    intent.putExtra("currentTime",currentTime);
                    sendBroadcast(intent);
                    //间隔一秒给ui发消息更新seekbar
                    handler.sendEmptyMessageDelayed(0,1000);
                }
            }else {

            }
        }
    };
    private void musicPreviousMusic(){
        Intent updateMusic = new Intent();
        updateMusic.setAction("updateMusic");
        if (currentIndex==0){

        }else {
            currentIndex--;
            updateMusic.putExtra("track",mTracks.get(currentIndex));
            sendBroadcast(updateMusic);
        }
    }
    //顺序播放
    private void nextMusic(){

        Intent updateMusic = new Intent();
        updateMusic.setAction("updateMusic");
        if (currentIndex==mTracks.size()-1){
        }else {
           currentIndex++;
            updateMusic.putExtra("track",mTracks.get(currentIndex));
            sendBroadcast(updateMusic);
        }

    }
}
