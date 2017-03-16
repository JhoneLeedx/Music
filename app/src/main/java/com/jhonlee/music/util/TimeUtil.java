package com.jhonlee.music.util;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class TimeUtil {

    /**
     * 1.秒转分
     */
    public static String getMinuteBySecond(int seconds) {

        StringBuffer buffer = new StringBuffer();
        int second = seconds % 60;
        int minute = seconds / 60;

        if (minute <= 9) {
            buffer.append("0" + minute + ":");
        } else {
            buffer.append(minute + ":");
        }
        if (second <= 9) {
            buffer.append("0" + second);
        } else {
            buffer.append(second);
        }
        return buffer.toString();
    }
}
