package com.srx.a5test;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class dialog extends AppCompatActivity {


    private Button button;

    public void test() {
        View dialog = LayoutInflater.from(this).inflate(R.layout.my_dialog, null, false);
        final EditText word = dialog.findViewById(R.id.dialog_word);
        final EditText wordMean = dialog.findViewById(R.id.dialog_word_mean);
        new AlertDialog.Builder(this)
                .setView(dialog)
                .setNegativeButton("取消", null)
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String wordTitle = word.getText().toString();
                        String wordMean1 = wordMean.getText().toString();
                        if (wordTitle.equals("abc") && wordMean1.equals("123")) {
                            Toast.makeText(dialog.this, "登录成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(dialog.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
    }
}
