package com.jhonlee.music.util;

/**
 * Created by JhoneLee on 2017/3/13.
 */

public class Const {


    //初始化flag
    public static final int STATE_NON = 0;
    //播放的flag
    public static final int STATE_PLAY = 1;
    //暂停的flag
    public static final int STATE_PAUSE = 2;
    //停止放的flag
    public static final int STATE_STOP = 3;
    //播放上一首的flag
    public static final int STATE_PREVIOUS = 4;
    //播放下一首的flag
    public static final int STATE_NEXT = 5;
    //seekbar 时间改变
    public static final int STATE_SEEK = 6;


    public static final String URL = "http://music.163.com/api/";

    public static final String QQMUSIC_URL = "http://route.showapi.com/";

    private static final String APP_ID = "33780";
    private static final String APP_SECRET = "6264f60a2e3f4b01a29521697dddda1f";
}
