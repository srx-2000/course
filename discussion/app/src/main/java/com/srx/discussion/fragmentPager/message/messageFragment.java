package com.srx.discussion.fragmentPager.message;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.Actitvity.login;
import com.srx.discussion.Adapter.MessageAdapter;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.Comment;
import com.srx.discussion.entity.DTO.Post;
import com.srx.discussion.entity.DTO.Reply;
import com.srx.discussion.entity.DTO.ReplyList;
import com.srx.discussion.entity.base.AndroidPostDetail;
import com.srx.discussion.entity.base.AndroidUserToPosts;
import com.srx.discussion.entity.base.Message;
import com.srx.discussion.util.HttpUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class messageFragment extends Fragment {

    private List<Message> messageList = new ArrayList<>();
    private static Integer MESSAGE_PAGE_SIZE = 200;
    private Integer userId;
    private Timer timer1 = new Timer();
    private RecyclerView recyclerView;
    private MessageAdapter adapter;
    private boolean flag = false;
    private boolean flag1 = false;
    private Timer globalTimer=new Timer();
    public messageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        initComponent(view);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag1)
                    getData();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initRecyclerView();
                    }
                });
            }
        };
        timer1.schedule(task, 0, 1000);
        return view;

    }

    public void initRecyclerView() {
        if (flag) {
            adapter = new MessageAdapter(messageList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    public void initComponent(View v) {
        recyclerView = v.findViewById(R.id.message_recyclerView);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull android.os.Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                userId = (Integer) msg.obj;
                flag1 = true;
            } else if (msg.what == 2) {
                flag = true;
            }
        }
    };

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
                android.os.Message message = new android.os.Message();
                message.obj = login;
                message.what = 1;
                handler.sendMessage(message);
            }
        }).start();
        TimerTask globalTask=new TimerTask() {
            @Override
            public void run() {
                if (flag){
                    timer1.cancel();
                }
            }
        };
        globalTimer.schedule(globalTask,0,300);
    }


    public void getData() {
        if (HttpUtil.isLanded()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Post.QueryPostListByUserIdEntity> queryPostListByUserIdEntities = HttpUtil.showUserPostList();
                    List<Comment.QueryCommentListByUserIdEntity> queryCommentListByUserIdEntities = HttpUtil.showUserCommentList();
                    for (Comment.QueryCommentListByUserIdEntity c : queryCommentListByUserIdEntities) {
                        List<ReplyList.ReplyListEntity> replyListEntities = HttpUtil.showReplyList(c.getCommentId());
                        for (ReplyList.ReplyListEntity r : replyListEntities) {
                            messageList.add(new Message(r.getCreateTime(), r.getReplyManNickname(), r.getReplyContext()));
                        }
                    }
                    for (Post.QueryPostListByUserIdEntity p : queryPostListByUserIdEntities) {
                        AndroidPostDetail androidPostDetail = HttpUtil.showPostDetail(p.getPostId(), 1, MESSAGE_PAGE_SIZE);
                        List<AndroidPostDetail.CommentListEntity> commentList = androidPostDetail.getCommentList();
                        for (AndroidPostDetail.CommentListEntity c : commentList) {
                            messageList.add(new Message(c.getCreateTime(), c.getCommentManUsername(), c.getCommentContext()));
                        }
                    }
                    android.os.Message message = new android.os.Message();
                    message.what = 2;
                    handler.sendMessage(message);
                }
            }).start();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        globalTimer.cancel();
    }
}
