package com.srx.test2.fragment;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.DB.DBMethod;
import com.srx.test2.R;
import com.srx.test2.adapter.WordListAdapter;
import com.srx.test2.entities.Word;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordListFragment extends Fragment {

    private List<Word> list = new ArrayList<>();
    private Context context;
    private WordListAdapter adapter;
    private DBMethod dbMethod;
    private String word_id = "17";
    private DetailFragment detailFragment;

    public WordListFragment() {
        // Required empty public constructor
    }

    public WordListFragment(List<Word> list, Context context, DBMethod dbMethod) {
        this.list = list;
        this.context = context;
        this.dbMethod = dbMethod;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_list, container, false);
        initRecycleView(view, this.list);
//        this.word_id=getWordId();
        return view;
    }

    public void Resume(DBMethod dbMethod) {
        View view = getView();
        this.dbMethod = dbMethod;
        initRecycleView(view, dbMethod.queryWord());
    }

    public void queryWord(DBMethod dbMethod, String string) {
        View view = getView();
        this.dbMethod = dbMethod;
        initRecycleView(view, dbMethod.queryWordByBlurry(string));
    }

    public void initRecycleView(View view, List<Word> list) {
        RecyclerView recyclerView = view.findViewById(R.id.word_list_fragment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        setDetailFragment();
        adapter = new WordListAdapter(list);
        adapter.setOnItemClick(new WordListAdapter.OnItemClickListener() {
            //应在此方法中利用id，查询数据库，并将返回的数据封装为一个javabean，并set各个textView
            @Override
            public void OnItemClick(View v, int position, String id) {
                word_id = id;
                detailFragment.init(dbMethod);
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public WordListAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDetailFragment();
    }

    public void setDetailFragment() {
        detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("word_id", word_id);
        detailFragment.setArguments(bundle);
        this.getFragmentManager()
                .beginTransaction()
                .replace(R.id.detailFragment, detailFragment)
                .commit();
    }

    public String getWordId() {
        String word_title = adapter.getWord_title();
        String word_mean = adapter.getWord_mean();
        return dbMethod.queryWordId(word_title, word_mean);
    }

}
