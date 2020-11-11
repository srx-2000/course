package com.srx.discussion.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.R;
import com.srx.discussion.entity.base.AndroidPostDetail;
import com.srx.discussion.util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyHolder> {
    private List<AndroidPostDetail.CommentListEntity> commentList;
    private onItemClickListener listener;

    public void setListener(onItemClickListener listener) {
        this.listener = listener;
    }

    public CommentAdapter(List<AndroidPostDetail.CommentListEntity> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        AndroidPostDetail.CommentListEntity commentListEntity = commentList.get(position);
        holder.floor.setText((position + 1) + "楼");
        holder.commentContent.setText(commentListEntity.getCommentContext());
        holder.time.setText(TimeUtil.getDuringTime(commentListEntity.getCreateTime()));
        holder.userNickname.setText(commentListEntity.getCommentManUsername());
        holder.replyCount.setText("共有" + commentListEntity.getReplyCount() + "条回复");
        holder.replyCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onReplyClick(v, commentListEntity.getCommentId());
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCommentClick(v,commentListEntity.getCommentId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }


    public static class MyHolder extends RecyclerView.ViewHolder {
        private TextView userNickname, time, floor, commentContent, replyCount;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.userNickname = itemView.findViewById(R.id.user_nickName);
            this.time = itemView.findViewById(R.id.comment_time);
            this.floor = itemView.findViewById(R.id.position_num);
            this.commentContent = itemView.findViewById(R.id.comment_content);
            this.replyCount = itemView.findViewById(R.id.reply_count);
        }
    }

    public interface onItemClickListener {
        void onReplyClick(View view, Integer commentId);

        void onCommentClick(View view, Integer commentId);
    }
}
