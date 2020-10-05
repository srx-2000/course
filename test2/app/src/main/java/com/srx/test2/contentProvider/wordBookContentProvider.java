package com.srx.test2.contentProvider;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.srx.test2.DB.DBHelper;

public class wordBookContentProvider extends ContentProvider {

    private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    private DBHelper dbHelper;
    private SQLiteDatabase dbWriter;

    static {
        matcher.addURI(providerUri.AUTHORITIES, providerUri.INSERT_WORD, 1);//增
        matcher.addURI(providerUri.AUTHORITIES, providerUri.INSERT_SENTENCES, 2);//增
        matcher.addURI(providerUri.AUTHORITIES, providerUri.DELETE_WORD, 3);//删
        matcher.addURI(providerUri.AUTHORITIES, providerUri.DELETE_SENTENCES, 4);//删，uri后面id为word_id
        matcher.addURI(providerUri.AUTHORITIES, providerUri.QUERY_WORD, 5);//查，如果没有id就查询所有，如果有id就是查询单个word,如果没有id并且传入的参数有word like就是模糊查询
        matcher.addURI(providerUri.AUTHORITIES, providerUri.QUERY_SENTENCES, 6);//查，uri后面id为word_id
        matcher.addURI(providerUri.AUTHORITIES, providerUri.UPDATE_WORD, 7);//改
        matcher.addURI(providerUri.AUTHORITIES, providerUri.UPDATE_SENTENCE, 8);//改
    }


    public void initDBer() {
        dbWriter = dbHelper.getWritableDatabase();
    }

    public wordBookContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        initDBer();
        int count = 0;
        switch (matcher.match(uri)) {
            case 3:
                count = dbWriter.delete("word", selection, selectionArgs);
                if (count > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                break;
            case 4:
                count = dbWriter.delete("sentence", selection, selectionArgs);
                if (count > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                break;
        }
        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(this.getContext(), "word", null, 1);
        return true;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        initDBer();
        switch (matcher.match(uri)) {
            case 1:
                long wordId = dbWriter.insert("word", null, values);
                if (wordId > 0) {
                    Uri word_new_uri = ContentUris.withAppendedId(uri, wordId);
                    getContext().getContentResolver().notifyChange(word_new_uri, null);
                    return word_new_uri;
                }
            case 2:
                long sentenceId = dbWriter.insert("sentence", null, values);
                if (sentenceId > 0) {
                    Uri sentence_new_uri = ContentUris.withAppendedId(uri, sentenceId);
                    getContext().getContentResolver().notifyChange(sentence_new_uri, null);
                    return sentence_new_uri;
                }
        }
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        initDBer();
        switch (matcher.match(uri)) {
            case 5:
                return dbWriter.query("word", projection, selection, selectionArgs, null, null, null);
            case 6:
                return dbWriter.query("sentence", projection, selection, selectionArgs, null, null, null);
        }
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        initDBer();
        int row = 0;
        switch (matcher.match(uri)) {
            case 7:
                row = dbWriter.update("word", values, selection, selectionArgs);
                if (row > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                break;
            case 8:
                row = dbWriter.update("sentence", values, selection, selectionArgs);
                if (row > 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                break;
        }
        return row;
    }
}
