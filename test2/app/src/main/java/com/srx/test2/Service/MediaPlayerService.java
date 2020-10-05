package com.srx.test2.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

public class MediaPlayerService extends Service {

    private MediaPlayer player;
    private String query;

    public MediaPlayerService() {
    }

    @Override
    public void onCreate() {
        Log.d("TAG", "初始化音乐资源");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        if (query != null && !query.equals(intent.getStringExtra("query")) && player != null) {
            player.start();
        } else {
            String query = intent.getStringExtra("query");
            Uri location = Uri.parse("https://ssl.gstatic.com/dictionary/static/sounds/oxford/" + query+"--_gb_1.mp3");
            player = MediaPlayer.create(this, location);
            // System.out.println("音乐开始播放");
            player.start();
            // 音乐播放完毕的事件处理
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    // 不循环播放
                    try {
                        // mp.start();
                        System.out.println("stopped");
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            });
            player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    try {
                        player.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                }
            });

        }

    }

    @Override
    public void onDestroy() {
        // 服务停止时停止播放音乐并释放资源
        player.stop();
        player.release();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
