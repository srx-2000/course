package com.srx.discussion.Actitvity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.discussion.R;
import com.srx.discussion.util.HttpUtil;

public class insertPyq extends AppCompatActivity {

    private ImageView back;
    private EditText pyqContent;
    private TextView push;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pyq);
        getSupportActionBar().hide();
        initComponent();
        editListener();
        setListener();
    }

    public void initComponent() {
        this.back = findViewById(R.id.back);
        this.pyqContent = findViewById(R.id.pyq_editText);
        this.push = findViewById(R.id.push_pyq);
    }

    public void editListener() {
        pyqContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()>0) {
                    push.setTextColor(insertPyq.this.getResources().getColorStateList(R.color.blue));
                    push.setClickable(true);
                }else{
                    push.setTextColor(insertPyq.this.getResources().getColorStateList(R.color.littleGrey));
                    push.setClickable(false);
                }
            }
        });
    }

    public void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HttpUtil.isLanded()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String s = HttpUtil.insertPyq(pyqContent.getText().toString());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (s.equals("朋友圈发布成功")) {
                                        Toast.makeText(insertPyq.this, s, Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        Toast.makeText(insertPyq.this, s, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }).start();
                } else {
                    Intent intent = new Intent(insertPyq.this, login.class);
                    startActivity(intent);
                    Toast.makeText(insertPyq.this, "请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
