package com.srx.test2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.R;
import com.srx.test2.entities.ExampleSentence;

import java.util.List;

/**
 * @author srx
 * @description
 * @create 2020-09-23 19:38:09
 */
public class ExampleSentenceAdapter extends RecyclerView.Adapter<ExampleSentenceAdapter.ViewHolder> {

    private List<ExampleSentence> list;
    //该变量是自定义接口OnItemClickListener的对象，而非导入包的变量
    //这是一个接口对象，如果要使用set方法对其进行初始化的话，需要new一个接口对象并，实现该接口中的方法
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener){
        this.listener=listener;
    }

    public interface OnItemClickListener{
        void OnItemClick(View view,int position,String sentence);
    }

    public ExampleSentenceAdapter(List<ExampleSentence> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sentence_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ExampleSentence exampleSentence = list.get(position);
        holder.mean.setText(exampleSentence.getMean());
        holder.sentence.setText(exampleSentence.getSentence());
        holder.sentenceId.setText((position+1)+". ");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    listener.OnItemClick(view,position,exampleSentence.getSentence());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sentence, mean,sentenceId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.sentenceId=itemView.findViewById(R.id.sentence_id);
            this.sentence = itemView.findViewById(R.id.sentence);
            this.mean = itemView.findViewById(R.id.sentence_mean);
        }
    }
}
