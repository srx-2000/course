package com.srx.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        init.initRecyclerView(list, this);
        setListener();
    }
    public void setListener(){
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
    }
}
