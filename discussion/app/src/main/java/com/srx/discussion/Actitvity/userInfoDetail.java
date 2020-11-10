package com.srx.discussion.Actitvity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.ErrorMessage;
import com.srx.discussion.entity.base.AndroidUser;
import com.srx.discussion.util.HttpUtil;

import static com.srx.discussion.Actitvity.login.USER_ID;


public class userInfoDetail extends AppCompatActivity {

    private TextView saveInfo;
    private TextView username;
    private EditText nickname;
    private EditText address;
    private EditText age;
    private EditText selfSignature;
    private EditText sex;
    private ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_detail);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.hide();
        initComponent();
        setListener();
        setData();
    }

    public void setData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Object showUserInfo = HttpUtil.showUserInfo(USER_ID);
                if (showUserInfo instanceof ErrorMessage) {
                    ErrorMessage e = (ErrorMessage) showUserInfo;
                    if (e.getErrorCode().equals("errorMessage.nofound.user")) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(userInfoDetail.this, "没找到该用户，你是不是干了什么不好的事情鸭？", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } else {
                    AndroidUser userInfo = (AndroidUser) showUserInfo;
                    SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
                    String usernameString = sp.getString("username", "null");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            username.setText(usernameString);
                            address.setText(userInfo.getAddress());
                            age.setText(userInfo.getAge()+"");
                            sex.setText(userInfo.getSex());
                            nickname.setText(userInfo.getNickname());
                            selfSignature.setText(userInfo.getSelfSignature());
                        }
                    });
                }
            }
        }).start();
    }

    public void initComponent() {
        this.saveInfo = findViewById(R.id.save_info);
        this.username = findViewById(R.id.username);
        this.age = findViewById(R.id.age);
        this.sex = findViewById(R.id.sex);
        this.address = findViewById(R.id.address);
        this.selfSignature = findViewById(R.id.self_signature);
        this.nickname = findViewById(R.id.user_nickName);
        this.back = findViewById(R.id.back);
    }


    public void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String nickname_string = nickname.getText().toString();
                        String age_string = age.getText().toString();
                        String sex_string = sex.getText().toString();
                        String address_string = address.getText().toString();
                        String selfSignature_string = selfSignature.getText().toString();
                        String result = HttpUtil.updateUserInfo(USER_ID, nickname_string, age_string, sex_string, address_string, selfSignature_string);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(userInfoDetail.this, result, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
