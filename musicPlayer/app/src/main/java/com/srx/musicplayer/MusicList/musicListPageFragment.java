package com.srx.musicplayer.MusicList;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.srx.musicplayer.HttpUtil.HTTPUtil;
import com.srx.musicplayer.HttpUtil.mapUtil;
import com.srx.musicplayer.Player.playerPageFragment;
import com.srx.musicplayer.R;
import com.srx.musicplayer.jsonEntity.Song;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class musicListPageFragment extends Fragment {

    private List<Song> list = new ArrayList<>();
    private boolean listFlag = false;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private View viewById;//总linearLayout


    public musicListPageFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_music_list_page, container, false);
        initComponent(view);
        mapUtil.setBlurryBackground(view, R.drawable.beauty, 15, viewById,null);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "正在刷新中...请稍后", Toast.LENGTH_SHORT).show();
                initRecyclerView();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    public void initComponent(View view) {
        swipeRefreshLayout = view.findViewById(R.id.refresh);
        recyclerView = view.findViewById(R.id.song_list_recyclerView);
        viewById = view.findViewById(R.id.refresh);
    }


    /**
     * 用于获取另外的fragment中传入的currentList
     *
     * @param data
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEven(final List<String> data) {
        final List<Song> list = new ArrayList<>();
//        Log.d(TAG, "onEven: "+data.toString());
        for (final String item : data) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //这里有异步，所以导致list会造成刷新就会重新加载。但是播放顺序还是按照原先的顺序进行的。
                    Song singleSongDetail = HTTPUtil.getSingleSongDetail(item);
                    Message message = new Message();
                    if (list.size() == (data.size() - 1)) {
                        list.add(singleSongDetail);
                        message.what = 1;
                        message.obj = list;
                        handler.sendMessage(message);
                        listFlag = true;
                    } else {
                        list.add(singleSongDetail);
                    }
                }
            }).start();
        }
    }


    public void initRecyclerView() {
        if (listFlag) {
            if (list.size() == 0) {
                recyclerView.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "歌单暂时为空....请添加歌单或刷新", Toast.LENGTH_SHORT).show();
            } else {
                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                final songListAdapter adapter = new songListAdapter(list);
                adapter.setListener(new songListAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClickForDelete(View view, final long songId, final int position) {
                        new AlertDialog.Builder(getActivity())
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        EventBus.getDefault().post("delete:" + songId);
                                        adapter.notifyItemRemoved(position);
                                    }
                                }).setNegativeButton("取消", null)
                                .setMessage("确定要将这首歌从歌单中删除吗？").show();
                    }

                    @Override
                    public void OnItemClickForSelect(final View view, final long songId) {
//                        Log.d(TAG, "OnItemClickForDelete: " + songId);
                        EventBus.getDefault().post("select:" + songId);
//                        view.setBackgroundColor(R.color.darkBlack);
                    }
                });
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                list = (List<Song>) msg.obj;
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
