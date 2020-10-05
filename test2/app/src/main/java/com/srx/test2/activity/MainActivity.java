package com.srx.test2.activity;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.R;
import com.srx.test2.adapter.WordListAdapter;
import com.srx.test2.contentProvider.ContentProviderUtil;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.Word;
import com.srx.test2.fragment.WordListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchText;
    private List<Word> wordList = new ArrayList<>();
    private WordListAdapter wordAdapter;
    private WordListFragment listFragment;
    private ContentProviderUtil util;
    private ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        if (isLand()) {
            setContentView(R.layout.land);
            initComponent();
            initResolverAndUtil();
            initList();
            listFragment = new WordListFragment(wordList, MainActivity.this, util);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.listFragment, listFragment)
                    .commit();
        } else {
            setContentView(R.layout.activity_main);
            initComponent();
            initResolverAndUtil();
            initList();
            initRecyclerView(wordList);
        }
    }

    public void initResolverAndUtil() {
        this.resolver = getContentResolver();
        this.util = new ContentProviderUtil(this.resolver);
    }

    //调取数据库中数据，并以list存储，以便在recyclerView中使用
    public void initList() {
        wordList = util.queryWord();
    }

    public void initComponent() {
        searchText = findViewById(R.id.edit_query);

    }

    public List<Word> refreshList() {
        List<Word> words = util.queryWord();
        return words;
    }

    public void initAdapter() {
        wordAdapter = listFragment.getAdapter();
    }


    /**
     * 初始化recyclerView，但目前暂定为只有竖屏时才会加载这个recyclerView。
     * 如果是横屏，直接加载wordListFragment就ok了，会在wordListFragment中对recyclerView进行初始化和调用
     */
    public void initRecyclerView(List<Word> list) {
        RecyclerView recyclerView = findViewById(R.id.word_list_activity);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        wordAdapter = new WordListAdapter(list);
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
            util.insertWord(new Word(word, wordMean));
            String wordId = util.queryWordId(word, wordMean);
            String[] sentenceLists = data.getStringArrayExtra("sentenceList");
            String[] sentenceMeanLists = data.getStringArrayExtra("sentenceMeanList");
            for (int i = 0; i < sentenceLists.length; i++) {
                util.insertSentence(new ExampleSentence(wordId, sentenceLists[i], sentenceMeanLists[i]));
            }
        }
        if (isLand()) {
            listFragment.Resume(util);
        } else {
            initRecyclerView(refreshList());
        }
    }


    /**
     * 用于点击搜索时查询单词
     *
     * @param view
     */

    public void queryWord(View view) {
        String string = searchText.getText().toString();
        if (isLand()) {
            listFragment.queryWord(util, string);
        } else {
            List<Word> words = util.queryWordByBlurry(string);
            initRecyclerView(words);
        }
    }

    /**
     * 以下代码为上下文菜单，用于删除单词
     * 其中onCreateContextMenu放在了recyclerView的适配器中
     */
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                new AlertDialog.Builder(this)
                        .setTitle("")
                        .setMessage("确定要删除该单词吗")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (isLand()) {
                                    // 只有在横屏时，才会创建wordListFragment。
                                    // 此时才可以通过该方法获取到横屏时wordListFragment的adapter
                                    // 若是竖屏，那么就会调用initRecyclerView方法，对adapter进行初始化
                                    initAdapter();
                                    util.deleteWord(wordAdapter.getWordId());//通过适配器中的get方法获取单词id
                                    util.deleteSentenceByWord(wordAdapter.getWordId());
                                    listFragment.Resume(util);
                                } else {
                                    util.deleteWord(wordAdapter.getWordId());//通过适配器中的get方法获取单词id
                                    util.deleteSentenceByWord(wordAdapter.getWordId());
                                    initRecyclerView(refreshList());
                                }
                            }
                        }).show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    public boolean isLand() {
        Configuration configuration = this.getResources().getConfiguration();
        int orientation = configuration.orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return true;
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            return false;
        }
        return false;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.land);
            initComponent();
            initResolverAndUtil();
            initList();
            listFragment = new WordListFragment(wordList, MainActivity.this, util);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.listFragment, listFragment)
                    .commit();
            Toast.makeText(this, "现在是横屏", Toast.LENGTH_LONG).show();
        } else {
            setContentView(R.layout.activity_main);
            initRecyclerView(wordList);
            initComponent();
            initResolverAndUtil();
            initList();
            Toast.makeText(this, "现在是竖屏", Toast.LENGTH_LONG).show();
        }
    }
}
