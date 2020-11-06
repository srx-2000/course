package com.srx.discussion.fragmentPager.Home;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.srx.discussion.Actitvity.PostDetailActivity;
import com.srx.discussion.Actitvity.loadingPage;
import com.srx.discussion.Adapter.HomeAdapter;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ErrorMessage;
import com.srx.discussion.entity.base.AndroidPost;
import com.srx.discussion.entity.base.AndroidPostDetail;
import com.srx.discussion.util.HttpUtil;
import org.greenrobot.eventbus.EventBus;

import java.nio.charset.IllegalCharsetNameException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {

    public static Integer POST_PAGE_SIZE =3;
    private List<AndroidPost> refreshList = new ArrayList<>();
    private String showMessage = "";
    private Timer timer = new Timer();
    private Boolean postListFlag = false;
    private SwipeRefreshLayout refreshLayout;
    private Integer refreshCount = 1;
    private Integer previousSize = 0;
    private static String TAG = "石荣兴";
    RecyclerView homeRecyclerView;
    private HomeAdapter homeAdapter;


    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initComponent(view);
        setRecyclerViewListener();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (postListFlag) {
                    timer.cancel();
                    initRecyclerView(view);
                    refreshLayout.setRefreshing(false);
                }
            }
        });
        return view;
    }


    public void setRecyclerViewListener() {
        homeRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastPosition = POST_PAGE_SIZE - 1;
//                在每次拖动首先检测RecyclerView是否完全加载，如果没有，就使用notifyDataSetChanged局部刷新
                if (postListFlag) {
                    homeAdapter.notifyDataSetChanged();
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                        if (refreshList.size() - previousSize == POST_PAGE_SIZE) {
                            refreshCount++;
                            getHomePostList(refreshCount);
                        } else {
                            Toast.makeText(getActivity(), "没有更多了呦~", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }

    public void initComponent(View view) {
        refreshLayout = view.findViewById(R.id.home_refresh);
        homeRecyclerView = view.findViewById(R.id.home_recyclerView);
    }

    public void initRecyclerView(View view) {
        if (postListFlag) {
            homeAdapter = new HomeAdapter(refreshList);
            homeAdapter.setListener(new HomeAdapter.onItemClickListener() {
                @Override
                public void onItemSelectClick(View view, Integer postId) {
                    Toast.makeText(getActivity(),"点击了"+postId,Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onItemSelectClick: " + postId);
                    Intent intent=new Intent(getActivity(), loadingPage.class);
                    intent.putExtra("postId",postId);
                    startActivity(intent);
//                    AndroidPostDetail androidPostDetail = HttpUtil.showPostDetail(postId, 1, COMMENT_PAGE_SIZE);
                }
            });
            homeRecyclerView.setAdapter(homeAdapter);
            homeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    public void getHomePostList(Integer refreshCount) {
        postListFlag = false;
        previousSize = refreshList.size();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Object result = HttpUtil.showHomePostList(refreshCount, POST_PAGE_SIZE);
                Message message = new Message();
                if (result instanceof List) {
                    message.what = 1;
                    message.obj = result;
                    handler.sendMessage(message);
                    postListFlag = true;
                } else {
                    message.what = 2;
                    message.obj = result;
                    handler.sendMessage(message);
                    postListFlag = true;
                }
            }
        }).start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getHomePostList(1);

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    refreshList.addAll((List<AndroidPost>) msg.obj);
                    break;
                case 2:
                    showMessage = ((ErrorMessage) msg.obj).getErrorMessage();
                    break;
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        refreshCount = 1;
        previousSize = 0;
    }
}
