package com.srx.discussion.Actitvity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.srx.discussion.R;
import com.srx.discussion.entity.base.AndroidPost;
import com.srx.discussion.fragmentPager.Home.homeFragment;
import com.srx.discussion.fragmentPager.Search.searchFragment;
import com.srx.discussion.fragmentPager.User.userFragment;
import com.srx.discussion.fragmentPager.message.messageFragment;
import com.srx.discussion.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里有一个大的概念设想————一个用户在登录之后这个session就会一直存在，直达用户注销登录
 * 后发现无法使用静态变量进行存储，在每次重新进入之后，变量会被删除。
 * 所以改为了使用sharePreference进行存储，如果用户选择了自动登录的选线之后，就在每次进入app时读取并自动重新获取session
 */

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private List<Fragment> fragmentList;
    private List<ImageView> imageViewList = new ArrayList<>();
    private com.srx.discussion.fragmentPager.User.userFragment userFragment;
    private com.srx.discussion.fragmentPager.message.messageFragment messageFragment;
    private com.srx.discussion.fragmentPager.Search.searchFragment searchFragment;
    private com.srx.discussion.fragmentPager.Home.homeFragment homeFragment;
    private ImageView pushPyq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initViewPager();
        initFootBar();
        pushPyq = findViewById(R.id.postpyq);
        pushPyq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, insertPyq.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        pager.setCurrentItem(0);
        homeFragment.getHomePostList(homeFragment.refreshCount);
    }

    @SuppressLint("ResourceAsColor")
    private void initFootBar() {
        LinearLayout layout = findViewById(R.id.main_activity_linearLayout);
        LinearLayout bar = layout.findViewById(R.id.bar);
        final int childCount = bar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != 2) {
                imageViewList.add((ImageView) bar.getChildAt(i));
                if (i > 2) {
                    i--;
                }
                imageViewList.get(i).setTag(i);
                imageViewList.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int tag = (Integer) v.getTag();
                        pager.setCurrentItem(tag);
                        setImageFont(tag);
                    }
                });
                imageViewList.get(i).setEnabled(true);
                if (i > 1) {
                    i++;
                }
            }
        }
        imageViewList.get(0).setImageResource(R.drawable.home_bk);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("ResourceType")
            @Override
            public void onPageSelected(int position) {
                pager.setCurrentItem(position);
                if (position == 3)
                    if (!HttpUtil.isLanded()) {
                        Intent intent = new Intent(MainActivity.this, login.class);
                        startActivity(intent);
                    } else {
                        userFragment.setUserInfo();
                    }
                if (position == 1) {
                    if (!HttpUtil.isLanded()) {
                        Intent intent = new Intent(MainActivity.this, login.class);
                        startActivity(intent);
                    } else {
                        searchFragment.setData();
                    }
                }
                setImageFont(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void initViewPager() {
        pager = findViewById(R.id.viewPager);
        fragmentList = new ArrayList<>();
        homeFragment = new homeFragment();
        searchFragment = new searchFragment();
        messageFragment = new messageFragment();
        userFragment = new userFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(searchFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(userFragment);
        FragmentPagerAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(4);
    }

    /**
     * 设置fragment切换后图片的变化
     *
     * @param position
     */
    @SuppressLint("ResourceAsColor")
    public void setImageFont(int position) {
        switch (position) {
            case 0:
                imageViewList.get(position).setImageResource(R.drawable.home_bk);
                break;
            case 1:
                imageViewList.get(position).setImageResource(R.drawable.search_bk);
                break;
            case 2:
                imageViewList.get(position).setImageResource(R.drawable.message_bk);
                break;
            case 3:
                imageViewList.get(position).setImageResource(R.drawable.user_bk);
                break;
        }
        for (int i = 0; i < imageViewList.size(); i++) {
            if (i == position)
                continue;
            else {
                switch (i) {
                    case 0:
                        imageViewList.get(i).setImageResource(R.drawable.home);
                        break;
                    case 1:
                        imageViewList.get(i).setImageResource(R.drawable.search);
                        break;
                    case 2:
                        imageViewList.get(i).setImageResource(R.drawable.message);
                        break;
                    case 3:
                        imageViewList.get(i).setImageResource(R.drawable.user);
                        break;
                }
            }
        }
    }


    /**
     * viewPager的适配器
     */
    public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
