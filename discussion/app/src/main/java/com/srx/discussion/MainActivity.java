package com.srx.discussion;

import android.annotation.SuppressLint;
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
import com.srx.discussion.entity.base.AndroidPost;
import com.srx.discussion.fragmentPager.Home.homeFragment;
import com.srx.discussion.fragmentPager.Search.searchFragment;
import com.srx.discussion.fragmentPager.User.userFragment;
import com.srx.discussion.fragmentPager.message.messageFragment;
import com.srx.discussion.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里有一个大的概念设想——一个用户在登录之后这个session就会一直存在，直达用户注销登录
 */

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private List<Fragment> fragmentList;
    private List<ImageView> imageViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println(login);
//                List<AndroidPost> showUserInfo = (List<AndroidPost>) HttpUtil.showHomePostList(1, 2);
//                for (AndroidPost a : showUserInfo) {
//                    Log.d("TAG", "onCreate: " + a.toString());
//                    System.out.println(a.toString());
//                }
                HttpUtil.login("srx1","srx1");
                String result = HttpUtil.updateUserInfo(10, "備er", null, null, null, null);
//                String register = HttpUtil.register("user1", "user1", "user12@qq.com", "1");
//                String result = HttpUtil.starPost(1);
                System.out.println(result);
                Log.d("TAG", "run: "+result);

            }
        }).start();
        initViewPager();
        initFootBar();
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
        fragmentList.add(new homeFragment());
        fragmentList.add(new searchFragment());
        fragmentList.add(new messageFragment());
        fragmentList.add(new userFragment());
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
