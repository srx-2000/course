package com.srx.musicplayer.Player;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import com.srx.musicplayer.HttpUtil.HTTPUtil;
import com.srx.musicplayer.R;
import com.srx.musicplayer.Service.MediaPlayerService;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Text;
import wseemann.media.FFmpegMediaMetadataRetriever;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class playerPageFragment extends Fragment {

    public ImageView play_status;
    private ServiceConnection con;
    private Activity activity;
    private MediaPlayerService.MusicServiceBinder binder;
    private boolean playStatus = false;
    private TextView endTime;
    private TextView startTime;
    private SeekBar seekBar;
    private MediaPlayer player;
    private ImageView next;
    private ImageView previous;
    private int songCount = 0;
    private List<String> songList = new ArrayList<>();

    public playerPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_page, container, false);
        initComponent(view);
        bindService();
        playAndPause();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((songList.size()-1) != songCount) {
                    nextSong(songList.get(songCount));
                    songCount++;
                }else{
                    songCount=(songCount-songList.size())+1;
                }
            }
        });
        return view;
    }

    public void initComponent(View view) {
        play_status = view.findViewById(R.id.play_status);
        startTime = view.findViewById(R.id.begin_time);
        endTime = view.findViewById(R.id.end_time);
        seekBar = view.findViewById(R.id.seek_bar);
        next = view.findViewById(R.id.next);
        previous = view.findViewById(R.id.previous);
        getSongList("5261241463");

    }
    /**
     * 获取评论
     */
    public void comment() {

    }

    /**
     * 获取歌词
     */
    public void lyrics() {

    }

    public void playAndPause() {
        play_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player == null) {
                    Toast.makeText(getActivity(), "请点击下一首进行播放", Toast.LENGTH_LONG).show();
                } else {
                    if (!playStatus) {
                        //开启线程进行搜索，并返回歌曲mp3形式来的url
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                binder.play(player);
                            }
                        }).start();
                        play_status.setImageResource(R.drawable.start);
                        playStatus = true;
                    } else {
                        binder.play(player);
                        play_status.setImageResource(R.drawable.pause);
                        playStatus = false;
                    }
                }
            }
        });
    }


    public void nextSong(final String songId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                playStatus = true;
                Message message = binder.nextOrPreviousSong(songId);
                MediaPlayer nextPlayer = (MediaPlayer) message.obj;
                handler.sendMessage(message);
                binder.play(nextPlayer);
            }
        }).start();
    }


    public void loopPlaying(final String listSongId) {

    }

    public void getSongList(final String listSongId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                songList = HTTPUtil.getSongList(listSongId);
            }
        }).start();
    }

    public void bindService() {
        activity = getActivity();
        con = new ServiceConnection();
        Intent intent = new Intent(getActivity(), MediaPlayerService.class);
        activity.bindService(intent, con, Context.BIND_AUTO_CREATE);
    }


    class ServiceConnection implements android.content.ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MediaPlayerService.MusicServiceBinder) service;
            binder.setSeekBar(seekBar);
            binder.setBeginText(startTime);
//            time.schedule(timerTask,0,500);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                player = (MediaPlayer) msg.obj;
                int time = player.getDuration();
                if (0 != time) {
                    int s = time / 1000;
                    String total = s / 60 + ":" + s % 60;
                    endTime.setText(total);
                } else {
                    endTime.setText("0:00");
                }
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        activity.unbindService(con);
    }
}
