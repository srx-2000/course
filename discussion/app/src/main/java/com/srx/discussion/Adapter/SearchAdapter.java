package com.srx.discussion.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.StarPosts;
import com.srx.discussion.entity.base.AndroidUserToPosts;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder> {

    private List<AndroidUserToPosts> list;

    public OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SearchAdapter(List<AndroidUserToPosts> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.start_posts_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        AndroidUserToPosts starPosts = list.get(position);
        holder.star_posts.setText(starPosts.getPostsTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnPostsSelected(v,starPosts.getPostsId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        TextView star_posts;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            star_posts=itemView.findViewById(R.id.star_posts);
        }
    }

    public interface OnItemClickListener{
        void OnPostsSelected(View v,Integer postId);
    }
}
