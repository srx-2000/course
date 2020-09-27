package com.srx.test2.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.test2.R;

import java.util.ArrayList;
import java.util.List;

public class insertWord extends AppCompatActivity {

    private EditText word;
    private EditText wordMean;
    private List<EditText> sentence=new ArrayList<>();
    private List<EditText> sentenceMean=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_word);
        initComponent();
    }

    private void initComponent() {
        word=findViewById(R.id.input_word);
        wordMean=findViewById(R.id.input_word_mean);
        sentence.add((EditText) findViewById(R.id.input_sentence));
        sentenceMean.add((EditText) findViewById(R.id.input_sentence_mean));
    }

    public void addSentence(View view) {
        LinearLayout linearLayout = findViewById(R.id.sentence_layout);
        LinearLayout linearLayout_mean = findViewById(R.id.sentence_layout_mean);
        EditText sentenceObj = new EditText(insertWord.this);
        EditText sentence_meanObj = new EditText(insertWord.this);
        sentenceObj.setHint("请输入例句");
        sentence_meanObj.setHint("请输入句意");
        this.sentence.add(sentenceObj);
        this.sentenceMean.add(sentence_meanObj);
        linearLayout.addView(sentenceObj);
        linearLayout_mean.addView(sentence_meanObj);
    }

    public void submit(View view){
        String[] sentenceList=new String[sentence.size()];
        String[] sentenceMeanList=new String[sentence.size()];
        for (int i=0;i<sentence.size();i++){
            EditText sentenceObj = this.sentence.get(i);
            EditText sentenceMeanObj = this.sentenceMean.get(i);
            sentenceList[i]=sentenceObj.getText().toString();
            sentenceMeanList[i]=sentenceMeanObj.getText().toString();
        }
        String word = this.word.getText().toString();
        String wordMean=this.wordMean.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("word",word);
        intent.putExtra("wordMean",wordMean);
        intent.putExtra("sentenceList",sentenceList);
        intent.putExtra("sentenceMeanList",sentenceMeanList);
        setResult(222,intent);
        finish();
    }
    public void back(View view){
        Intent intent=new Intent();
        setResult(222,intent);
        finish();
    }

}
