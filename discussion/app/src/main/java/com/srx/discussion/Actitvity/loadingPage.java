package com.srx.discussion.Actitvity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.discussion.R;
import com.srx.discussion.entity.base.AndroidPost;
import com.srx.discussion.entity.base.AndroidPostDetail;
import com.srx.discussion.util.HttpUtil;
import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.*;

import static com.srx.discussion.Actitvity.PostDetailActivity.COMMENT_PAGE_SIZE;
import static com.srx.discussion.Actitvity.postsActivity.POSTS_PAGE_SIZE;
import static com.srx.discussion.fragmentPager.Home.homeFragment.POST_PAGE_SIZE;

public class loadingPage extends AppCompatActivity {

    private AndroidPostDetail detail = new AndroidPostDetail();
    private boolean detailFlag = false;
    private boolean homePageFlag = false;
    private Timer timer = new Timer();
    public static String LOADING_TO_PAGE = "";
    private TimerTask task;
    private List<AndroidPost> postList = new ArrayList<>();
    private Bundle postsBundle;
    private boolean postsFlag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);
        getSupportActionBar().hide();
        loadingData(LOADING_TO_PAGE);
        timer(LOADING_TO_PAGE);

    }

    public void loadingData(String loadingPage) {
        Intent intent = getIntent();
        switch (loadingPage) {
            case "postDetailPage":
                int postId = intent.getIntExtra("postId", 1);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.obj = HttpUtil.showPostDetail(postId, 1, COMMENT_PAGE_SIZE);
                        message.what = 1;
                        handler.sendMessage(message);
                        detailFlag = true;
                    }
                }).start();
                break;
            case "postsPage":
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int postId = intent.getIntExtra("postId", 1);
                        Message message = new Message();
                        Integer postCount = HttpUtil.getPostCount(postId);
                        List<AndroidPost> postList = (List<AndroidPost>) HttpUtil.showSinglePostsPostList(postId, 1, POSTS_PAGE_SIZE);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("postList", (Serializable) postList);
                        bundle.putInt("postCount", postCount);
                        message.obj = bundle;
                        message.what = 2;
                        handler.sendMessage(message);
                        postsFlag = true;
                    }
                }).start();
                break;
        }

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    detail = (AndroidPostDetail) msg.obj;
                    break;
                case 2:
                    postsBundle = (Bundle) msg.obj;
                    break;
            }
        }
    };

    public void timer(String loadingPage) {
        switch (loadingPage) {
            case "postDetailPage":
                task = new TimerTask() {
                    @Override
                    public void run() {
                        if (detailFlag) {
                            Intent intent = new Intent(loadingPage.this, PostDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("postDetailData", detail);
                            intent.putExtra("bundle", bundle);
                            startActivity(intent);
                            finish();
                        }
                    }
                };
                break;
            case "postsPage":
                task = new TimerTask() {
                    @Override
                    public void run() {
                        if (postsFlag) {
                            Intent intent = new Intent(loadingPage.this, postsActivity.class);
                            if (postsBundle != null)
                                intent.putExtra("postsBundle", postsBundle);
                            startActivity(intent);
                            finish();
                        }
                    }
                };
                break;
        }
        timer.schedule(task, 0, 1000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
