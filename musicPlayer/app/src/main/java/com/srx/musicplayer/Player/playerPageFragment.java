package com.srx.musicplayer.Player;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.sip.SipSession;
import android.os.*;
import android.provider.Settings;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import com.srx.musicplayer.HttpUtil.HTTPUtil;
import com.srx.musicplayer.HttpUtil.mapUtil;
import com.srx.musicplayer.R;
import com.srx.musicplayer.Service.MediaPlayerService;
import com.srx.musicplayer.jsonEntity.Song;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;
import wseemann.media.FFmpegMediaMetadataRetriever;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Time;
import java.util.*;

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
    private ImageView loop;
    private int songCount = 0;
    private List<String> songList = new ArrayList<>();
    private List<String> currentList = new ArrayList<>();
    private String songListId = "5262477176";
    private Timer timer;
    private final Timer songListTimer = new Timer();
    private Timer globalTimer = new Timer();
    private int playing_method = 0;//用于设定播放方式：0为初始值，1为循环播放，2为随机播放。
    private boolean getSongListFlag = false;
    private String TAG = "com.srx.musicPlayer";
    private View viewById;
    private ImageView songImage;
    private Animation operatingAnim;
    private TextView title;
    private String songName;
    private String songPicUrl;
    private int degree=300;


    public playerPageFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_page, container, false);
        initComponent(view);
        bindService();
        mapUtil.setBlurryBackground(view, R.drawable.beauty, degree, viewById, null);
        mapUtil.setCircleImage(view, R.drawable.beauty, songImage, null);
        play_status.setOnClickListener(listener);
        next.setOnClickListener(listener);
        previous.setOnClickListener(listener);
        loop.setOnClickListener(listener);
        loopPlaying();
        //初始化动画
        operatingAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.image_anim);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);

        return view;
    }


    View.OnClickListener listener = new ImageView.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.play_status:
                    if (player == null) {
                        Toast.makeText(getActivity(), "正在加载...请稍后", Toast.LENGTH_SHORT).show();
                    } else {
                        //如果获取歌单的timerTask完成了，那么flag就会变成true，那么我们在这里就结束他
                        if (!playStatus) {
                            //开启线程进行搜索，并返回歌曲mp3形式来的url
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    binder.play();
                                }
                            }).start();
                            play_status.setImageResource(R.drawable.pause);
                            playStatus = true;
                            //开启动画
                            if (operatingAnim != null) {
                                songImage.startAnimation(operatingAnim);
                            }
                        } else {
                            binder.play();
                            play_status.setImageResource(R.drawable.start);
                            playStatus = false;
                            //停止动画
                            songImage.clearAnimation();
                        }
                    }
                    break;
                case R.id.next:
                    if (songListId.equals("") | songListId == null || currentList.size() == 0) {
                        Toast.makeText(getActivity(), "请选择一个歌单", Toast.LENGTH_SHORT).show();
                    } else {
                        if (currentList.size() == 0) {
                            Toast.makeText(getActivity(), "获取歌单中...请稍后", Toast.LENGTH_SHORT).show();
                        } else {
                            if ((currentList.size() - 1) != songCount) {
                                nextSong(currentList.get(songCount));
                                songCount++;
                            } else {
                                songCount = (songCount - currentList.size()) + 1;
                            }
                        }
                    }
                    break;
                case R.id.previous:
                    if (songListId.equals("") | songListId == null || currentList.size() == 0) {
                        Toast.makeText(getActivity(), "请选择一个歌单", Toast.LENGTH_SHORT).show();
                    } else {
                        if (currentList.size() == 0) {
                            Toast.makeText(getActivity(), "获取歌单中...请稍后", Toast.LENGTH_SHORT).show();
                        } else {
                            if (songCount > 0) {
                                nextSong(currentList.get(songCount));
                                songCount--;
                            } else {
                                songCount = (currentList.size() + songCount) - 1;
                            }
                        }
                    }
                    break;
                case R.id.loop:
                    if (playing_method == 0 || playing_method == 2) {
                        if (songListId.equals("") | songListId == null || currentList.size() == 0) {
                            Toast.makeText(getActivity(), "请选择一个歌单", Toast.LENGTH_SHORT).show();
                        } else {
                            loopPlaying();
                        }
                    } else if (playing_method == 0 || playing_method == 1) {
                        if (songListId.equals("") | songListId == null || currentList.size() == 0) {
                            Toast.makeText(getActivity(), "请选择一个歌单", Toast.LENGTH_SHORT).show();
                        } else {
                            randomPlaying();
                        }
                    }
                    break;
            }

        }
    };


    public void initComponent(View view) {
        play_status = view.findViewById(R.id.play_status);
        startTime = view.findViewById(R.id.begin_time);
        endTime = view.findViewById(R.id.end_time);
        seekBar = view.findViewById(R.id.seek_bar);
        next = view.findViewById(R.id.next);
        previous = view.findViewById(R.id.previous);
        loop = view.findViewById(R.id.loop);
        viewById = view.findViewById(R.id.totalLayout);
        songImage = view.findViewById(R.id.song_image);
        title = view.findViewById(R.id.title);
    }

    public void initCurrentList() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (songList.size() == 0)
                    getSongList(songListId);
                if (currentList.size() != songList.size())
                    for (String s : songList) {
                        currentList.add(s);
                    }
                if (currentList.size() != 0) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Message message = new Message();
                            message.what = 3;
                            message.obj = binder.createPlayer(HTTPUtil.getSingleSongMp3(currentList.get(songCount)));
                            handler.sendMessage(message);
                        }
                    }).start();

                }
            }
        };
        songListTimer.schedule(task, 0, 300);
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

    /**
     * 增、删、选择歌单
     *
     * @param SongId
     */
    @Subscribe
    public void onEvent(String SongId) {
        String[] split = SongId.split(":");
        int index = currentList.indexOf(split[1]);
        if (currentList.size() != 0) {
            switch (split[0]) {
                case "delete":
                    currentList.remove(index);
                    break;
                case "select":
                    songCount = index;
                    nextSong(split[1]);
                    break;
                case "add":
                    currentList.add(split[1]);
                    Log.d(TAG, "onEvent: " + split[1]);
                    break;
            }
        }
    }


    public void getSongDetail() {
        if (currentList.size() != 0)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = 4;
                    message.obj = HTTPUtil.getSingleSongDetail(currentList.get(songCount));
                    handler.sendMessage(message);
                }
            }).start();
    }

    public void nextSong(final String songId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                playStatus = true;
                Message message = binder.nextOrPreviousSong(songId);
                handler.sendMessage(message);
                binder.play();
                getSongDetail();
                play_status.setImageResource(R.drawable.pause);
                playStatus = true;
            }
        }).start();
    }

    /**
     * 随机播放
     */
    public void randomPlaying() {
        if (playing_method == 2) {
            timer = null;
        }
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Random random = new Random();
                final int i = random.nextInt(currentList.size());
                if (currentList.size() != 0 & player != null) {
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            nextSong(currentList.get(i));
                            songCount = i;
                            if (songCount >= currentList.size()) {
                                songCount -= currentList.size();
                            }
                        }
                    });
                }
            }
        };
        timer.schedule(task, 0, 1000);
        playing_method = 2;
        loop.setImageResource(R.drawable.random);


    }

    public void initGlobalTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (getSongListFlag) {
                    songListTimer.cancel();
                    EventBus.getDefault().post(currentList);
//                    Log.d(TAG, "run: " + currentList.toString());
                }
            }
        };
        globalTimer.schedule(task, 0, 1000);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCurrentList();
        initGlobalTimer();
        EventBus.getDefault().register(this);
    }


    public List<String> getList() {

        return this.currentList;
    }

    /**
     * 循环播放
     */
    public void loopPlaying() {
        if (playing_method == 2) {
            timer = null;
        }
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (currentList.size() != 0 & player != null) {
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            nextSong(currentList.get(songCount));

                            songCount++;
                            if (songCount >= currentList.size()) {
                                songCount -= currentList.size();
                            }
                        }
                    });
                }
            }
        };
        timer.schedule(task, 0, 1000);
        playing_method = 1;
        loop.setImageResource(R.drawable.cycle);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void downLoadPic() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (songPicUrl != null) {
                    URL url;
                    try {
                        url = new URL(songPicUrl);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setDoInput(true);
                        conn.connect();
                        InputStream in = conn.getInputStream();
                        final Bitmap map = BitmapFactory.decodeStream(in);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mapUtil.setBlurryBackground(getView(), R.drawable.beauty, degree, viewById, map);
                                mapUtil.setCircleImage(getView(), R.drawable.beauty, songImage, map);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    /**
     * 问题在于没跑进去，也就是这个线程在初始化的时候根本没跑
     *
     * @param listId
     */
    public void getSongList(final String listId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message1 = new Message();
                message1.obj = HTTPUtil.getSongListMethod2(listId);
                message1.what = 2;
                handler.sendMessage(message1);
                getSongListFlag = true;
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
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    player = (MediaPlayer) msg.obj;
                    int time = player.getDuration();
                    if (time > 0) {
                        int s = time / 1000;
                        String total = s / 60 + ":" + s % 60;
                        endTime.setText(total);
                    } else {
                        endTime.setText("00:00");
                    }
                    break;
                case 2:
                    songList = (List<String>) msg.obj;
                    break;
                case 3:
                    player = (MediaPlayer) msg.obj;
                    int time1 = player.getDuration();
                    if (time1 > 0) {
                        int s = time1 / 1000;
                        String total = s / 60 + ":" + s % 60;
                        endTime.setText(total);
                    } else {
                        endTime.setText("00:00");
                    }
                    break;
                case 4:
                    Song songDetail = (Song) msg.obj;
                    songPicUrl = songDetail.getSongPicUrl();
                    songName = songDetail.getSongName();
                    title.setText(songName);
                    downLoadPic();
                    break;
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        activity.unbindService(con);
        timer.cancel();
        globalTimer.cancel();
        EventBus.getDefault().unregister(this);
    }
}
