package com.srx.homework;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ThreadTest extends AppCompatActivity {

    private Handler handler;
    private TextView textView;
    private Button button;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        init();
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                textView.setText(msg.obj.toString());
            }
        };
        runnable = new Runnable() {
            @Override
            public void run() {
                String messageNum = "";
                for (int i = 1; i <= 1000; i++) {
                    int j = 2;
                    while (i > j) {
                        if (i % j == 0) {
                            break;
                        }
                        j++;
                    }
                    if (i == j) {
                        System.out.println(i);
                        messageNum += String.valueOf(i)+",";
                    }
                }
                Message message = new Message();
                message.obj =messageNum;
                handler.sendMessage(message);
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(null, runnable, "testThread");
                thread.start();
            }
        });
    }

    public void init() {
        textView = findViewById(R.id.prime);
        button = findViewById(R.id.findPrime);
    }

}
