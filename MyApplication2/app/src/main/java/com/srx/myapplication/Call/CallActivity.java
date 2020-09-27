package com.srx.myapplication.Call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.Button;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import com.srx.myapplication.MainActivity;
import com.srx.myapplication.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static android.provider.ContactsContract.Intents.Insert.ACTION;

public class CallActivity extends AppCompatActivity {

    private Button OpenButton;
    private Button CallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        OpenButton = findViewById(R.id.openPhone);
        CallButton = findViewById(R.id.callNumber);
        OpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                Uri data = Uri.parse("tel:" + "232");
                intent.setData(data);
                startActivity(intent);
            }
        });
        CallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(CallActivity.this, "缺少打电话权限", Toast.LENGTH_SHORT).show();
                    return;
                }
                String phonenumber = "13800138000"; // , = pauses
                String encodedPhonenumber = null;
                try {
                    encodedPhonenumber = URLEncoder.encode(phonenumber, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + encodedPhonenumber)));
            }
        });

    }

    public void OpenPhone(View view) {

    }

//    public void CallNumber(View view) {
//        CallButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) !=
//                        PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(CallActivity.this, "缺少打电话权限", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                String phonenumber = "13800138000"; // , = pauses
//                String encodedPhonenumber = null;
//                try {
//                    encodedPhonenumber = URLEncoder.encode(phonenumber, "UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + encodedPhonenumber)));
//            }
//        });
//
//    }

}
