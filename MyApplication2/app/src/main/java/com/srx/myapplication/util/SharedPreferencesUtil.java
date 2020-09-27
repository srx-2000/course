package com.srx.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * @author srx
 * @description
 * @create 2020-09-14 15:52:14
 */
public class SharedPreferencesUtil {
    public static boolean saveMessage(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        boolean commit = edit.commit();
        return commit;
    }

    public static String restoreMessage(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userinfo", context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, "");
        return value;
    }
}
