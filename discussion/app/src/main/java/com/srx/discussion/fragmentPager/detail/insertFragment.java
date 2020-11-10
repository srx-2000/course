package com.srx.discussion.fragmentPager.detail;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ReplyToReply;
import com.srx.discussion.util.HttpUtil;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static com.srx.discussion.Actitvity.PostDetailActivity.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class insertFragment extends BottomSheetDialogFragment {

    private EditText content;
    private Button sendContentBtn;
    private Integer targetComment;
    private Integer targetReply;


    public insertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_insert, container, false);
        initComponent(inflate);
        setButtonListener(inflate);
        return inflate;
    }

    public void initComponent(View view) {
        this.content = view.findViewById(R.id.content_edit);
        this.sendContentBtn = view.findViewById(R.id.send_content_btn);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.POSTING)
    public void onEvent(java.lang.String data) {
        if (data.contains("targetReply")) {
            String[] split = data.split(":");
            targetReply = Integer.valueOf(split[1]);
            targetComment = Integer.valueOf(split[3]);
            Log.d(TAG, "onEvent: " + targetComment);
            Log.d(TAG, "onEvent: " + targetReply);
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    public void setButtonListener(View view) {
        View layout = view.findViewById(R.id.insert_content_layout);
        sendContentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contentString = insertFragment.this.content.getText().toString();
                if (content != null || !content.equals("")) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ReplyToReply replyToReply = HttpUtil.insertReplyForReply(contentString, targetComment, targetReply);
                            if (replyToReply != null) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        content.setText("");
                                        layout.setVisibility(View.GONE);
                                    }
                                });
                            } else {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(), "评论失败", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            Log.d(TAG, "run: " + replyToReply.getReplyContext());
                        }
                    }).start();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
