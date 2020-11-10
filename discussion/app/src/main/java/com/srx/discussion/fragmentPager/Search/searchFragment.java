package com.srx.discussion.fragmentPager.Search;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.Actitvity.loadingPage;
import com.srx.discussion.Adapter.SearchAdapter;
import com.srx.discussion.R;
import com.srx.discussion.entity.base.AndroidPosts;
import com.srx.discussion.entity.base.AndroidUserToPost;
import com.srx.discussion.entity.base.AndroidUserToPosts;
import com.srx.discussion.util.HttpUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.srx.discussion.Actitvity.loadingPage.LOADING_TO_PAGE;
import static com.srx.discussion.Actitvity.login.USER_ID;

public class searchFragment extends Fragment {

    private Button searchButton;
    private EditText searchEditText;
    private RecyclerView recyclerView;
    private List<AndroidUserToPosts> postsList = new ArrayList<>();
    private TextView noPosts;
    private Timer timer = new Timer();
    private Timer globalTimer = new Timer();
    private boolean postsListFlag = false;
    private boolean searchFlag = false;
    private SearchAdapter adapter;
    private Integer userId = 0;
    private Timer timer1 = new Timer();
    public static Integer BLURRY_SEARCH_PAGE_SIZE = 50;
    private List<AndroidPosts> searchList = new ArrayList<>();

    public searchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        initComponent(view);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setData();
            }
        };
        timer1.schedule(task, 0, 1000);
        setSearchView();
        return view;
    }


    public void setSearchView() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = searchEditText.getText().toString();
                if (string.equals("")) {
                    string = searchEditText.getHint().toString();
                }
                String finalString = string;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<AndroidPosts> postsList = HttpUtil.blurryPostList(finalString, 1, BLURRY_SEARCH_PAGE_SIZE);
                        Message message = new Message();
                        message.what = 2;
                        message.obj = postsList;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String username = sp.getString("username", "");
        String password = sp.getString("password", "");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer login = HttpUtil.login(username, password);
                List<AndroidUserToPosts> androidUserToPosts = HttpUtil.showUserStarPosts(login);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) androidUserToPosts);
                bundle.putSerializable("userId", login);
                Message message = new Message();
                message.obj = bundle;
                message.what = 1;
                handler.sendMessage(message);
            }
        }).start();
        timer();
    }

    public void timer() {
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                if (postsListFlag) {
                    timer.cancel();
                    timer1.cancel();
                }
            }
        };
        globalTimer.schedule(task2, 0, 500);
    }

    public void initRecyclerView() {
        if (postsListFlag) {
            adapter = new SearchAdapter(postsList);
            recyclerView.setAdapter(adapter);
            adapter.setListener(new SearchAdapter.OnItemClickListener() {
                @Override
                public void OnPostsSelected(View v, Integer postId) {
                    LOADING_TO_PAGE = "postsPage";
                    Intent intent = new Intent(getActivity(), loadingPage.class);
                    intent.putExtra("postId", postId);
                    startActivity(intent);
                }
            });
            adapter.notifyDataSetChanged();
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }
    }


    public void initComponent(View view) {
        searchButton = view.findViewById(R.id.search_btn);
        searchEditText = view.findViewById(R.id.search_editText);
        recyclerView = view.findViewById(R.id.search_recyclerView);
        noPosts = view.findViewById(R.id.no_posts);
    }

    public void setData() {
        if (postsListFlag) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recyclerView.setVisibility(View.VISIBLE);
                    noPosts.setVisibility(View.GONE);
                    initRecyclerView();
                }
            });
        } else {
            recyclerView.setVisibility(View.GONE);
            noPosts.setVisibility(View.VISIBLE);
        }
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Bundle bundle = (Bundle) msg.obj;
                    List<AndroidUserToPosts> list = (List<AndroidUserToPosts>) bundle.get("list");
                    postsList.addAll(list);
                    userId = bundle.getInt("userId");
                    postsListFlag = true;
                    break;
                case 2:
                    searchList.addAll((List<AndroidPosts>) msg.obj);
                    searchFlag = true;
                    break;
            }

        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        globalTimer.cancel();
    }
}
