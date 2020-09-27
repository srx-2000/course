package com.srx.myapplication.transmission;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.srx.myapplication.R;

/**
 * @author srx
 * @description
 * @create 2020-09-10 20:57:02
 */
public class activity1 extends Activity {

    private Button button;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        button = findViewById(R.id.submit);
        editText = findViewById(R.id.input);
        textView = findViewById(R.id.output);
    }

    public void submitNum(View view) {
        Intent intent = new Intent(this, activity2.class);
        Integer inputNumber = null;
        try {
            inputNumber = Integer.valueOf(editText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "请输入数字", Toast.LENGTH_LONG).show();
        }
        if (Integer.class.isInstance(inputNumber)) {
            intent.putExtra("number", inputNumber.toString());
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("srxtest", "onStop: 被调用了");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("srxtest", "onResume: 被调用了");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data.getStringExtra("result");
        textView.setText(result);
    }
}
