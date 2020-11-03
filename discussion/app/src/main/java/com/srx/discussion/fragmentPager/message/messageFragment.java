package com.srx.discussion.fragmentPager.message;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srx.discussion.R;
import com.srx.discussion.util.HttpUtil;

public class messageFragment extends Fragment {
    public messageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void login(final String username, final String password) {
        if (!HttpUtil.isLanded()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpUtil.login(username,password);
                }
            }).start();
        }
    }
}
