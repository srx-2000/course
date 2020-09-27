package com.srx.test2.fragment;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.R;
import com.srx.test2.adapter.WordListAdapter;
import com.srx.test2.entities.Word;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordListFragment extends Fragment {

    private List<Word> list=new ArrayList<>();
    private Context context;

    public WordListFragment() {
        // Required empty public constructor
    }

    public WordListFragment(List<Word> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_word_list, container, false);
        initRecycleView(view);
        return view;

    }

    public void initRecycleView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.word_list_fragment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        WordListAdapter adapter = new WordListAdapter(list);
        adapter.setOnItemClick(new WordListAdapter.OnItemClickListener() {
            //应在此方法中利用id，查询数据库，并将返回的数据封装为一个javabean，并set各个textView
            @Override
            public void OnItemClick(View v, int position, String id) {
//                Word word = list.get(position);

            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
