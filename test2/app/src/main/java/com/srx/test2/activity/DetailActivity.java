package com.srx.test2.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.test2.R;
import com.srx.test2.adapter.ExampleSentenceAdapter;
import com.srx.test2.contentProvider.ContentProviderUtil;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.Word;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView wordMean;
    private TextView word;
    private List<ExampleSentence> list = new ArrayList<>();
    private ContentProviderUtil util;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initComponent();
        initDetail();
        initRecyclerView();
    }

    public void initDetail() {
        Intent intent=getIntent();
        String word_id = intent.getStringExtra("word_id");
        list = util.querySentence(word_id);
        Word word = util.queryWord(word_id);
        this.wordMean.setText(word.getWordMean());
        this.word.setText(word.getWord());
    }

    public void initComponent(){
        this.wordMean=findViewById(R.id.word_mean_activity);
        this.word=findViewById(R.id.word_title);
        util=new ContentProviderUtil(this.getContentResolver());
    }

    public void initRecyclerView() {
        RecyclerView view = findViewById(R.id.sentence_list);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        ExampleSentenceAdapter adapter = new ExampleSentenceAdapter(list);
        adapter.setListener(new ExampleSentenceAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, String sentence) {
                try {
                    playSpeaker(sentence);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        view.setLayoutManager(manager);
        view.setAdapter(adapter);
    }

    public void downloadMp3(final String targetUrl, final String name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int index;
                URL url = null;
                try {
                    url = new URL(targetUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream inputStream = connection.getInputStream();
                    connection.disconnect();
                    byte[] bytes = new byte[1024];
                    String local = "D:\\Android\\Sdk\\workplace\\MyApplication2\\test2\\app\\src\\main\\res\\raw" + name + ".mp3";
                    FileOutputStream mp3 = new FileOutputStream(local);
                    while ((index = inputStream.read(bytes)) != -1) {
                        mp3.write(bytes, 0, index);
                        mp3.flush();
                    }
                    inputStream.close();
                    ;
                    mp3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void playSpeaker(String sentence) throws IOException {
        String speakerUrl = "http://dict.youdao.com/dictvoice?type=0&audio=";
        String speaker = speakerUrl + sentence;
        Uri uri = Uri.parse(speaker);
        downloadMp3(speaker, sentence);
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        if (!mediaPlayer.isPlaying())
            mediaPlayer.release();
    }



}
