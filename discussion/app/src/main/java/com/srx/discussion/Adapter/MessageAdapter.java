package com.srx.discussion.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ReplyList;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyHolder> {
    private List<ReplyList.ReplyListEntity> list;

    public MessageAdapter(List<ReplyList.ReplyListEntity> list) {
        this.list = list;
    }

    @NonNull
    @Override

    public MessageAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MyHolder holder, int position) {
        ReplyList.ReplyListEntity replyListEntity = list.get(position);
        holder.time.setText(replyListEntity.getCreateTime());
        holder.nickname.setText(replyListEntity.getReplyManNickname());
        holder.replyContent.setText(replyListEntity.getReplyContext());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView nickname, time, replyContent;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.nickname = itemView.findViewById(R.id.nickname);
            this.replyContent = itemView.findViewById(R.id.reply_content);
            this.time = itemView.findViewById(R.id.time);
        }
    }
}
