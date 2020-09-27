package com.srx.test2.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.DB.DBMethod;
import com.srx.test2.R;
import com.srx.test2.adapter.WordListAdapter;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.Word;
import com.srx.test2.fragment.DetailFragment;
import com.srx.test2.fragment.WordListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchText;
    private List<Word> wordList = new ArrayList<>();
    private DBMethod dbMethod = new DBMethod(this, "wordBook");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        setContentView(R.layout.activity_main);
        initComponent();
        initList();
        Configuration configuration = this.getResources().getConfiguration();
        int orientation = configuration.orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            WordListFragment listFragment = new WordListFragment(wordList, MainActivity.this);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.listFragment, listFragment)
                    .commit();
            DetailFragment detailFragment = new DetailFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detailFragment, detailFragment)
                    .commit();
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            initRecyclerView(wordList);
        }
    }

    //调取数据库中数据，并以list存储，以便在recyclerView中使用
    public void initList() {
        wordList = dbMethod.queryWord();
    }

    public void initComponent() {
        searchText = findViewById(R.id.edit_query);

    }

    /**
     * 初始化recyclerView，但目前暂定为只有竖屏时才会加载这个recyclerView。
     * 如果是横屏，直接加载wordListFragment就ok了，会在wordListFragment中对recyclerView进行初始化和调用
     */
    public void initRecyclerView(List<Word> list) {
        RecyclerView recyclerView = findViewById(R.id.word_list_activity);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        WordListAdapter wordAdapter = new WordListAdapter(list);
        wordAdapter.setOnItemClick(new WordListAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position, String id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("word_id", id);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(wordAdapter);
    }

    /**
     * 选项菜单，用于增加单词
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.word_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.insert:
                Intent intent = new Intent(this, insertWord.class);
                startActivityForResult(intent, 111);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == 222) {
            String word = data.getStringExtra("word");
            String wordMean = data.getStringExtra("wordMean");
            dbMethod.insertWord(new Word(word, wordMean));
            String wordId = dbMethod.queryWordId(word, wordMean);
            String[] sentenceLists = data.getStringArrayExtra("sentenceList");
            String[] sentenceMeanLists = data.getStringArrayExtra("sentenceMeanList");
            for (int i = 0; i < sentenceLists.length; i++) {
                dbMethod.insertSentence(new ExampleSentence(wordId, sentenceLists[i], sentenceMeanLists[i]));
            }
        }
    }


    /**
     * 用于点击搜索时查询单词
     * @param view
     */

    public void queryWord(View view) {
        String string = searchText.getText().toString();
        List<Word> words = dbMethod.queryWordByBlurry(string);
        initRecyclerView(words);
    }
    /**
     * 以下代码为上下文菜单，用于删除单词
     */
}