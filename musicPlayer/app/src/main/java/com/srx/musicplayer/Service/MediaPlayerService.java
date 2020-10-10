package com.srx.musicplayer.Service;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.*;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.srx.musicplayer.HttpUtil.HTTPUtil;
import kotlin.reflect.KVariance;

import java.io.IOException;

public class MediaPlayerService extends Service {


    private MediaPlayer player;
    private String currentUrl = "";
    private SeekBar seekBar;
    private int duration;
    private TextView textView;

    public MediaPlayerService(Context context) {
    }

    public MediaPlayerService() {
    }


    public class MusicServiceBinder extends Binder {

        public MediaPlayer createPlayer(String mp3Url) {
            if (player == null && !currentUrl.equals(mp3Url)) {
                try {
                    Uri local = Uri.parse(mp3Url);
                    player = new MediaPlayer();
                    player.setDataSource(MediaPlayerService.this, local);
                    player.prepare();
                    duration = player.getDuration();
                    seekBar.setMax(duration);
                    handler.post(run);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return player;
            } else
                return player;
        }

        public void play(MediaPlayer player) {
            if (player != null) {
                MediaPlayerService.this.player = player;
                if (!player.isPlaying())
                    player.start();
                else
                    player.pause();
            } else {
                System.out.println("请点击下一首进行播放");
            }
        }

        public void previousSong() {

        }

        public Message nextOrPreviousSong(final String songId) {
            String jsonString = HTTPUtil.getSingleSongMp3(songId);
            createPlayer(jsonString);
            Message message = new Message();
            message.what = 1;
            message.obj = player;
            play(player);
            return message;
        }

        public void cyclePlaying() {

        }

        public void randomPlaying() {

        }

        public boolean isPlaying() {
            if (player != null)
                return player.getCurrentPosition() == player.getDuration();
            else
                return false;
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
                    }else{
                        textView.setText("0:00");
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    handler.removeCallbacks(run);
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    player.seekTo(seekBar.getProgress());
                    handler.postDelayed(run, 1000);
                }
            });
        }

        public void setBeginText(TextView view) {
            MediaPlayerService.this.textView = view;
        }

        public int getCurrentPosition() {
            return player.getCurrentPosition();
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
