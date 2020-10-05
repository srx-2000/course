package com.srx.test2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.R;
import com.srx.test2.Service.MediaPlayerService;
import com.srx.test2.adapter.ExampleSentenceAdapter;
import com.srx.test2.contentProvider.ContentProviderUtil;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.Word;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView wordMean;
    private TextView word;
    private List<ExampleSentence> list = new ArrayList<>();
    private ContentProviderUtil util;
    private String word_id;

//    public void player(String query) {
//        SurfaceView surfaceView = new SurfaceView(this);
//        MediaPlayerHelper.getInstance().setSurfaceView(surfaceView).play("http://dict.youdao.com/dictvoice?type=0&audio=" + query+".mp3");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initComponent();
        initDetail();
//        if (this.word_id != null) {
            initRecyclerView();
//        }
    }

    public void initDetail() {
        Intent intent = getIntent();
        word_id = intent.getStringExtra("word_id");
        if (word_id != null) {
            list = util.querySentence(word_id);
            Word word = util.queryWord(word_id);
            this.wordMean.setText(word.getWordMean());
            this.word.setText(word.getWord());
        } else {
            Bundle word = intent.getBundleExtra("word");
            Word apiWord = (Word) word.get("word");
            this.word.setText(apiWord.getWord());
            this.wordMean.setText(apiWord.getWordMean());
            list.add(new ExampleSentence(null,"该功能暂时不提供例句","该功能暂时不提供例句"));
        }
    }

    public void initComponent() {
        this.wordMean = findViewById(R.id.word_mean_activity);
        this.word = findViewById(R.id.word_title);
        util = new ContentProviderUtil(this.getContentResolver());
    }

    public void initRecyclerView() {
        RecyclerView view = findViewById(R.id.sentence_list);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        ExampleSentenceAdapter adapter = new ExampleSentenceAdapter(list);
        adapter.setListener(new ExampleSentenceAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, String sentence) {
//                Intent intent=new Intent(DetailActivity.this, MediaPlayerService.class);
//                intent.putExtra("query_sentence",sentence);
//                startService(intent);
            }
        });
        view.setLayoutManager(manager);
        view.setAdapter(adapter);
    }

    public void playWord(View view) {
        String word = this.word.getText().toString();
        Intent intent = new Intent(DetailActivity.this, MediaPlayerService.class);
        intent.putExtra("query", word);
        startService(intent);
    }

//    public void downloadMp3(final String targetUrl, final String name) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int index;
//                URL url = null;
//                try {
//                    url = new URL(targetUrl);
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    InputStream inputStream = connection.getInputStream();
//                    connection.disconnect();
//                    byte[] bytes = new byte[1024];
//                    String local = "D:\\Android\\Sdk\\workplace\\MyApplication2\\test2\\app\\src\\main\\res\\raw" + name + ".mp3";
//                    FileOutputStream mp3 = new FileOutputStream(local);
//                    while ((index = inputStream.read(bytes)) != -1) {
//                        mp3.write(bytes, 0, index);
//                        mp3.flush();
//                    }
//                    inputStream.close();
//                    ;
//                    mp3.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    public void playSpeaker(String sentence) throws IOException {
//        String speakerUrl = "http://dict.youdao.com/dictvoice?type=0&audio=";
//        String speaker = speakerUrl + sentence;
//        Uri uri = Uri.parse(speaker);
//        downloadMp3(speaker, sentence);
//        MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.prepareAsync();
//        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.start();
//            }
//        });
//        if (!mediaPlayer.isPlaying())
//            mediaPlayer.release();
//    }


}
