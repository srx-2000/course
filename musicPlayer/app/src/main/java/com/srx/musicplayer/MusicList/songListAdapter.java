package com.srx.musicplayer.MusicList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.musicplayer.R;
import com.srx.musicplayer.jsonEntity.Song;

import java.util.List;
import java.util.zip.Inflater;

public class songListAdapter extends RecyclerView.Adapter<songListAdapter.MyHolder> {

    private List<Song> songList;


    public songListAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Song song = songList.get(position);
        holder.id.setText(String.valueOf(position+1));
        holder.singer.setText(song.getSinger());
        holder.title.setText(song.getSongName());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView id,singer,title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            singer=itemView.findViewById(R.id.singer);
            id=itemView.findViewById(R.id.index);
        }
    }


}
