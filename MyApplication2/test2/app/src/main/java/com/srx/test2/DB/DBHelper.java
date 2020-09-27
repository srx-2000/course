package com.srx.test2.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

/**
 * @author srx
 * @description
 * @create 2020-09-25 10:38:10
 */
public class DBHelper extends SQLiteOpenHelper {

    private String createWordTable;
    private String createSentenceTable;

    {
        this.createWordTable="create table word(" +
                "word_id integer primary key autoincrement," +
                "word text not null," +
                "word_mean text not null)";
        this.createSentenceTable="create table sentence(" +
                "sentence_id integer primary key autoincrement," +
                "word_id integer not null," +
                "sentence text not null," +
                "mean text not null)";
    }


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createWordTable);
        sqLiteDatabase.execSQL(createSentenceTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(createWordTable);
        sqLiteDatabase.execSQL(createSentenceTable);
    }




}
