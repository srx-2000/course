package com.srx.musicplayer.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.musicplayer.R;

import java.util.List;

public class hotAdapter extends RecyclerView.Adapter<hotAdapter.MyHolder> {

    private List<String> list;

    public hotAdapter(List<String> list) {
        this.list = list;
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView id,title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.id=itemView.findViewById(R.id.hot_id);
            this.title=itemView.findViewById(R.id.hot_title);
        }
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String s = list.get(position);
        holder.id.setText(String.valueOf(position+1));
        holder.title.setText(s);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
