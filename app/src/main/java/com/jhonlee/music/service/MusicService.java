package com.jhonlee.music.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.jhonlee.music.notifi.MusicNotification;
import com.jhonlee.music.pojo.Music;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.util.Const;
import com.jhonlee.music.util.MusicUtil;

import java.io.IOException;
import java.util.List;


/**
 * Created by JhoneLee on 2017/3/10.
 */

public class MusicService extends Service  {


    private MediaPlayer player;
  //  private MusicReceiver receiver;

    private List<SongMenuDetail.TracksBean> musics;
    private Music music;
    private int currentIndex = 0;

    private int currentTime = 0;
    private boolean flag;//播放状态

    private MusicNotification notification;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;


    }

    @Override
    public void onCreate() {

        super.onCreate();
     /*   player = new MediaPlayer();
        musics = MusicUtil.getData(this);


        // 初始化通知栏
        notification = MusicNotification.getMusicNotification();
        notification.setContext(getApplicationContext());
        notification.setManager((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        notification.onCreateMusicNotifi();

        //注册监听广播
        receiver = new MusicReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.jhonlee.music.play");
        filter.addAction("com.jhonlee.music.next");
        filter.addAction("com.jhonlee.music.stop");
        filter.addAction("com.jhonlee.music.pause");
        filter.addAction("com.jhonlee.music.previous");
        filter.addAction("music.notificaion.play");
        filter.addAction("music.notificaion.next");
        filter.addAction("music.notificaion.close");
        filter.addAction("music.notificaion.pause");
        filter.addAction("com.jhonlee.music.seekbar");
        registerReceiver(receiver,filter);


        //循环重复播放
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (currentIndex==musics.size()-1)
                    currentIndex = 0;
                else {
                    currentIndex++;
                }
                play(musics.get(currentIndex).getPath());
                notification.onUpdataMusicNotifi(musics.get(currentIndex),true);
              //  Log.d("资源文件,播放失败",musics.get(currentIndex).getPath());
                startBarThread();
                sendBroadcasts();
            }
        });
        //播放错误时的请求
        player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        });

    //    startBarThread();
*/
    }

/*
    @Override
    public void onDestroy() {

        if (seekBarThread != null) {
            seekBarThread.off();
        }
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.release();
        }
        unregisterReceiver(receiver);

    }*/
/*
    //创建广播接收器用于接收前台Activity发去的广播
    private class MusicReceiver extends BroadcastReceiver {

        public void onReceive(Context context, Intent intent) {
            int index = intent.getIntExtra("index",-1);
            int newState = intent.getIntExtra("state",0);

            String action = intent.getAction();
            if (index!=-1){
                currentIndex = index;
            }
            music = musics.get(currentIndex);
            switch (newState){
                case Const.STATE_NEXT://下一首
                    if (currentIndex==musics.size()-1){
                        showToast("已经是最后一首了");
                        resume();
                    }else {
                        currentIndex++;
                        play(musics.get(currentIndex).getPath());
                        Log.d("资源文件,播放失败",musics.get(currentIndex).getPath());
                    }
                    flag  = true;
                    sendBroadcasts();
                    break;
                case Const.STATE_PAUSE://暂停
                    pause();
                    flag = false;
                    sendBroadcasts();
                    break;
                case Const.STATE_PLAY://播放
                   // player.start();
                    if (currentTime>0){
                        resume();
                    }else {
                        play(musics.get(currentIndex).getPath());
                        startBarThread();
                    }
                    flag  = true;
                    sendBroadcasts();

                    break;
                case Const.STATE_STOP://停止
                    stop();
                    break;
                case Const.STATE_PREVIOUS://上一首
                    if (currentIndex==0){
                        showToast("已经是第一首了");
                        resume();
                    }else {
                        currentIndex--;
                        play(musics.get(currentIndex).getPath());
                    }
                    flag  = true;
                    sendBroadcasts();
                    break;
                case Const.STATE_SEEK:
                    if (action.equals("com.jhonlee.music.seekbar")){
                        currentTime = intent.getIntExtra("progress",0);
                        resume();
                    }
                    break;
            }
        }

    }
    // 音乐播放
    private void play(String musicUrl) {
        player.reset();
        try {
            player.setDataSource(getApplicationContext(), Uri.parse(musicUrl));
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    player.start();
                }
            });
        } catch (IOException e) {
            showToast("资源文件,播放失败");
        }
        notification.onUpdataMusicNotifi(music, true);
    }

    // 音乐暂停
    private void pause() {
        if (player.isPlaying()) {
            currentTime = player.getCurrentPosition();
            player.pause();
        }
        notification.onUpdataMusicNotifi(music, false);

    }
    // 音乐继续播放
    private void resume() {
        player.start();
        if (currentTime > 0) {
            player.seekTo(currentTime);
        }
        notification.onUpdataMusicNotifi(music, true);
    }
    // 音乐停止
    private void stop() {
        player.stop();
        try {
            player.prepare();
        } catch (IOException e) {
            showToast("音乐停止异常");
        }
        notification.onUpdataMusicNotifi(music, false);
        notification.onCancelMusicNotifi();

        seekBarThread.off();
    }
    // Toast
    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private void sendBroadcasts(){
        //发送广播通知Activity更改文本框
        Intent sendIntent = new Intent("com.jhonlee.music.update");
        sendIntent.putExtra("flag",flag);
        sendIntent.putExtra("index", currentIndex);
        //发送广播，将被Activity中的BroadcastReceiver接收到
        sendBroadcast(sendIntent);
    }

    private SeekbarThread seekBarThread;


    private void startBarThread() {
        if (seekBarThread != null) {
            seekBarThread.off();
        }
        seekBarThread = new SeekbarThread();
        seekBarThread.start();
    }


    private class SeekbarThread extends Thread{
        boolean flag = true;
        int duration = 1;
        int seekBarProgress = 0;
        int position = 0;
        public SeekbarThread() {};

        public void off() {
            flag = false;
        }
        public void run() {
            flag = true;
            if(player!=null) {
                duration = player.getDuration();
            }

            seekBarProgress = 0;
            position = 0;
            while (flag) {
                if(player!=null) {
                    position = player.getCurrentPosition();
                }
                seekBarProgress =position;

                Intent intent = new Intent();
                intent.putExtra("progress",seekBarProgress);
                intent.putExtra("duration",duration);
                //设置广播的类型
                intent.setAction("com.jhonlee.music.seekbar_fromserive");
                sendBroadcast(intent);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }// while
    }*/
}
