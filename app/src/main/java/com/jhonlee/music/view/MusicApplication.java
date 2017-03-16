package com.jhonlee.music.view;

import android.app.Application;
import android.content.Intent;

import com.jhonlee.music.service.NetMusicService;

/**
 * Created by JhoneLee on 2017/3/16.
 */

public class MusicApplication extends Application {

    private Intent serviceIntent;

    @Override
    public void onCreate() {
        super.onCreate();
        serviceIntent = new Intent(getApplicationContext(), NetMusicService.class);
        startService(serviceIntent);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        stopService(serviceIntent);
    }
}
