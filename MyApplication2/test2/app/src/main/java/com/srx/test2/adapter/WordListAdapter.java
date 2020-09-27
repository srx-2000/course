package com.srx.test2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public interface OnItemClickListener {
        void OnItemClick(View v, int position, String id);
    }

    public void setOnItemClick(OnItemClickListener listener) {
        this.listener = listener;
    }


    public WordListAdapter(List<Word> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView word, mean, id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.id = itemView.findViewById(R.id.word_id);
            this.word = itemView.findViewById(R.id.word);
            this.mean = itemView.findViewById(R.id.mean);
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnItemClick(view, position, list.get(position).getWordId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
