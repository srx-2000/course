package com.srx.calculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.List;

public class CalculatorFragment extends AppCompatActivity {
    private List<Calculator> list;
    private InitComponent init;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calculator);
        init = new InitComponent(this);
        init.initComponent();
        setListener();
    }

    public void setListener() {
        InitComponent.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.one);
            }
        });
        InitComponent.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.two);
            }
        });
        InitComponent.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.three);
            }
        });
        InitComponent.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.four);
            }
        });
        InitComponent.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.five);
            }
        });
        InitComponent.six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.six);
            }
        });
        InitComponent.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.seven);
            }
        });
        InitComponent.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.eight);
            }
        });
        InitComponent.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.nine);
            }
        });
        InitComponent.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.zero);
            }
        });
        InitComponent.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.add);
            }
        });
        InitComponent.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.minus);
            }
        });
        InitComponent.multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.multiplication);
            }
        });
        InitComponent.division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.division);
            }
        });
        InitComponent.percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.percentage);
            }
        });
        InitComponent.point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.point);
            }
        });
        InitComponent.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.delete);
            }
        });
        InitComponent.cleared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.cleared);
            }
        });
        InitComponent.tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.tan);
            }
        });
        InitComponent.cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.cos);
            }
        });
        InitComponent.sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.sin);
            }
        });
        InitComponent.part.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init.setText(InitComponent.part);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.length:
                Intent intent1 = new Intent(CalculatorFragment.this, LengthActivity.class);
                startActivity(intent1);
                break;
            case R.id.System:
                Intent intent2 = new Intent(CalculatorFragment.this, SystemActivity.class);
                startActivity(intent2);
                break;
            case R.id.volume:
                Intent intent3 = new Intent(CalculatorFragment.this, volumeActivity.class);
                startActivity(intent3);
                break;
            case R.id.help:
                new AlertDialog.Builder(this)
                        .setTitle("帮助")
                        .setMessage("跟普通的计算器一样使用")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", null)
                        .show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
