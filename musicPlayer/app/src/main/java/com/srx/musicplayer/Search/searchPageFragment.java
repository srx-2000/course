package com.srx.musicplayer.Search;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.musicplayer.HttpUtil.HTTPUtil;
import com.srx.musicplayer.R;
import com.srx.musicplayer.jsonEntity.Song;

import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchPageFragment extends Fragment {

    private EditText editText;
    private List<String> hotList = new ArrayList<>();
    private TextView search_button;
    private Boolean flag = false;
    private Timer timer = new Timer();
    private TimerTask task;
    private Timer globalTimer = new Timer();
    private RecyclerView recyclerView;
    private String TAG = "com.srx.musicPlayer";

    public searchPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_page, container, false);
        initComponent(view);
        globalTimer();
        initButtonClickListener();
        return view;
    }

    public void initComponent(View view) {
        editText = view.findViewById(R.id.search_editText);
        search_button = view.findViewById(R.id.search_button);

    }

    public void globalTimer() {
        TimerTask globalTask = new TimerTask() {
            @Override
            public void run() {
                if (flag) {
                    timer.cancel();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initRecyclerView(getView());
                        }
                    });
                }
            }
        };
        globalTimer.schedule(globalTask, 0, 1000);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timer();
    }

    public void getHot() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                message.obj = HTTPUtil.getHotList();
                handler.sendMessage(message);
                flag = true;
            }
        }).start();
    }

    public void initRecyclerView(View view) {
        if (recyclerView == null) {
            recyclerView = view.findViewById(R.id.hot_recyclerView);
        }
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        if (hotList.size() != 0) {
            hotAdapter adapter = new hotAdapter(hotList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
        }
    }

    public void Timer() {
        task = new TimerTask() {
            @Override
            public void run() {
                getHot();
//                test();
            }
        };
        timer.schedule(task, 0, 1000);
    }

    public void initButtonClickListener() {
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchContent = editText.getText().toString();
                if (searchContent == null|searchContent.equals("")) {
                    searchContent = editText.getHint().toString();
                }
                search(searchContent);
            }
        });
    }

    public void search(final String searchString) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                List<Song> songList = HTTPUtil.searchSong(searchString);
                for (Song song : songList) {
//                    System.out.println(song.toString());
                    Log.d(TAG, "test: " + "第" + count + "个：" + song.toString());
                    count++;
                }
            }
        }).start();

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1)
                hotList = (List<String>) msg.obj;
        }
    };
}
