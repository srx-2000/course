package com.srx.test2.activity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.srx.test2.R;
import com.srx.test2.entities.Word;

public class testActivity extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initComponent();

    }

    public void insert(View view) {
        ContentResolver contentResolver = this.getContentResolver();
        ContentValues values=new ContentValues();
        Gson gson=new Gson();
        String s = gson.toJson(new Word("1","test2","test2"));
        values.put("word",s);
        Uri uri=Uri.parse("content://com.srx.wordBook/test");
        contentResolver.insert(uri,values);
//        uri.getPathSegments()
        Toast.makeText(this,"数据插入成功",Toast.LENGTH_LONG).show();
    }

    public void initComponent(){
        button = findViewById(R.id.insertValue);
    }
}
