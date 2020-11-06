package com.srx.discussion.Actitvity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.discussion.R;
import com.srx.discussion.util.HttpUtil;

public class login extends AppCompatActivity {

    private Button button;
    private EditText username;
    private EditText password;
    private CheckBox autoLogin;
    private CheckBox rememberPassword;
    public static Integer USER_ID=0;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle("");
        initComponent();
        setButtonListener();
    }


    public void setButtonListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwordString = password.getText().toString();
                String usernameString = username.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences("userInfo", MODE_PRIVATE).edit();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Integer login = HttpUtil.login(usernameString, passwordString);
                        USER_ID=login;
                        if (login>0) {
                            if (rememberPassword.isChecked()) {
                                editor.putString("username", usernameString);
                                editor.putString("password", passwordString);
                                editor.putBoolean("autoLogin", false);
                                if (autoLogin.isChecked()) {
                                    editor.putBoolean("autoLogin", true);
                                }
                            } else {
                                editor.putString("username", usernameString);
                            }
                            if (editor.commit())
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(login.this, "登录成功！", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            finish();
                        } else {
                            password.setText("");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(login.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }

    public void initComponent() {
        this.button = findViewById(R.id.login_button);
        this.password = findViewById(R.id.password);
        this.username = findViewById(R.id.username);
        this.autoLogin = findViewById(R.id.auto_login);
        this.rememberPassword = findViewById(R.id.auto_login);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
