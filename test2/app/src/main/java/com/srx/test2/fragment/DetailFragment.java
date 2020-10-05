package com.srx.test2.fragment;


import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.R;
import com.srx.test2.adapter.ExampleSentenceAdapter;
import com.srx.test2.contentProvider.ContentProviderUtil;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.Word;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView word_title;
    private TextView word_mean;
    private Word word;
    private List<ExampleSentence> sentences;
    private Context context;

    public DetailFragment(Context context) {
        this.context = context;
    }

    public DetailFragment() {
//        initComponent(getView());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initComponent(view);
        initRecyclerView(view);
        this.word_title.setText(word.getWord());
        this.word_mean.setText(word.getWordMean());
        return view;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initComponent(getView());
//    }

    public void initComponent(View view) {
        word_title = view.findViewById(R.id.word_title);
        word_mean = view.findViewById(R.id.word_mean_activity);
    }

//    public void getBundle() {
//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            word_id = bundle.getString("word_id");
//        }
//    }


    public void initDetail(ContentProviderUtil util,String wordId){
        word = util.queryWord(wordId);
        sentences = util.querySentence(wordId);
    }

    public void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.sentence_list);
        final LinearLayoutManager manager = new LinearLayoutManager(context);
        ExampleSentenceAdapter adapter = new ExampleSentenceAdapter(sentences);
        adapter.setListener(new ExampleSentenceAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, String sentence) {
            }
        });
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


}
