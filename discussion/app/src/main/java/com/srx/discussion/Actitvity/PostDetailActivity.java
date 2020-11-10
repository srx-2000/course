package com.srx.discussion.Actitvity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.Adapter.CommentAdapter;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ReplyList;
import com.srx.discussion.entity.base.AndroidPostDetail;
import com.srx.discussion.fragmentPager.detail.reply;
import com.srx.discussion.util.HttpUtil;
import com.srx.discussion.util.TimeUtil;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import static com.srx.discussion.Actitvity.loadingPage.LOADING_TO_PAGE;

public class PostDetailActivity extends AppCompatActivity {

    public static Integer COMMENT_PAGE_SIZE = 10;
    private Integer postId;
    private RecyclerView commentRecyclerView;
    private TextView postManNickname;
    private TextView postTitle;
    private TextView postContent;
    private TextView postsTitle;
    private LinearLayout linearLayout;
    private List<AndroidPostDetail.CommentListEntity> commentList = new ArrayList<>();
    private boolean getDetailFlag = false;
    private AndroidPostDetail detail;
    public static String TAG = "石荣兴";
    private CommentAdapter adapter;
    private Integer previousSize = 0;
    private Integer refreshCount = 1;
    private TextView postTime;
    private Integer postsId;
    private com.srx.discussion.fragmentPager.detail.reply reply;




    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        initComponent();
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("");
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setBackgroundDrawable(new ColorDrawable(R.color.closeWhite));
        supportActionBar.setSplitBackgroundDrawable(new ColorDrawable(R.color.closeWhite));
        getPostId();
        setListener();
        initRecyclerViewList();
        setRecyclerViewListener();
        setData();
    }


    public void setListener(){
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LOADING_TO_PAGE="postsPage";
                Intent intent=new Intent(PostDetailActivity.this,loadingPage.class);
                intent.putExtra("postId",postsId);
                startActivity(intent);
            }
        });
    }

    public void starPost() {
        if (HttpUtil.isLanded()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String s = HttpUtil.starPost(postId);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(PostDetailActivity.this, s, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }).start();
        } else {
            Intent intent = new Intent(this, login.class);
            startActivity(intent);
            Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.star:
                starPost();

        }

        return super.onOptionsItemSelected(item);
    }

    public void initComponent() {
        commentRecyclerView = findViewById(R.id.comment_recyclerView);
        postManNickname = findViewById(R.id.user_nickName);
        postTitle = findViewById(R.id.post_title);
        postsTitle = findViewById(R.id.posts_title);
        postContent = findViewById(R.id.post_content);
        postTime = findViewById(R.id.time);
        linearLayout=findViewById(R.id.posts_layout);
    }


    public void getPostId() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        detail = (AndroidPostDetail) bundle.get("postDetailData");
        commentList.addAll(detail.getCommentList());
        this.postId = detail.getPostId();
    }

    public void getPostDetail(Integer currentPage) {
        getDetailFlag = false;
        previousSize = commentList.size();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (postId != null) {
                    Message message = new Message();
                    message.what = 1;
                    AndroidPostDetail androidPostDetail = HttpUtil.showPostDetail(postId, currentPage, COMMENT_PAGE_SIZE);
                    message.obj = androidPostDetail.getCommentList();
                    handler.sendMessage(message);
                }
            }
        }).start();
    }

    public void initRecyclerViewList() {
        commentRecyclerView = findViewById(R.id.comment_recyclerView);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommentAdapter(commentList);
        adapter.setListener(new CommentAdapter.onItemClickListener() {
            @Override
            public void onReplyClick(View view, Integer commentId) {
                //传递commentId到一个fragment或是别的东西上
                //然后获取commentList
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<ReplyList.ReplyListEntity> replyListEntities = HttpUtil.showReplyList(commentId);
                        EventBus.getDefault().post(replyListEntities);
                    }
                }).start();
                if (reply == null)
                    reply = new reply();
                reply.show(getSupportFragmentManager(), "Dialog");
            }
        });
        commentRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_more, menu);
        return true;

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    commentList.addAll((List<AndroidPostDetail.CommentListEntity>) msg.obj);
                    break;
            }
        }
    };

    public void setData() {
        if (detail != null) {
            postManNickname.setText(detail.getPostManNickname());
            postContent.setText(detail.getPostContext());
            postTitle.setText(detail.getPostTitle());
            postsTitle.setText(detail.getBelongPostsName());
            this.postsId=detail.getBelongPostsId();
            postTime.setText(TimeUtil.getDuringTime(detail.getPostCreateTime()));

        }
    }


    public void setRecyclerViewListener() {
        commentRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastPosition = COMMENT_PAGE_SIZE - 1;
//                在每次拖动首先检测RecyclerView是否完全加载，如果没有，就使用notifyDataSetChanged局部刷新
                if (getDetailFlag) {
                    adapter.notifyDataSetChanged();
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                        if (commentList.size() - previousSize == COMMENT_PAGE_SIZE) {
                            refreshCount++;
                            getPostDetail(refreshCount);
                        } else {
                            Toast.makeText(PostDetailActivity.this, "没有更多了呦~", Toast.LENGTH_SHORT).show();
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
}
