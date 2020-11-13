package com.srx.a5test;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class towActivity extends AppCompatActivity {

    private Button button;
    private Integer num = null;
    private Intent intent = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tow);
        button = findViewById(R.id.submitOutput);
        intent = getIntent();
        String number = intent.getStringExtra("number");
        if (number != null)
            num = Integer.valueOf(number);
    }

    private <T extends Serializable> void intentMethod(int code, String name, Object value) {
        intent.putExtra(name, (T) value);
        setResult(code, intent);
        finish();
    }

    public void submitOutput(View view) {
        String name="result";
        String errormessage="完蛋，出问题了";
        if (intent != null) {
            if (num != null) {
                intentMethod(1, name, "答案是" + num * num);
            } else {
                intentMethod(1, name, errormessage);
            }
        } else {
            intentMethod(1, name, errormessage);
        }
    }
}
