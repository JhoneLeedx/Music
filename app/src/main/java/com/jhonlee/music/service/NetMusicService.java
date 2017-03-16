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

import java.io.IOException;
import java.util.List;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class NetMusicService extends Service {

    private MediaPlayer player;
    private List<String> mp3Urls;

    private GetMp3UrlReceiver mp3UrlReceiver;
    private MusicReceiver musicReceiver;
    private int currentIndex = 0;

    private int currentTiem = 0;

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



        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (currentIndex==mp3Urls.size()-1){
                    currentIndex = 0;
                }else {
                    currentIndex++;
                }
                play(mp3Urls.get(currentIndex));
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
            player.prepare();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
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
                    //间隔一秒给ui发消息更新seekbar
                    handler.sendEmptyMessageDelayed(0,1000);
                }
            }
        }
    };
}
