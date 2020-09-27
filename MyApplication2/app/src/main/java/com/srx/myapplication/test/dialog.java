package com.srx.myapplication.test;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import com.srx.myapplication.R;


/**
 * @author srx
 * @description
 * @create 2020-09-13 11:30:52
 */
public class dialog extends Dialog {
    private String dialogName;
    public dialog(@NonNull Context context,String dialogName) {
        super(context);
        this.dialogName=dialogName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
