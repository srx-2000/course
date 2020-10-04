package com.srx.test2.fragment;


import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.DB.DBMethod;
import com.srx.test2.R;
import com.srx.test2.adapter.ExampleSentenceAdapter;
import com.srx.test2.adapter.WordListAdapter;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.Word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView word_title;
    private TextView word_mean;
    private Word word;
    private String word_id;
    private List<ExampleSentence> sentences;
    private Context context;
    private ExampleSentenceAdapter adapter;

    public DetailFragment(Context context) {
        this.context = context;
    }

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initComponent(view);
        getBundle();
        return view;
    }

    public void initComponent(View view) {
        word_title = view.findViewById(R.id.word_title);
        word_mean = view.findViewById(R.id.word_mean_activity);
    }

    public void getBundle() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            word_id = bundle.getString("word_id");
        }
    }

    public void init(DBMethod dbMethod){
        initDetail(dbMethod);
        initRecyclerView(getView());
    }

    public void initDetail(DBMethod dbMethod){
        word = dbMethod.queryWord(word_id);
        sentences = dbMethod.querySentence(word_id);
        this.word_title.setText(word.getWord());
        this.word_mean.setText(word.getWordMean());
    }

    public void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.sentence_list);
        final LinearLayoutManager manager = new LinearLayoutManager(context);
        ExampleSentenceAdapter adapter = new ExampleSentenceAdapter(sentences);
        adapter.setListener(new ExampleSentenceAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, String sentence) {
//
            }
        });
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


}
