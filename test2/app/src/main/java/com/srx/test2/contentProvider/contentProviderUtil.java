package com.srx.test2.contentProvider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * @author srx
 * @description
 * @create 2020-09-28 20:28:58
 */
public class ContentProviderUtil {
    private ContentResolver resolver;
    public static String baseUri = providerUri.CONTENT + providerUri.AUTHORITIES;
    public static String queryWord = baseUri + providerUri.QUERY_WORD;
    public static String insertWord = baseUri + providerUri.INSERT_WORD;
    public static String deleteWord = baseUri + providerUri.DELETE_WORD;
    public static String updateWord = baseUri + providerUri.UPDATE_WORD;

    public static String deleteSentences = baseUri + providerUri.DELETE_SENTENCES;
    public static String querySentences = baseUri + providerUri.QUERY_SENTENCES;
    public static String insertSentence = baseUri + providerUri.INSERT_SENTENCES;


    public ContentProviderUtil(ContentResolver resolver) {
        this.resolver = resolver;
    }

    /**
     * 模糊查询
     *
     * @param string
     * @return
     */
    public List<Word> queryWordByBlurry(String string) {
        List<Word> list = new ArrayList<>();
        Uri uri = Uri.parse(queryWord);
        String selection = "word like ?";
        String[] selectionArg = {"%" + string + "%"};
        String[] columns = new String[]{"word_id", "word", "word_mean"};
        Cursor c = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            c = resolver.query(uri, columns, selection, selectionArg, null, null);
        }
        while (c.moveToNext()) {
            String word_id = c.getString(c.getColumnIndex("word_id"));
            String word = c.getString(c.getColumnIndex("word"));
            String word_mean = c.getString(c.getColumnIndex("word_mean"));
            Word wordObj = new Word(word_id, word, word_mean);
            list.add(wordObj);
        }
        return list;
    }

    /**
     * 插入单词
     *
     * @param word
     * @return
     */
    public long insertWord(Word word) {
        Uri uri = Uri.parse(insertWord);
        ContentValues values = new ContentValues();
        values.put("word", word.getWord());
        values.put("word_mean", word.getWordMean());
        Uri insert = resolver.insert(uri, values);
        return ContentUris.parseId(insert);
    }

    /**
     * 删除单词
     *
     * @param wordId
     * @return
     */
    public int deleteWord(String wordId) {
        Uri uri = Uri.parse(deleteWord);
        String selection = "word_id=?";
        String[] selectionArg = {wordId};
        return resolver.delete(uri, selection, selectionArg);
    }

    /**
     * 查询所有单词
     *
     * @return
     */
    public List<Word> queryWord() {
        List<Word> list = new ArrayList<>();
        Uri uri = Uri.parse(queryWord);
        String[] columns = new String[]{"word_id", "word", "word_mean"};
        Cursor c = resolver.query(uri, columns, null, null, null);
        while (c.moveToNext()) {
            String word_id = c.getString(c.getColumnIndex("word_id"));
            String word = c.getString(c.getColumnIndex("word"));
            String word_mean = c.getString(c.getColumnIndex("word_mean"));
            Word wordObj = new Word(word_id, word, word_mean);
            list.add(wordObj);
        }
        return list;
    }

    /**
     * 通过单词和词义查询单词id
     *
     * @param word
     * @param wordMean
     * @return
     */
    public String queryWordId(String word, String wordMean) {
        Uri uri = Uri.parse(queryWord);
        String[] columns = new String[]{"word_id"};
        String[] selectors = new String[]{word, wordMean};
        Cursor c = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            c = resolver.query(uri, columns, "word=? and word_mean=?", selectors, null, null);
        }
        c.moveToFirst();
        String word_id = c.getString(c.getColumnIndex("word_id"));
        return word_id;
    }

    /**
     * 根据给出的单词id查询单词详情
     *
     * @param wordId
     * @return
     */

    public Word queryWord(String wordId) {
        Uri uri = Uri.parse(queryWord);
        String[] columns = new String[]{"word_id", "word", "word_mean"};
        String[] selectors = new String[]{wordId};
        Cursor c = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            c = resolver.query(uri, columns, "word_id=?", selectors, null, null);
        }
        c.moveToFirst();
        String word_id = c.getString(c.getColumnIndex("word_id"));
        String word = c.getString(c.getColumnIndex("word"));
        String word_mean = c.getString(c.getColumnIndex("word_mean"));
        Word wordObj = new Word(word_id, word, word_mean);
        return wordObj;
    }

    /**
     * 根据给出的单词id查询句子
     *
     * @param wordId
     * @return
     */
    public List<ExampleSentence> querySentence(String wordId) {
        Uri uri = Uri.parse(querySentences);
        List<ExampleSentence> list = new ArrayList<>();
        String[] columns = new String[]{"sentence_id", "word_id", "sentence", "mean"};
        String[] selectors = new String[]{wordId};
        Cursor c = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            c = resolver.query(uri, columns, "word_id=?", selectors, null, null);
        }
        while (c.moveToNext()) {
            String sentence_id = c.getString(c.getColumnIndex("sentence_id"));
            String word_id = c.getString(c.getColumnIndex("word_id"));
            String sentence = c.getString(c.getColumnIndex("sentence"));
            String mean = c.getString(c.getColumnIndex("mean"));
            ExampleSentence sentenceObj = new ExampleSentence(sentence_id, word_id, sentence, mean);
            list.add(sentenceObj);
        }
        return list;
    }

    /**
     * 根据给出的句子插入一个句子
     *
     * @param sentence
     * @return
     */
    public long insertSentence(ExampleSentence sentence) {
        Uri uri = Uri.parse(insertSentence);
        ContentValues contentValues = new ContentValues();
        contentValues.put("word_id", sentence.getWordId());
        contentValues.put("sentence", sentence.getSentence());
        contentValues.put("mean", sentence.getMean());
        Uri insert = resolver.insert(uri, contentValues);
        return ContentUris.parseId(insert);
    }

    /**
     * 根据句子id删除特定的句子，一般用不到，因为不写相应接口
     *
     * @param sentenceId
     * @return
     */
    public int deleteSentenceBySelf(String sentenceId) {
        Uri uri = Uri.parse(deleteSentences);
        String selection = "sentence_id=?";
        String[] selectArg = {sentenceId};
        return resolver.delete(uri, selection, selectArg);
    }

    /**
     * 根据传入的单词id删除句子，删除单词的时候使用
     *
     * @param wordId
     * @return
     */
    public int deleteSentenceByWord(String wordId) {
        Uri uri = Uri.parse(deleteSentences);
        String selection = "word_id=?";
        String[] selectArg = {wordId};
        return resolver.delete(uri, selection, selectArg);
    }

    /**
     * 改词
     * @param word
     * @return
     */
    public int updateWord(Word word) {
        Uri uri = Uri.parse(updateWord);
        ContentValues contentValues = new ContentValues();
        contentValues.put("word", word.getWord());
        contentValues.put("word_mean", word.getWordMean());
        String selection = "word_id=?";
        String[] selectionArg = {word.getWordId()};
        return resolver.update(uri, contentValues, selection, selectionArg);
    }


}
