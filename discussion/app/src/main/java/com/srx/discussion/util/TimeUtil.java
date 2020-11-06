package com.srx.discussion.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static String getDuringTime(String createTime){
        long nowTime = new Date().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long begin = 0;
        try {
            begin = dateFormat.parse(createTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = (nowTime - begin) / 1000;
        String result = null;
        if (seconds < 60) {
            result = String.valueOf(seconds) + "秒前";
        } else if (seconds >= 60 && seconds < 60 * 60) {
            result = String.valueOf(seconds / 60) + "分钟前";
        } else if (seconds >= 60 * 60 && seconds < 60 * 60 * 24) {
            result = String.valueOf(seconds / (60 * 60)) + "小时前";
        } else if (seconds >= 60 * 60 * 24 && seconds < 60 * 60 * 24 * 30) {
            result = String.valueOf(seconds / (60 * 60 * 24)) + "天前";
        } else if (seconds >= 60 * 60 * 24 * 30 && seconds < 60 * 60 * 24 * 30 * 12) {
            result = String.valueOf(seconds / (60 * 60 * 24 * 30)) + "月前";
        } else {
            result = String.valueOf(seconds / (60 * 60 * 24 * 30 * 12)) + "年前";
        }
        return result;
    }
}
