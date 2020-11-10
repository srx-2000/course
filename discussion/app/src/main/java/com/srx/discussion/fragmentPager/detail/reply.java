package com.srx.discussion.fragmentPager.detail;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.srx.discussion.Actitvity.login;
import com.srx.discussion.Adapter.ReplyAdapter;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ReplyList;
import com.srx.discussion.fragmentPager.User.userFragment;
import com.srx.discussion.util.HttpUtil;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class reply extends BottomSheetDialogFragment {

    private RecyclerView recyclerView;
    private TextView loading;
    private List<ReplyList.ReplyListEntity> replyList = new ArrayList<>();
    private static String TAG = "石荣兴";
    private com.srx.discussion.fragmentPager.detail.insertFragment insertFragment;

    public reply() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reply, container, false);
        initComponent(view);
        return view;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(List<ReplyList.ReplyListEntity> data) {
        this.replyList = data;
        for (ReplyList.ReplyListEntity r : data) {
            Log.d(TAG, "onEvent: " + r.getReplyManNickname());
        }
        loading.setVisibility(View.GONE);
        initRecyclerView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    public void initComponent(View view) {
        recyclerView = view.findViewById(R.id.reply_recyclerView);
        loading = view.findViewById(R.id.loading);
    }

    public void initRecyclerView() {
        ReplyAdapter replyAdapter = new ReplyAdapter(replyList);
        replyAdapter.setListener(new ReplyAdapter.OnItemClickListener() {
            @Override
            public void OnReplySelect(View view, Integer targetReplyId, Integer commentId) {
                if (HttpUtil.isLanded()) {
                    if (insertFragment == null)
                        insertFragment = new insertFragment();
                    insertFragment.show(getActivity().getSupportFragmentManager(), "Dialog");
                    EventBus.getDefault().postSticky("targetReplyId:" + targetReplyId + ":commentId:" + commentId);
                }else{
                    Intent intent = new Intent(getActivity(), login.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView.setAdapter(replyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
