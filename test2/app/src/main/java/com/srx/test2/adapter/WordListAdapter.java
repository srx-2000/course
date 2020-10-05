package com.srx.test2.adapter;

import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.R;
import com.srx.test2.entities.Word;

import java.util.List;

/**
 * @author srx
 * 22@description
 * @create 2020-09-23 14:27:44
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    private List<Word> list;
    private OnItemClickListener listener;
    private String wordId;
    private String word_mean;
    private String word_title;

    public interface OnItemClickListener {
        void OnItemClick(View v, int position, String id);
    }

    public String getWord_mean() {
        return word_mean;
    }

    public String getWord_title() {
        return word_title;
    }

    public String getWordId() {
        return wordId;
    }

    public void setOnItemClick(OnItemClickListener listener) {
        this.listener = listener;
    }


    public WordListAdapter(List<Word> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private TextView word, mean, id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.id = itemView.findViewById(R.id.word_id);
            this.word = itemView.findViewById(R.id.word);
            this.mean = itemView.findViewById(R.id.mean);
            itemView.setOnCreateContextMenuListener(this);
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0, 0, Menu.NONE, "删除");
            menu.add(0, 1, Menu.NONE, "更改");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Word wordObject = list.get(position);
        String word = wordObject.getWord();
        String wordMean = wordObject.getWordMean();
        holder.id.setText((position+1)+". ");
        holder.mean.setText(wordMean);
        holder.word.setText(word);
        final String wordId = list.get(position).getWordId();
        this.wordId=wordId;
        this.word_mean=wordMean;
        this.word_title=word;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnItemClick(view, position, wordId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
