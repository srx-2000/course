package com.srx.discussion.Adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.R;
import com.srx.discussion.entity.base.AndroidPost;
import com.srx.discussion.util.TimeUtil;

import java.util.List;

public class postsAdapter extends RecyclerView.Adapter<postsAdapter.MyHolder> {

    private List<AndroidPost> postList;
    private onItemClickListener listener;

    public void setListener(onItemClickListener listener) {
        this.listener = listener;
    }

    public postsAdapter(List<AndroidPost> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new MyHolder(inflate);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        AndroidPost androidPost = postList.get(position);
        holder.postTitle.setText(androidPost.getPostTitle());
        holder.postTime.setText(TimeUtil.getDuringTime(androidPost.getCreateTime()));
        holder.postManNickname.setText(androidPost.getPostManNickname());
        holder.postContent.setText(androidPost.getPostContent());
        holder.commentCount.setText(androidPost.getCommentCount() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemSelectClick(v, androidPost.getPostId());
            }
        });
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView postTitle, postManNickname, postTime, postsTitle, postContent, commentCount;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.postContent = itemView.findViewById(R.id.post_content);
            this.postManNickname = itemView.findViewById(R.id.user_nickName);
            this.postsTitle = itemView.findViewById(R.id.posts_title);
            this.postTime = itemView.findViewById(R.id.post_time);
            this.postTitle = itemView.findViewById(R.id.post_title);
            this.commentCount = itemView.findViewById(R.id.comment_count);
        }
    }

    public interface onItemClickListener {
        void onItemSelectClick(View view, Integer postId);
    }


}
