package com.srx.test2.activity;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.srx.test2.Api.TransApi;
import com.srx.test2.R;
import com.srx.test2.adapter.WordListAdapter;
import com.srx.test2.contentProvider.ContentProviderUtil;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.ResultObject;
import com.srx.test2.entities.Word;
import com.srx.test2.fragment.WordListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchText;
    private List<Word> wordList = new ArrayList<>();
    private WordListAdapter wordAdapter;
    private WordListFragment listFragment;
    private ContentProviderUtil util;
    private ContentResolver resolver;
    private Word ApiWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        //以下代码会通过判断是横屏还是竖屏分别加载不同的布局，并且做不同的初始化
        //竖屏时是初始化RecyclerView，横屏时是初始化wordFragment，并在wordFragment中对DetailFragment进行初始化
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

    /**
     * 初始化contentResolver，以及其工具类，用以下面对util中的方法的使用
     */
    public void initResolverAndUtil() {
        this.resolver = getContentResolver();
        this.util = new ContentProviderUtil(this.resolver);
    }

    /**
     * 调取数据库中数据，并以list存储，以便在recyclerView中使用
     */
    public void initList() {
        wordList = util.queryWord();
    }

    /**
     * 初始化各种view组件，这里只有搜索框
     */
    public void initComponent() {
        searchText = findViewById(R.id.edit_query);
    }

    /**
     * 刷新列表
     *
     * @return
     */
    public List<Word> refreshList() {
        List<Word> words = util.queryWord();
        return words;
    }

    /**
     * 用于初始化单词列表的adapter
     */
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
                if (ApiWord != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("word", ApiWord);
                    intent.putExtra("word", bundle);
                } else {
                    intent.putExtra("word_id", id);
                }
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
            case R.id.help:
                new AlertDialog.Builder(this)
                        .setMessage("目前百度翻译功能暂不支持例句，" +
                                "读音功能仅支持单个单词的英文，但其提供了29种语言互译（请在竖屏时使用该功能）")
                        .setTitle("帮助")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", null)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * intent的回调函数，用于用户在insertActivity中添加单词后根据返回状态码，以处理返回的数据
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
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
        } else if (requestCode == 111 && resultCode == 333) {
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

    public void queryDatabase(View view) {
        String string = searchText.getText().toString();
        if (isLand()) {
            listFragment.queryWord(util, string);
        } else {
            List<Word> words = util.queryWordByBlurry(string);
            initRecyclerView(words);
        }
    }

    /**
     * 以下代码为上下文菜单，用于删除单词，更改单词
     * 其中onCreateContextMenu放在了recyclerView的适配器中(重点)
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
            case 1:
                View dialog = LayoutInflater.from(this).inflate(R.layout.my_dialog, null, false);
                final EditText word = dialog.findViewById(R.id.dialog_word);
                final EditText wordMean = dialog.findViewById(R.id.dialog_word_mean);
                new AlertDialog.Builder(this)
                        .setView(dialog)
                        .setNegativeButton("取消", null)
                        .setPositiveButton("更改", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String wordTitle = word.getText().toString();
                                String wordMean1 = wordMean.getText().toString();
                                if (isLand()) {
                                    // 只有在横屏时，才会创建wordListFragment。
                                    // 此时才可以通过该方法获取到横屏时wordListFragment的adapter
                                    // 若是竖屏，那么就会调用initRecyclerView方法，对adapter进行初始化
                                    initAdapter();
                                    util.updateWord(new Word(wordAdapter.getWordId(), wordTitle, wordMean1));
                                    listFragment.Resume(util);
                                } else {
                                    util.updateWord(new Word(wordAdapter.getWordId(), wordTitle, wordMean1));
                                    initRecyclerView(refreshList());
                                }
                            }
                        }).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * 用于判断是横屏还是竖屏
     *
     * @return
     */
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


    /**
     * 用于横竖屏切换
     *
     * @param newConfig
     */
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


    /**
     * 以下代码是使用okHttp进行网络访问，以调用有道词典api实现单词查询功能
     */

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            List<Word> words = new ArrayList<>();
            String jsonString = (String) msg.obj;
            Gson gson = new Gson();
            ResultObject resultObject = gson.fromJson(jsonString, ResultObject.class);
            List<ResultObject.Trans_resultEntity> list = resultObject.getTrans_result();
            for (ResultObject.Trans_resultEntity entity : list) {
                String english = entity.getDst();
                String chinese = entity.getSrc();
                Word word = new Word(chinese, english);
                ApiWord = word;
                words.add(word);
            }
            initRecyclerView(words);
        }
    };

    public void queryWord(final String query) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                HashMap<String, Object> map = new HashMap<>();
                TransApi api = new TransApi("20200312000397153", "BT5RjK9zi8m3hwJbJuM9");
                String transResult = api.getTransResult(query, "auto", "auto");
                message.obj = transResult;
                handler.sendMessage(message);
                Log.e("srx.queryWord", "queryWord: " + transResult);
            }
        }).start();
    }


    /**
     * 在按钮被点击时启动线程开始查询api
     *
     * @param view
     */
    public void queryAip(View view) {
        String s = searchText.getText().toString();
        queryWord(s);
    }
}
