package com.jhonlee.music.notifi;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.jhonlee.music.R;
import com.jhonlee.music.pojo.Music;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.pojo.SongToken;
import com.jhonlee.music.util.Const;
import com.jhonlee.music.util.MusicUtil;

/**
 * Created by JhoneLee on 2017/3/10.
 *
 * Music播放控制 的  Notification
 * 动态的显示后台的MusicService的前台展示
 */

public class MusicNotification extends Notification {


    /**
     * 恶汉式实现单例模式加载
     */
    private static MusicNotification notifyInstance = null;

    // 通知id
    private final int NOTIFICATION_ID = 1;
    // 通知
    private Notification musicNotifi = null;
    // 管理通知
    private NotificationManager manager = null;
    // 界面实现
    private Builder builder = null;
    // 上下文
    private Context context;
    // 布局
    private RemoteViews remoteViews;
    private final int REQUEST_CODE = 30000;

    private boolean flag;

    // 给Service 发送广播
    private final String MUSIC_NOTIFICATION_ACTION_PLAY = "NotifiStart";
    private final String MUSIC_NOTIFICATION_ACTION_NEXT = "MusicNext";
    private final String MUSIC_NOTIFICATION_ACTION_CLOSE = "MusicClose";
    private final String MUSIC_NOTIFICATION_ACTION_PAUSE = "MusicPause";
    private Intent play = null, next = null, close = null,pause = null;


    public void setContext(Context context) {
        this.context = context;
        builder = new Builder(context);
    }

    public void setManager(NotificationManager manager) {
        this.manager = manager;
    }

    private MusicNotification() {
        // 初始化操作
        remoteViews = new RemoteViews("com.jhonlee.music",
                R.layout.notifacation);

        // 初始化控制的Intent
        play = new Intent();
        play.setAction(MUSIC_NOTIFICATION_ACTION_PLAY);
        next = new Intent();
        next.setAction(MUSIC_NOTIFICATION_ACTION_NEXT);
        close = new Intent();
        close.setAction(MUSIC_NOTIFICATION_ACTION_CLOSE);
        pause = new Intent();
        pause.setAction(MUSIC_NOTIFICATION_ACTION_PAUSE);

    }

    /**
     * 恶汉式实现 通知
     *
     * @return
     */
    public synchronized static MusicNotification getMusicNotification() {
        if (notifyInstance == null) {
            notifyInstance = new MusicNotification();
        }
        return notifyInstance;
    }

    /**
     * 创建通知
     * 初始化通知
     */
    @SuppressLint("NewApi")
    public void onCreateMusicNotifi() {
        // 设置点击事件

        // 1.注册控制点击事件.注册暂停点击事件

        PendingIntent pplay = PendingIntent.getBroadcast(context, REQUEST_CODE,
                play, PendingIntent.FLAG_UPDATE_CURRENT);
        // 4.注册暂停点击事件
        PendingIntent ppause = PendingIntent.getBroadcast(context, REQUEST_CODE,
                pause, PendingIntent.FLAG_UPDATE_CURRENT);
        if (flag){
            remoteViews.setOnClickPendingIntent(R.id.iv_nofitication_play,
                    ppause);
        }else {
            remoteViews.setOnClickPendingIntent(R.id.iv_nofitication_play,
                   pplay);
       }

        // 2.注册下一首点击事件
        PendingIntent pnext = PendingIntent.getBroadcast(context, REQUEST_CODE,
                next, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.iv_nofitication_next,
                pnext);
        // 3.注册关闭点击事件
        PendingIntent pclose = PendingIntent.getBroadcast(context, REQUEST_CODE,
                close, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.iv_nofitication_colse,
                pclose);

        builder.setContent(remoteViews).setWhen(System.currentTimeMillis())
                // 通知产生的时间，会在通知信息里显示
                //.setPriority(Notification.PRIORITY_DEFAULT)
                // 设置该通知优先级
                .setOngoing(true).setTicker("播放新的一首歌")
                .setSmallIcon(R.drawable.ic_pause_white_36dp);

        // 兼容性实现
      //  musicNotifi = builder.getNotification();
              if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                  musicNotifi = builder.getNotification();
              } else {
                  musicNotifi = builder.build();
              }
        musicNotifi.flags = Notification.FLAG_ONGOING_EVENT;
        manager.notify(PendingIntent.FLAG_UPDATE_CURRENT, musicNotifi);
    }
    /**
     * 更新通知
     */
    public void onUpdataMusicNotifi(String name,String author,String imgUrl, boolean isplay) {

        flag = isplay;
        // 设置添加内容
        remoteViews.setTextViewText(R.id.tv_nofitication_singname,
                (name!=null?name:"什么东东"));
        remoteViews.setTextViewText(R.id.tv_nofitication_singer,
                (author!=null?author:"未知"));
        Glide.with(context).load(imgUrl)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        remoteViews.setImageViewBitmap(R.id.iv_notification_logo, resource);
                    }
                });

        //判断是否播放
        if (isplay) {
            remoteViews.setImageViewResource(R.id.iv_nofitication_play,
                    R.drawable.ic_pause_white_36dp);
        } else {
            remoteViews.setImageViewResource(R.id.iv_nofitication_play,
                    R.drawable.ic_play_white_36dp);
        }
        onCreateMusicNotifi();
    }

    /**
     * 取消通知栏
     */
    public void onCancelMusicNotifi(){
        manager.cancel(NOTIFICATION_ID);
    }

}
