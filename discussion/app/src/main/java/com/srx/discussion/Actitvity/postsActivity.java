package com.srx.discussion.Actitvity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.Adapter.postsAdapter;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ErrorMessage;
import com.srx.discussion.entity.base.AndroidPost;
import com.srx.discussion.entity.base.AndroidUserToPosts;
import com.srx.discussion.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import static com.srx.discussion.Actitvity.loadingPage.LOADING_TO_PAGE;
import static com.srx.discussion.Actitvity.login.USER_ID;

public class postsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private TextView postsTitle;
    private TextView postCount;
    private Button follow;
    private ImageView back;
    private List<AndroidPost> postList = new ArrayList<>();
    private postsAdapter adapter;
    public static Integer POSTS_PAGE_SIZE = 5;
    private String postsTitleString;
    private Integer refreshCount = 1;
    private Integer previousSize = 0;
    private boolean postListFlag = false;
    private String showMessage = "";
    private boolean isStar = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        getSupportActionBar().hide();
        initComponent();
        initRecyclerView();
        getData();
        setListener();
    }


    @Override
    protected void onStart() {
        super.onStart();
        isStar();
    }

    public void getData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("postsBundle");
        if (bundle != null) {
            int postCount = bundle.getInt("postCount");
            List<AndroidPost> postList = (List<AndroidPost>) bundle.get("postList");
            postsTitleString = postList.get(0).getBelongPostsName();
            postsTitle.setText(postsTitleString);
            this.postCount.setText(postCount + "");
            this.postList.addAll(postList);
        }
    }

    public void initRecyclerView() {
        recyclerView = findViewById(R.id.post_recyclerView);
        adapter = new postsAdapter(postList);
        adapter.setListener(new postsAdapter.onItemClickListener() {
            @Override
            public void onItemSelectClick(View view, Integer postId) {
                //设置转发节点
                LOADING_TO_PAGE = "postDetailPage";
                //开始转发
                Intent intent = new Intent(postsActivity.this, loadingPage.class);
                intent.putExtra("postId", postId);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    postList.addAll((List<AndroidPost>) msg.obj);
                    break;
                case 2:
                    showMessage = ((ErrorMessage) msg.obj).getErrorMessage();
                    break;
            }
        }
    };

    public void getPostList(Integer refreshCount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                postListFlag = false;
                previousSize = postList.size();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Object result = HttpUtil.showSinglePostsPostList(postList.get(0).getBelongPosts(), refreshCount, POSTS_PAGE_SIZE);
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
        }).start();
    }

    public void isStar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<AndroidUserToPosts> androidUserToPosts = HttpUtil.showUserStarPosts(USER_ID);
                for (AndroidUserToPosts u : androidUserToPosts) {
                    if (u.getPostsId() == postList.get(0).getBelongPosts()) {
                        isStar = true;
                        runOnUiThread(new Runnable() {
                            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                            @Override
                            public void run() {
                                follow.setText("已关注");
                                follow.setBackgroundResource(R.drawable.register_btn);
                            }
                        });
                    }
                }
            }
        }).start();
    }

    public void setListener() {
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HttpUtil.isLanded()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if (isStar) {
                                String s = HttpUtil.unStarPosts(postList.get(0).getBelongPosts());
                                if (s.equals("帖吧取关成功")) {
                                    isStar = false;
                                    runOnUiThread(new Runnable() {
                                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                        @Override
                                        public void run() {
                                            follow.setText("关注");
                                            follow.setBackgroundResource(R.drawable.login_btn);
                                        }
                                    });
                                }
                            } else {
                                String s = HttpUtil.starPosts(postList.get(0).getBelongPosts());
                                if (s.equals("帖吧收藏成功")) {
                                    isStar = true;
                                    runOnUiThread(new Runnable() {
                                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                        @Override
                                        public void run() {
                                            follow.setText("已关注");
                                            follow.setBackgroundResource(R.drawable.register_btn);
                                        }
                                    });
                                }
                            }

                        }
                    }).start();
                } else {
                    Intent intent = new Intent(postsActivity.this, login.class);
                    startActivity(intent);
                    Toast.makeText(postsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastPosition = POSTS_PAGE_SIZE - 1;
//                在每次拖动首先检测RecyclerView是否完全加载，如果没有，就使用notifyDataSetChanged局部刷新
                if (postListFlag) {
                    adapter.notifyDataSetChanged();
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                        if (postList.size() - previousSize == POSTS_PAGE_SIZE) {
                            refreshCount++;
                            getPostList(refreshCount);
                        } else {
                            Toast.makeText(postsActivity.this, "没有更多了呦~", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        refreshCount = 1;
        previousSize = 0;
    }

    public void initComponent() {
        postsTitle = findViewById(R.id.posts_title);
        postCount = findViewById(R.id.post_count);
        follow = findViewById(R.id.follow);
        back = findViewById(R.id.back);
    }
}
