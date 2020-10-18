package com.srx.musicplayer.Service;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.*;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.srx.musicplayer.HttpUtil.HTTPUtil;
import kotlin.reflect.KVariance;

import java.io.IOException;

public class MediaPlayerService extends Service {


    private MediaPlayer nextPlayer;//该变量的主要任务就是讲currentUrl与mp3Url不同这个消息传出去，传给nextOrPreviousSong方法
    private MediaPlayer player;
    private String currentUrl = "";
    private SeekBar seekBar;
    private int duration;
    private int nextDuration;
    private TextView textView;

    public MediaPlayerService() {
    }


    public class MusicServiceBinder extends Binder {

        public MediaPlayer createPlayer(String mp3Url) {
            if (player == null) {
                try {
                    Uri local = Uri.parse(mp3Url);
                    player = MediaPlayer.create(MediaPlayerService.this, local);
                    currentUrl = mp3Url;
                    duration = player.getDuration();
                    seekBar.setMax(duration);
                    handler.post(run);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return player;
            } else {
                //如果当前的地址与传入的地址不同，那么就是下一首了，那么将nextPlayer初始化；
                if (!currentUrl.equals(mp3Url)) {
                    try {
                        Uri local = Uri.parse(mp3Url);
                        nextPlayer = MediaPlayer.create(MediaPlayerService.this, local);
                        currentUrl = mp3Url;
                        nextDuration = nextPlayer.getDuration();
                        seekBar.setMax(nextDuration);
                        handler.post(run);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return nextPlayer;
                }
                return player;
            }
        }

        public void play() {
            if (player != null) {
                if (!player.isPlaying())
                    player.start();
                else
                    player.pause();
            } else {
                System.out.println("请点击下一首进行播放");
            }
        }

        public Message nextOrPreviousSong(final String songId) {
            String jsonString = HTTPUtil.getSingleSongMp3(songId);
            createPlayer(jsonString);
            if (nextPlayer != null && !player.equals(nextPlayer)) {
                player.stop();
                player = nextPlayer;
            }
            Message message = new Message();
            message.what = 1;
            message.obj = player;
            return message;
        }

        public void randomPlaying() {

        }


        public void setSeekBar(SeekBar seekBar) {
            MediaPlayerService.this.seekBar = seekBar;
            MediaPlayerService.this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (progress != 0) {
                        int s = progress / 1000;
                        String total = s / 60 + ":" + s % 60;
                        textView.setText(total);
                    } else {
                        textView.setText("0:00");
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    handler.removeCallbacks(run);
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    if (seekBar != null && player != null) {
                        player.seekTo(seekBar.getProgress());
                        handler.postDelayed(run, 1000);
                    }
                }
            });
        }

        public void setBeginText(TextView view) {
            MediaPlayerService.this.textView = view;
        }

    }


    Handler handler = new Handler();
    Runnable run = new Runnable() {
        @Override
        public void run() {
            MediaPlayerService.this.seekBar.setProgress(player.getCurrentPosition());
            handler.postDelayed(run, 100);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return new MusicServiceBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

}
