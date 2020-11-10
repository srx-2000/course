package com.srx.discussion.Actitvity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.discussion.R;
import com.srx.discussion.util.HttpUtil;

public class login extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private EditText username;
    private EditText password;
    private CheckBox autoLogin;
    private CheckBox rememberPassword;
    public static Integer USER_ID = 0;
    private String usernameString;
    private String passwordString;


    @SuppressLint({"RestrictedApi", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle("");
        supportActionBar.setBackgroundDrawable(new ColorDrawable(R.color.closeWhite));
        initComponent();
        setButtonListener();
        restoreUserInfo();
    }

    public void restoreUserInfo() {
        SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
        String username = sp.getString("username", null);
        String password = sp.getString("password", null);
        if (username != null) {
            this.username.setText(username);
        }
        if (password != null) {
            this.password.setText(password);
            rememberPassword.setChecked(true);
        }
    }


    public void setButtonListener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameString = username.getText().toString();
                passwordString = password.getText().toString();
                SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Integer login = HttpUtil.login(usernameString, passwordString);
                        USER_ID = login;
                        if (login > 0) {
                            if (rememberPassword.isChecked()) {
                                editor.putString("username", usernameString);
                                editor.putString("password", passwordString);
                                editor.putBoolean("autoLogin", false);
                                if (autoLogin.isChecked()) {
                                    rememberPassword.setChecked(true);
                                    editor.putBoolean("autoLogin", true);
                                }
                            } else {
                                if (autoLogin.isChecked()) {
                                    editor.putBoolean("autoLogin", true);
                                    editor.putString("password", passwordString);
                                    rememberPassword.setChecked(true);
                                }
                                if (sp.getString("password", null) != null) {
                                    editor.remove("password");
                                }
                                editor.putString("username", usernameString);
                                editor.putBoolean("autoLogin", false);
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

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,register.class);
                startActivity(intent);
            }
        });
    }

    public void initComponent() {
        this.loginButton = findViewById(R.id.login_button);
        this.password = findViewById(R.id.password);
        this.username = findViewById(R.id.username);
        this.autoLogin = findViewById(R.id.auto_login);
        this.rememberPassword = findViewById(R.id.remember_password);
        this.registerButton = findViewById(R.id.register_button);
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
