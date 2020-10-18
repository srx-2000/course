package com.srx.musicplayer.Search;


import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.musicplayer.HttpUtil.HTTPUtil;
import com.srx.musicplayer.HttpUtil.mapUtil;
import com.srx.musicplayer.R;
import com.srx.musicplayer.jsonEntity.Song;
import org.greenrobot.eventbus.EventBus;

import java.util.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchPageFragment extends Fragment {

    private EditText editText;
    private List<String> hotList = new ArrayList<>();
    private TextView search_button;
    private Boolean flagForHot = false;
    private Timer timer = new Timer();
    private Timer timer1 ;
    private TimerTask task;
    private Timer globalTimer = new Timer();
    private RecyclerView recyclerViewForHot;
    private boolean flagForSearch = false;
    private String TAG = "com.srx.musicPlayer";
    private RecyclerView recyclerViewForSearch;
    private List<Song> searchResultList = new ArrayList<>();
    private LinearLayout linearLayout;//热搜以及热搜列表的父级LinearLayout
    private Boolean flag=false;

    public searchPageFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
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
        linearLayout = view.findViewById(R.id.hot_linearLayout);
    }

    public void globalTimer() {
        TimerTask globalTask = new TimerTask() {
            @Override
            public void run() {
                if (flagForHot) {
                    timer.cancel();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initRecyclerViewHot(getView());
                        }
                    });
                }
                if (flag){
                    timer1.cancel();
                    flag=false;
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
                flagForHot = true;
            }
        }).start();
    }

    public void initRecyclerViewHot(View view) {
        if (recyclerViewForHot == null) {
            recyclerViewForHot = view.findViewById(R.id.hot_recyclerView);
        }
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        if (hotList.size() != 0) {
            hotAdapter adapter = new hotAdapter(hotList);
            recyclerViewForHot.setAdapter(adapter);
            recyclerViewForHot.setLayoutManager(manager);
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
                if (searchContent == null | searchContent.equals("")) {
                    searchContent = editText.getHint().toString();
                }
                search(searchContent);
                Toast.makeText(getActivity(), "搜索中....请稍后", Toast.LENGTH_SHORT).show();
                timer1 = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (flagForSearch) {
                                    initRecyclerViewSearch(getView());
                                    linearLayout.setVisibility(View.GONE);
                                    recyclerViewForSearch.setVisibility(View.VISIBLE);
                                    flagForSearch=false;//在每次搜索完毕之后将这个值置为false是为了在进行网络操作时不会出现网络请求未完毕，就已经开始进行initRecyclerView的操作了
                                    flag=true;
                                }
                            }
                        });
                    }
                };
                timer1.schedule(task, 0, 1000);
            }
        });
    }

    public void initRecyclerViewSearch(View view) {
        if (recyclerViewForSearch == null) {
            recyclerViewForSearch = view.findViewById(R.id.search_result_recyclerView);
        }
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        if (searchResultList.size() != 0) {
            searchAdapter adapter = new searchAdapter(searchResultList);
            adapter.setListener(new searchAdapter.OnItemClickListener() {
                @Override
                public void OnItemClickForAdd(View view, long songId, int position) {
                    EventBus.getDefault().post("add:"+songId);
                    Log.d(TAG, "OnItemClickForAdd: "+songId);
                }
            });
            recyclerViewForSearch.setAdapter(adapter);
            recyclerViewForSearch.setLayoutManager(manager);

        }else{
            Toast.makeText(getActivity(),"你查询的关键字并没有对应的搜索结果...",Toast.LENGTH_SHORT).show();
        }

    }

    public void search(final String searchString) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                List<Song> songList = HTTPUtil.searchSong(searchString);
                Message message = new Message();
                message.obj = songList;
                message.what = 2;
                handler.sendMessage(message);
                flagForSearch = true;
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
            else if (msg.what == 2) {
                searchResultList = (List<Song>) msg.obj;
            }
        }
    };


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
