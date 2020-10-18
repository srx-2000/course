package com.srx.musicplayer.MusicList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.musicplayer.R;
import com.srx.musicplayer.jsonEntity.Song;

import java.util.List;
import java.util.zip.Inflater;

public class songListAdapter extends RecyclerView.Adapter<songListAdapter.MyHolder> {

    private List<Song> songList;
    private OnItemClickListener listener;

    public songListAdapter(List<Song> songList) {
        this.songList = songList;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void OnItemClickForDelete(View view, long songId, int position);

        void OnItemClickForSelect(View view, long songId);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        Song song = songList.get(position);
        final long songId = song.getSongId();
        holder.id.setText(String.valueOf(position + 1));
        holder.singer.setText(song.getSinger());
        holder.title.setText(song.getSongName());
        //给删除这个imageButton设置点击事件，这里之所以用songId而非position是因为歌曲列表是随机波动的
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnItemClickForDelete(view, songId, position);
                }
            }
        });
        //给整个item设置点击事件，当整个item被点击之后，歌曲切换。
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.OnItemClickForSelect(v, songId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView id, singer, title;
        private ImageButton delete;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            singer = itemView.findViewById(R.id.singer);
            id = itemView.findViewById(R.id.index);
            delete = itemView.findViewById(R.id.deleteSingleSong);
        }
    }


}
