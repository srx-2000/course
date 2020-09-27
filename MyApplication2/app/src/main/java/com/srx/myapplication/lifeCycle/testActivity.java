package com.srx.myapplication.lifeCycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.srx.myapplication.R;

import javax.security.auth.callback.Callback;
import java.io.File;

/**
 * @author srx
 * @description
 * @create 2020-09-10 17:36:44
 */
public class testActivity extends Activity {
    private static final String TAG="testActivity";
    private CheckBox checkBox;
    private EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        checkBox=findViewById(R.id.cbDisplayPassword);
        editText=findViewById(R.id.etPassword);
    }


    public void changeStatus(View view, KeyEvent.Callback callback) {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                    editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
                    String State = Environment.getExternalStorageState();
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                    editText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD|InputType.TYPE_CLASS_TEXT);
                }
            }
        });

    }
}
