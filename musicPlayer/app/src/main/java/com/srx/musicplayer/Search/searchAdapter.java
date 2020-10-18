package com.srx.musicplayer.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.musicplayer.R;
import com.srx.musicplayer.jsonEntity.Song;

import java.util.ArrayList;
import java.util.List;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.MyHolder> {

    private List<Song> list;

    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public searchAdapter(List<Song> list) {
        this.list = list;
    }


    public interface OnItemClickListener {
        void OnItemClickForAdd(View view, long songId, int position);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_search_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        Song song = list.get(position);
        final long songId = song.getSongId();
        holder.index.setText(String.valueOf(position + 1));
        holder.singer.setText(song.getSinger());
        holder.title.setText(song.getSongName());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.OnItemClickForAdd(v, songId, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView title, singer, index;
        private ImageButton add;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.search_title);
            singer = itemView.findViewById(R.id.search_singer);
            index = itemView.findViewById(R.id.search_index);
            add = itemView.findViewById(R.id.add_song);
        }

    }
}
