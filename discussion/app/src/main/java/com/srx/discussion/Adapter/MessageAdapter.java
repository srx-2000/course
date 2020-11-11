package com.srx.discussion.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ReplyList;
import com.srx.discussion.entity.base.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyHolder> {
    private List<Message> list;

    public MessageAdapter(List<Message> list) {
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
        Message message = list.get(position);
        holder.time.setText(message.getCreateTime());
        holder.nickname.setText(message.getUserNickname());
        holder.replyContent.setText(message.getContent());
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
