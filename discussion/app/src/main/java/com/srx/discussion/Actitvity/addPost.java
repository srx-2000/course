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
import org.w3c.dom.Text;

import static com.srx.discussion.Actitvity.login.USER_ID;

public class addPost extends AppCompatActivity {

    private EditText postTitle;
    private EditText postContent;
    private TextView push;
    private ImageView back;
    private boolean title;
    private boolean content;
    private Integer postsId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        getData();
        getSupportActionBar().hide();
        initComponent();
        editListener();
        setListener();
    }

    public void getData() {
        Intent intent = getIntent();
        this.postsId = intent.getIntExtra("postsId", 1);

    }

    public void initComponent() {
        this.back = findViewById(R.id.back);
        this.postContent = findViewById(R.id.pyq_editText);
        this.push = findViewById(R.id.push_pyq);
        this.postTitle = findViewById(R.id.post_title_edit);
    }

    public void editListener() {
        postTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    title = true;
                } else {
                    title = false;
                }
            }
        });
        postContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0 && title) {
                    content = true;
                    push.setTextColor(addPost.this.getResources().getColorStateList(R.color.blue));
                    push.setClickable(true);
                } else {
                    content = false;
                    push.setTextColor(addPost.this.getResources().getColorStateList(R.color.littleGrey));
                    push.setClickable(false);
                }
            }
        });

        if (content && title) {
        } else
            Toast.makeText(this, "请确保输入了标题和内容", Toast.LENGTH_SHORT).show();

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
                            String s = HttpUtil.insertPost(USER_ID, postsId, postTitle.getText().toString(), postContent.getText().toString());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (s.equals("发布成功")) {
                                        Toast.makeText(addPost.this, s, Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        Toast.makeText(addPost.this, s, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }).start();
                } else {
                    Intent intent = new Intent(addPost.this, login.class);
                    startActivity(intent);
                    Toast.makeText(addPost.this, "请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
