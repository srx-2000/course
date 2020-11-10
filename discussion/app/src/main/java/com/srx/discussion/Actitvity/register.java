package com.srx.discussion.Actitvity;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.discussion.R;
import com.srx.discussion.util.HttpUtil;

public class register extends AppCompatActivity {

    private Button registerButton;
    private TextView usernameText;
    private TextView passwordText;
    private TextView emailText;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponent();
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("");
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setBackgroundDrawable(new ColorDrawable(R.color.closeWhite));
        supportActionBar.setSplitBackgroundDrawable(new ColorDrawable(R.color.closeWhite));
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String register = HttpUtil.register(username, password, email, "1");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(register.this,register,Toast.LENGTH_SHORT).show();
                            }
                        });
                        finish();
                    }
                }).start();
            }
        });
    }


    public void initComponent() {
        this.usernameText = findViewById(R.id.username);
        this.passwordText = findViewById(R.id.password);
        this.emailText = findViewById(R.id.email);
        this.registerButton = findViewById(R.id.register_button);
    }


}
