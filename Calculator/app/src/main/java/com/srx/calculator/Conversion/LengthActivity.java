package com.srx.calculator.Conversion;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.srx.calculator.R;

public class LengthActivity extends AppCompatActivity {

    private Spinner inputSpinner;
    private Spinner outputSpinner;
    private Button change;
    private EditText lengthEditText;
    private TextView lengthTextView;
    private int position1;
    private int position2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        inputSpinner = findViewById(R.id.inputLength);
        outputSpinner = findViewById(R.id.outputLength);
        lengthEditText = findViewById(R.id.lengthEditText);
        lengthTextView = findViewById(R.id.lengthTextView);
        change = findViewById(R.id.changeLength);
        inputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position1 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        outputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position2 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        if (position1 == 0 && position2 == 0) {
            lengthTextView.setText(lengthEditText.getText());
        } else if (position1 == 0 && position2 == 1) {
            lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000 + "");
        } else if (position1 == 0 && position2 == 2) {
            lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 10000 + "");
        } else if (position1 == 0 && position2 == 3) {
            lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 100000 + "");
        } else if (position1 == 0 && position2 == 4) {
            lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000000 + "");
        }
        change.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (position1 == 0 && position2 == 0) {
                    lengthTextView.setText(lengthEditText.getText());
                } else if (position1 == 0 && position2 == 1) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000 + "");
                } else if (position1 == 0 && position2 == 2) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 10000 + "");
                } else if (position1 == 0 && position2 == 3) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 100000 + "");
                } else if (position1 == 0 && position2 == 4) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000000 + "");
                } else if (position1 == 0 && position2 == 5) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000000000 + "");
                } else if (position1 == 0 && position2 == 6) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000000000 + "000");
                } else if (position1 == 1 && position2 == 0) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 1000 + "");
                } else if (position1 == 1 && position2 == 1) {
                    lengthTextView.setText(lengthEditText.getText().toString() + "");
                } else if (position1 == 1 && position2 == 2) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 10 + "");
                } else if (position1 == 1 && position2 == 3) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 100 + "");
                } else if (position1 == 1 && position2 == 4) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000 + "");
                } else if (position1 == 1 && position2 == 5) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000000 + "");
                } else if (position1 == 1 && position2 == 6) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000000000 + "");
                } else if (position1 == 2 && position2 == 0) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 10000 + "");
                } else if (position1 == 2 && position2 == 1) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 10 + "");
                } else if (position1 == 2 && position2 == 2) {
                    lengthTextView.setText(lengthEditText.getText().toString() + "");
                } else if (position1 == 2 && position2 == 3) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 10 + "");
                } else if (position1 == 2 && position2 == 4) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 100 + "");
                } else if (position1 == 2 && position2 == 5) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 100000 + "");
                } else if (position1 == 2 && position2 == 6) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 100000000 + "");
                } else if (position1 == 3 && position2 == 0) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 100000 + "");
                } else if (position1 == 3 && position2 == 1) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 100 + "");
                } else if (position1 == 3 && position2 == 2) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 10 + "");
                } else if (position1 == 3 && position2 == 3) {
                    lengthTextView.setText(lengthEditText.getText().toString() + "");
                } else if (position1 == 3 && position2 == 4) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 10 + "");
                } else if (position1 == 3 && position2 == 5) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 10000 + "");
                } else if (position1 == 3 && position2 == 6) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 10000000 + "");
                } else if (position1 == 4 && position2 == 0) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 1000000 + "");
                } else if (position1 == 4 && position2 == 1) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 1000 + "");
                } else if (position1 == 4 && position2 == 2) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 100 + "");
                } else if (position1 == 4 && position2 == 3) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 10 + "");
                } else if (position1 == 4 && position2 == 4) {
                    lengthTextView.setText(lengthEditText.getText().toString() + "");
                } else if (position1 == 4 && position2 == 5) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000 + "");
                } else if (position1 == 4 && position2 == 6) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000000 + "");
                } else if (position1 == 5 && position2 == 0) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 1000000000 + "");
                } else if (position1 == 5 && position2 == 1) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 1000000 + "");
                } else if (position1 == 5 && position2 == 2) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 100000 + "");
                } else if (position1 == 5 && position2 == 3) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 10000 + "");
                } else if (position1 == 5 && position2 == 4) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) / 1000 + "");
                } else if (position1 == 5 && position2 == 5) {
                    lengthTextView.setText(lengthEditText.getText().toString() + "");
                } else if (position1 == 5 && position2 == 6) {
                    lengthTextView.setText(Double.parseDouble(lengthEditText.getText().toString()) * 1000 + "");
                }
            }

        });
    }
}
