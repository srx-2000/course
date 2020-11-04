package com.srx.musicplayer;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.srx.musicplayer.Search.searchPageFragment;
import com.srx.musicplayer.MusicList.musicListPageFragment;
import com.srx.musicplayer.Player.playerPageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private List<Fragment> fragmentList;
    private List<TextView> textViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initViewPager();
        initFootBar();
    }


    public void initViewPager() {
        pager = findViewById(R.id.viewPager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new searchPageFragment());
        fragmentList.add(new playerPageFragment());
        fragmentList.add(new musicListPageFragment());
        FragmentPagerAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
    }


    @SuppressLint("ResourceAsColor")
    public void initFootBar() {
        LinearLayout layout = findViewById(R.id.main_activity_linearLayout);
        LinearLayout bar = layout.findViewById(R.id.bar);
        final int childCount = bar.getChildCount();

        for (int i = 0; i < childCount; i++) {
            textViewList.add((TextView) bar.getChildAt(i));
            textViewList.get(i).setTag(i);
            textViewList.get(i).setTypeface(Typeface.DEFAULT);
            textViewList.get(i).setTextSize(10);
            textViewList.get(i).setTextColor(R.color.shallowGray);
            textViewList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (Integer) v.getTag();
                    pager.setCurrentItem(tag);
                    setFont(tag);
                }
            });
            textViewList.get(i).setEnabled(true);
        }
        textViewList.get(0).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textViewList.get(0).setTextSize(14);
        textViewList.get(0).setTextColor(R.color.shallowBlack);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("ResourceType")
            @Override
            public void onPageSelected(int position) {
                pager.setCurrentItem(position);
                setFont(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @SuppressLint("ResourceAsColor")
    public void setFont(int position) {
        textViewList.get(position).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textViewList.get(position).setTextSize(14);
        textViewList.get(position).setTextColor(R.color.shallowBlack);
        for (int i = 0; i < textViewList.size(); i++) {
            if (i == position)
                continue;
            else {
                textViewList.get(i).setTypeface(Typeface.DEFAULT);
                textViewList.get(i).setTextSize(10);
                textViewList.get(i).setTextColor(R.color.shallowGray);
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
