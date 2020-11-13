package com.srx.a5test;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class sp extends AppCompatActivity {

    private Button in;
    private Button out;
    private EditText input;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        in = findViewById(R.id.in);
        out = findViewById(R.id.out);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        final SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
        final SharedPreferences.Editor edit = test.edit();
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putString("input", input.getText().toString());
                edit.commit();
            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText(test.getString("input","111"));
            }
        });

    }
}
