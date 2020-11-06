package com.srx.discussion.Actitvity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.discussion.R;
import com.srx.discussion.entity.base.AndroidPostDetail;
import com.srx.discussion.util.HttpUtil;

import java.util.Timer;
import java.util.TimerTask;

import static com.srx.discussion.Actitvity.PostDetailActivity.COMMENT_PAGE_SIZE;

public class loadingPage extends AppCompatActivity {

    private AndroidPostDetail detail = new AndroidPostDetail();
    private boolean detailFlag = false;
    private Timer timer=new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);
        getSupportActionBar().hide();
        loadingData();
        timer();

    }

    public void loadingData() {
        Intent intent = getIntent();
        int postId = intent.getIntExtra("postId", 1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.obj = HttpUtil.showPostDetail(postId, 1, COMMENT_PAGE_SIZE);
                message.what=1;
                handler.sendMessage(message);
                detailFlag = true;
            }
        }).start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    detail = (AndroidPostDetail) msg.obj;
                    break;
            }
        }
    };

    public void timer(){
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                if (detailFlag){
                    Intent intent=new Intent(loadingPage.this,PostDetailActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("postDetailData",detail);
                    intent.putExtra("bundle",bundle);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.schedule(task,0,1000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
