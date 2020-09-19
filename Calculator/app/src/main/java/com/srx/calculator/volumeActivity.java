package com.srx.calculator;

import android.text.Editable;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class volumeActivity extends AppCompatActivity {

    private Button change;
    private EditText volumeEditText;
    private Spinner inputSpinner;
    private TextView m3;
    private TextView hl;
    private TextView dal;
    private TextView dm3;
    private TextView dl;
    private TextView cl;
    private TextView cm3;
    private TextView mm3;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        initComponent();
        inputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position=i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double inputNum = Double.parseDouble(volumeEditText.getText().toString());
                if(position==0){
                    m3.setText(inputNum*1+"");
                    hl.setText(inputNum*10+"");
                    dal.setText(inputNum*100+"");
                    dm3.setText(inputNum*1000+"");
                    dl.setText(inputNum*10000+"");
                    cl.setText(inputNum*100000+"");
                    cm3.setText(inputNum*1000000+"");
                    mm3.setText(inputNum*1000000000+"");
                }else if(position==1){
                    m3.setText(inputNum*0.1+"");
                    hl.setText(inputNum*1+"");
                    dal.setText(inputNum*10+"");
                    dm3.setText(inputNum*100+"");
                    dl.setText(inputNum*1000+"");
                    cl.setText(inputNum*10000+"");
                    cm3.setText(inputNum*100000+"");
                    mm3.setText(inputNum*100000000+"");
                }else if(position==2){
                    m3.setText(inputNum*0.01+"");
                    hl.setText(inputNum*0.1+"");
                    dal.setText(inputNum*1+"");
                    dm3.setText(inputNum*10+"");
                    dl.setText(inputNum*100+"");
                    cl.setText(inputNum*1000+"");
                    cm3.setText(inputNum*10000+"");
                    mm3.setText(inputNum*10000000+"");
                }else if(position==3){
                    m3.setText(inputNum*0.001+"");
                    hl.setText(inputNum*0.01+"");
                    dal.setText(inputNum*0.1+"");
                    dm3.setText(inputNum*1+"");
                    dl.setText(inputNum*10+"");
                    cl.setText(inputNum*100+"");
                    cm3.setText(inputNum*1000+"");
                    mm3.setText(inputNum*1000000+"");
                }else if(position==4){
                    m3.setText(inputNum*0.0001+"");
                    hl.setText(inputNum*0.001+"");
                    dal.setText(inputNum*0.01+"");
                    dm3.setText(inputNum*0.1+"");
                    dl.setText(inputNum*1+"");
                    cl.setText(inputNum*10+"");
                    cm3.setText(inputNum*100+"");
                    mm3.setText(inputNum*100000+"");
                }else if(position==5){
                    m3.setText(inputNum*0.00001+"");
                    hl.setText(inputNum*0.0001+"");
                    dal.setText(inputNum*0.001+"");
                    dm3.setText(inputNum*0.01+"");
                    dl.setText(inputNum*0.1+"");
                    cl.setText(inputNum*1+"");
                    cm3.setText(inputNum*10+"");
                    mm3.setText(inputNum*10000+"");
                }else if(position==6){
                    m3.setText(inputNum*0.000001+"");
                    hl.setText(inputNum*0.00001+"");
                    dal.setText(inputNum*0.0001+"");
                    dm3.setText(inputNum*0.001+"");
                    dl.setText(inputNum*0.01+"");
                    cl.setText(inputNum*0.1+"");
                    cm3.setText(inputNum*1+"");
                    mm3.setText(inputNum*10000+"");
                }else if(position==7){
                    m3.setText(inputNum*0.0000001+"");
                    hl.setText(inputNum*0.000001+"");
                    dal.setText(inputNum*0.00001+"");
                    dm3.setText(inputNum*0.0001+"");
                    dl.setText(inputNum*0.001+"");
                    cl.setText(inputNum*0.01+"");
                    cm3.setText(inputNum*0.1+"");
                    mm3.setText(inputNum*1000+"");
                }
            }
        });
    }

    public void initComponent(){
        m3=findViewById(R.id.m3Text);
        hl=findViewById(R.id.hlText);
        dal=findViewById(R.id.dalText);
        dm3=findViewById(R.id.dm3Text);
        dl=findViewById(R.id.dlText);
        cl=findViewById(R.id.clText);
        cm3=findViewById(R.id.cm3Text);
        mm3=findViewById(R.id.mm3Text);
        change=findViewById(R.id.changeVolume);
        volumeEditText=findViewById(R.id.volumeEditText);
        inputSpinner=findViewById(R.id.inputVolume);
        volumeEditText.setText("0");
    }
}
