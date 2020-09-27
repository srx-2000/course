package com.srx.myapplication.File;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import com.srx.myapplication.R;
import com.srx.myapplication.util.SharedPreferencesUtil;

import java.util.Map;

public class SharedPreferences extends AppCompatActivity {

    private static final String TAG = "shirongxing";
    private Button submit;
    private String name;
    private String studentId;
    private EditText studentEt;
    private EditText nameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        init();
        restoreMessage();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMessage();
            }
        });

    }

    public void saveMessage() {
        Log.d(TAG, "saveMessage被调用了");
        studentEt = findViewById(R.id.studentId);
        studentId = studentEt.getText().toString();
        nameEt = findViewById(R.id.name);
        name = nameEt.getText().toString();
        boolean flag1 = SharedPreferencesUtil.saveMessage(SharedPreferences.this, "name", name);
        boolean flag2 = SharedPreferencesUtil.saveMessage(SharedPreferences.this, "studentId", studentId);
        if (flag1 & flag2) {
            Toast.makeText(SharedPreferences.this, "登录成功", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(SharedPreferences.this, "登录失败", Toast.LENGTH_LONG).show();

    }

    public void init() {
        Log.d(TAG, "init被调用了");
        submit = findViewById(R.id.submit);
        studentEt = findViewById(R.id.studentId);
        nameEt = findViewById(R.id.name);
    }

    public void restoreMessage() {
        Log.d(TAG, "restoreMessage被调用了");
        String rname = SharedPreferencesUtil.restoreMessage(SharedPreferences.this, "name");
        String rstudentId = SharedPreferencesUtil.restoreMessage(SharedPreferences.this, "studentId");
        nameEt.setText(rname);
        studentEt.setText(rstudentId);
    }


}
