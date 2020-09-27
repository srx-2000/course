package com.srx.myapplication.File;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phoneDetail extends AppCompatActivity {

    private Button submit;
    private static final String TAG = "shirongxing";
    private List<Phone> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_detail);
        submit = findViewById(R.id.getName);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultList = phoneDetail.this.getContactPhone();
                RecyclerView recyclerView = findViewById(R.id.recycler_view);
                LinearLayoutManager layoutManager = new LinearLayoutManager(phoneDetail.this);
                recyclerView.setLayoutManager(layoutManager);
                phoneAdapter adapter = new phoneAdapter(resultList);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    private List<Phone> getContactPhone() {
        List<Phone> list = new ArrayList<>();
        ContentResolver resolver = phoneDetail.this.getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phoneNumbers = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + id, null, null);
            while (phoneNumbers.moveToNext()) {
                String phoneNumber = phoneNumbers.getString(phoneNumbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Phone phone = new Phone(name, phoneNumber);
                list.add(phone);
            }            //email
        }
        return list;
    }
}