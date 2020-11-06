package com.srx.discussion.fragmentPager.User;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srx.discussion.Actitvity.MainActivity;
import com.srx.discussion.Actitvity.login;
import com.srx.discussion.R;
import com.srx.discussion.entity.base.AndroidUser;
import com.srx.discussion.fragmentPager.Home.homeFragment;
import com.srx.discussion.util.HttpUtil;
import org.greenrobot.eventbus.Subscribe;

import static com.srx.discussion.Actitvity.login.USER_ID;

public class userFragment extends Fragment {

    private Button exitButton;
    private TextView userNickname;
    private TextView selfSignature;
    private TextView starPosts;
    private TextView starPost;
    private TextView follower;
    private TextView following;

    public userFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initComponent(view);
        setClickListener();
        return view;
    }


    public void setUserInfo() {
        if (HttpUtil.isLanded()) {
            if (USER_ID > 0) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AndroidUser showUserInfo = (AndroidUser) HttpUtil.showUserInfo(USER_ID);
                        int starPostCount = HttpUtil.showUserStarPost(USER_ID).size();
                        int starPostsCount = HttpUtil.showUserStarPosts(USER_ID).size();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                userNickname.setText(showUserInfo.getNickname());
                                selfSignature.setText(showUserInfo.getSelfSignature());
                                starPost.setText(starPostCount+"\n收藏贴子");
                                starPosts.setText(starPostsCount+"\n收藏贴吧");
                            }
                        });
                    }
                }).start();
            } else {
                Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
            }
        } else {
            SharedPreferences sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            if (sp.getBoolean("autoLogin", false)) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Integer login = HttpUtil.login(sp.getString("username", ""), sp.getString("password", ""));
                        if (login > 0) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    USER_ID = login;
                                    Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            } else {
                Intent intent = new Intent(getActivity(), login.class);
                startActivity(intent);
            }
        }
    }


    public void setClickListener() {
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    public void initComponent(View view) {
        this.exitButton = view.findViewById(R.id.exitButton);
        this.follower = view.findViewById(R.id.follower);
        this.following = view.findViewById(R.id.following);
        this.selfSignature = view.findViewById(R.id.self_signature);
        this.starPost = view.findViewById(R.id.star_post);
        this.starPosts = view.findViewById(R.id.star_posts);
        this.userNickname = view.findViewById(R.id.user_nickName);
    }

    public void signOut() {
        SharedPreferences sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit();
        edit.clear();
        edit.commit();
        HttpUtil.clearSession();
        Toast.makeText(getActivity(), "退出成功!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

}
