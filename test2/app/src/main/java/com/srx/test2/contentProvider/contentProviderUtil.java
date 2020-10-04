package com.srx.test2.contentProvider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.srx.test2.entities.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * @author srx
 * @description
 * @create 2020-09-28 20:28:58
 */
public class contentProviderUtil {
    private ContentResolver resolver;
    public static String baseUri = providerUri.CONTENT + providerUri.AUTHORITIES;
    public static String queryWord = baseUri + providerUri.QUERY_WORD;
    public static String insertWord = baseUri + providerUri.INSERT_WORD;
    public static String deleteWord = baseUri + providerUri.DELETE_WORD;
    public static String deleteSentences = baseUri + providerUri.DELETE_SENTENCES;

    public contentProviderUtil(ContentResolver resolver) {
        this.resolver = resolver;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public List<Word> queryWordByBlurry(String string) {
        List<Word> list = new ArrayList<>();
        Uri uri = Uri.parse(queryWord);
        String selection = "word like ?";
        String[] selectionArg = {"%" + string + "%"};
        String[] columns = new String[]{"word_id", "word", "word_mean"};
        Cursor c = resolver.query(uri, columns, selection, selectionArg, null, null);
        while (c.moveToNext()) {
            String word_id = c.getString(c.getColumnIndex("word_id"));
            String word = c.getString(c.getColumnIndex("word"));
            String word_mean = c.getString(c.getColumnIndex("word_mean"));
            Word wordObj = new Word(word_id, word, word_mean);
            list.add(wordObj);
        }
        return list;
    }

    public long insertWord(Word word) {
        Uri uri = Uri.parse(insertWord);
        ContentValues values = new ContentValues();
        values.put("word", word.getWord());
        values.put("word_mean", word.getWordMean());
        Uri insert = resolver.insert(uri, values);
        return ContentUris.parseId(insert);
    }

    public int deleteWord(String wordId) {
        int count = 0;
        Uri uri = Uri.parse(deleteWord);
        String selection = "wordId=?";
        String[] selectionArg = {wordId};
        count = resolver.delete(uri, selection, selectionArg);
        return count;
    }

    public List<Word> queryWord(){
        List<Word> list=new ArrayList<>();
        Uri uri = Uri.parse(queryWord);
        String[] columns = new String[]{"word_id", "word", "word_mean"};
        Cursor c = resolver.query(uri,columns,null,null,null);
        while (c.moveToNext()) {
            String word_id = c.getString(c.getColumnIndex("word_id"));
            String word = c.getString(c.getColumnIndex("word"));
            String word_mean = c.getString(c.getColumnIndex("word_mean"));
            Word wordObj = new Word(word_id, word, word_mean);
            list.add(wordObj);
        }
        return list;
    }

    public void queryWordId(String word, String wordMean){
        Uri uri = Uri.parse(queryWord);
        String[] columns = new String[]{"word_id"};
        String[] selectors = new String[]{word, wordMean};
//        resolver.query(uri);
    }


}
