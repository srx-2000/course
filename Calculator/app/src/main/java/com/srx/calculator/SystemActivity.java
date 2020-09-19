package com.srx.calculator;

import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SystemActivity extends AppCompatActivity {

    private Button change;
    private TextView BinaryText;
    private TextView OctalText;
    private TextView DecimalText;
    private TextView HexadecimalText;
    private Spinner inputSystem;
    private EditText systemEditText;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        initComponent();
        inputSystem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                if (i == 0) {
                    systemEditText.setKeyListener(DigitsKeyListener.getInstance("01"));
                } else if (i == 1) {
                    systemEditText.setKeyListener(DigitsKeyListener.getInstance("01234567"));
                } else if (i == 2) {
                    systemEditText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                } else if (i == 3) {
                    systemEditText.setKeyListener(DigitsKeyListener.getInstance("0123456789ABCDEFabcdef"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputNum = systemEditText.getText().toString();
                if (position == 0) {
                    systemEditText.setText("0");
                    int num = Integer.parseInt(inputNum, 2);
                    BinaryText.setText(inputNum);
                    OctalText.setText(Integer.toOctalString(num));
                    DecimalText.setText(num+"");
                    HexadecimalText.setText(Integer.toHexString(num));
                } else if (position == 1) {
                    systemEditText.setText("0");
                    int num = Integer.parseInt(inputNum, 8);
                    BinaryText.setText(Integer.toBinaryString(num));
                    OctalText.setText(inputNum);
                    DecimalText.setText(num+"");
                    HexadecimalText.setText(Integer.toHexString(num));
                } else if (position == 2) {
                    systemEditText.setText("0");
                    BinaryText.setText(Integer.toBinaryString(Integer.valueOf(inputNum)));
                    OctalText.setText(Integer.toOctalString(Integer.valueOf(inputNum)));
                    DecimalText.setText(inputNum);
                    HexadecimalText.setText(Integer.toHexString(Integer.valueOf(inputNum)));
                } else if (position == 3) {
                    systemEditText.setText("0");
                    int num = Integer.parseInt(inputNum, 16);
                    BinaryText.setText(Integer.toBinaryString(num));
                    OctalText.setText(Integer.toOctalString(num));
                    DecimalText.setText(num+"");
                    HexadecimalText.setText(inputNum);
                }
            }
        });
    }

    public void initComponent() {
        change = findViewById(R.id.changeSystem);
        BinaryText = findViewById(R.id.BinaryText);
        OctalText = findViewById(R.id.OctalText);
        DecimalText = findViewById(R.id.DecimalText);
        HexadecimalText = findViewById(R.id.HexadecimalText);
        inputSystem = findViewById(R.id.inputSystem);
        systemEditText = findViewById(R.id.systemEditText);
        systemEditText.setText("0");
    }


}
