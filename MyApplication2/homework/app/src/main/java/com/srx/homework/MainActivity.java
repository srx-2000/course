package com.srx.homework;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private EditText sign;
    private TextView result;
    private calculatorService.MyBinder binder;
    private ServiceConnect connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    public void initComponent() {
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        sign = findViewById(R.id.sign);
        result = findViewById(R.id.result);
    }

    public void bindService(View view) {
        if (connect == null) {
            connect = new ServiceConnect();
        }
        Intent intent = new Intent(this, calculatorService.class);
        bindService(intent, connect,BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        if(connect!=null){
            unbindService(connect);
            connect=null;
        }
    }

    public void callService(View view) {
        String number1 = num1.getText().toString();
        String number2 = num2.getText().toString();
        String signing = sign.getText().toString();
        double resultNum = binder.callService(number1, number2, signing);
        result.setText(resultNum+"");
    }

    private class ServiceConnect implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder = (calculatorService.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
