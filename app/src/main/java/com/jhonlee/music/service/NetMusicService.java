package com.jhonlee.music.service;

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

import com.jhonlee.music.pojo.SongMenuDetail;

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

    private int currentTiem = 0;
    private int allTime = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        player = new MediaPlayer();

        //点击播放音乐的广播
        musicReceiver = new MusicReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("startMusic");
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
                    Intent updateMusic = new Intent();
                    updateMusic.setAction("updateMusic");
                    updateMusic.putExtra("track",mTracks.get(currentIndex+1));
                    sendBroadcast(updateMusic);
                }

                return false;
            }
        });

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (currentIndex==mp3Urls.size()-1){
                    currentIndex = 0;
                }else {
                    currentIndex++;
                }
             //   play(mp3Urls.get(currentIndex));
                Intent updateMusic = new Intent();
                updateMusic.setAction("updateMusic");
                updateMusic.putExtra("track",mTracks.get(currentIndex));
                sendBroadcast(updateMusic);
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
            player.setDataSource( musicUrl);
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    Intent intent = new Intent();
                    intent.setAction("getDuration");
                    allTime = player.getDuration();
                    intent.putExtra("duration", allTime);  //通过Intent来传递歌曲的总长度
                    sendBroadcast(intent);
                    handler.sendEmptyMessage(0);
                }
            });
        } catch (IOException e) {
            //showToast("资源文件,播放失败");
        }
       // notification.onUpdataMusicNotifi(music, true);
    }

    private class MusicReceiver extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {
            String url = intent.getStringExtra("url");
            if (player.isPlaying()){

            }
            for (int i=0;i<mp3Urls.size();i++){
                if(mp3Urls.get(i).equals(url))
                    currentIndex = i;
            }
            play(url);
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
                    currentTiem = player.getCurrentPosition();
                    Intent intent = new Intent();
                    intent.setAction("upadateSeekbar");
                    intent.putExtra("currentTime",currentTiem);
                    sendBroadcast(intent);
                    //间隔一秒给ui发消息更新seekbar
                    handler.sendEmptyMessageDelayed(0,1000);
                }
            }
        }
    };
}
