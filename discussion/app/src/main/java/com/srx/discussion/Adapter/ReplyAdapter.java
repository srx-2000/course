package com.srx.discussion.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ReplyList;
import com.srx.discussion.util.TimeUtil;

import java.util.List;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.MyHolder> {
    private List<ReplyList.ReplyListEntity> replyList;

    private OnItemClickListener listener;


    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ReplyAdapter(List<ReplyList.ReplyListEntity> replyList) {
        this.replyList = replyList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reply_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        ReplyList.ReplyListEntity replyListEntity = replyList.get(position);
        String createTime = replyListEntity.getCreateTime();
        String duringTime = TimeUtil.getDuringTime(createTime);
        holder.replyTime.setText(duringTime);
        holder.replyContent.setText(replyListEntity.getReplyContext());
        if (replyListEntity.getTargetManNickname() != null) {
            holder.firstReplyMan.setText(replyListEntity.getReplyManNickname());
            holder.secondReplyMan.setText(replyListEntity.getTargetManNickname());
        }else {
            holder.firstReplyMan.setText(replyListEntity.getReplyManNickname());
            holder.secondReplyMan.setVisibility(View.GONE);
            holder.itemView.findViewById(R.id.reply_filling).setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnReplySelect(v,replyListEntity.getReplyId(),replyListEntity.getTargetComment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return replyList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        private TextView firstReplyMan, secondReplyMan, replyContent, replyTime;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.firstReplyMan = itemView.findViewById(R.id.first_reply_man);
            this.secondReplyMan = itemView.findViewById(R.id.second_reply_man);
            this.replyContent = itemView.findViewById(R.id.reply_content);
            this.replyTime = itemView.findViewById(R.id.reply_time);
        }
    }

    public interface OnItemClickListener {
        void OnReplySelect(View view, Integer ReplyId,Integer commentId);
    }
}
