package com.srx.test2.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.srx.test2.entities.ExampleSentence;
import com.srx.test2.entities.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * @author srx
 * @description
 * @create 2020-09-26 15:55:19
 */
public class DBMethod {

    private DBHelper dbHelper;
    private String name;
    private SQLiteDatabase dbWriter;
    private SQLiteDatabase dbReader;


    public DBMethod(Context context, String name) {
        this.name = name;
        this.dbHelper = new DBHelper(context, name, null, 1);
    }


    private void initDBer() {
        if (dbHelper != null) {
            this.dbWriter = dbHelper.getWritableDatabase();
            this.dbReader = dbHelper.getReadableDatabase();
        }
    }

    /**
     * 添加一个word
     *
     * @param word
     * @return
     */
    public boolean insertWord(Word word) {
        //第一种调用方法
//        ContentValues values=new ContentValues();
//        values.put("word_id",word.getWordId());
//        values.put("word",word.getWord());
//        values.put("word_mean",word.getWordMean());
//        long flag = dbWriter.insert("word", null, values);
        //第二种调用方法
        if (dbWriter.isOpen()) {
            initDBer();
            String sql = "insert into word(word,word_mean) values(?,?)";
            Object arg[] = new Object[]{word.getWord(), word.getWordMean()};
            dbWriter.execSQL(sql, arg);
            return true;
        } else
            return false;
    }

    /**
     * 通过wordId删除一个word
     *
     * @param wordId
     * @return
     */
    public Boolean deleteWord(String wordId) {
        if (dbWriter.isOpen()) {
            initDBer();
            String sql = "delete from word where word_id=?";
            Object arg[] = new Object[]{wordId};
            dbWriter.execSQL(sql, arg);
            return true;
        } else
            return false;
    }

    /**
     * 通过传入的word，更改wordDetail，目前设计可以更改单词，意思
     *
     * @param word
     * @return
     */
    public boolean updateWordData(Word word) {
        if (dbWriter.isOpen()) {
            initDBer();
            String sql = "update word set word=?,word_mean=? where word_id=?";
            Object arg[] = new Object[]{word.getWord(), word.getWordMean(), word.getWordId()};
            dbWriter.execSQL(sql, arg);
            return true;
        } else
            return false;
    }

    /**
     * 通过传入的字符串模糊查询word，并返回一个word，其中应包含基础信息：id，mean，word
     *
     * @param wordName
     * @return
     */
    public List<Word> queryWordByBlurry(String wordName) {
        List<Word> list = new ArrayList<>();
        initDBer();
        String[] columns = new String[]{"word_id", "word", "word_mean"};
        String[] selectors = new String[]{"%" + wordName + "%"};
        Cursor c = dbReader.query(false, "word", columns, "word like ?", selectors, null, null, null, null);
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
     * 通过wordId查询单个word的详细信息
     *
     * @param wordId
     * @return
     */
    public Word queryWord(String wordId) {
        initDBer();
        String[] columns = new String[]{"word_id", "word", "word_mean"};
        String[] selectors = new String[]{wordId};
        Cursor c = dbReader.query(false, "word", columns, "word_id=?", selectors, null, null, null, null);
        c.moveToFirst();
        String word_id = c.getString(c.getColumnIndex("word_id"));
        String word = c.getString(c.getColumnIndex("word"));
        String word_mean = c.getString(c.getColumnIndex("word_mean"));
        Word wordObj = new Word(word_id, word, word_mean);
        return wordObj;
    }

    public String queryWordId(String word, String wordMean) {
        initDBer();
        String[] columns = new String[]{"word_id"};
        String[] selectors = new String[]{word, wordMean};
        Cursor c = dbReader.query(true, "word", columns, "word=? and word_mean=?", selectors, null, null, null, null);
        c.moveToFirst();
        String word_id = c.getString(c.getColumnIndex("word_id"));
        return word_id;
    }

    public List<Word> queryWord() {
        List<Word> list = new ArrayList<>();
        initDBer();
        String[] columns = new String[]{"word_id", "word", "word_mean"};
        Cursor c = dbReader.query(false, "word", columns, null, null, null, null, null, null);
        while (c.moveToNext()) {
            String word_id = c.getString(c.getColumnIndex("word_id"));
            String word = c.getString(c.getColumnIndex("word"));
            String word_mean = c.getString(c.getColumnIndex("word_mean"));
            Word wordObj = new Word(word_id, word, word_mean);
            list.add(wordObj);
        }
        return list;
    }

    public List<ExampleSentence> querySentence(String wordId) {
        List<ExampleSentence> list = new ArrayList<>();
        initDBer();
        String[] columns = new String[]{"sentence_id", "word_id", "sentence", "mean"};
        String[] selectors = new String[]{wordId};
        Cursor c = dbReader.query(false, "sentence", columns, "word_id=?", selectors, null, null, null, null);
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

    public boolean insertSentence(ExampleSentence sentence) {
        if (dbWriter.isOpen()) {
            initDBer();
            String sql = "insert into sentence(word_id,sentence,mean) values(?,?,?)";
            Object arg[] = new Object[]{sentence.getWordId(), sentence.getSentence(), sentence.getMean()};
            dbWriter.execSQL(sql, arg);
            return true;
        } else
            return false;
    }

    /**
     * 更新例句，暂定只可以更新句子的原句和意思，并不能更新单词id
     *
     * @param newSentence
     */
    public boolean updateSentence(ExampleSentence newSentence) {
        if (dbWriter.isOpen()) {
            initDBer();
            String sql = "update sentence set sentence=?,mean=? where sentence_id=?";
            Object arg[] = new Object[]{newSentence.getSentence(), newSentence.getMean(), newSentence.getSentenceId()};
            dbWriter.execSQL(sql, arg);
            return true;
        } else
            return false;
    }

    /**
     * 通过句子id删除单个句子
     *
     * @param sentenceId
     */
    public boolean deleteSentenceBySelf(String sentenceId) {
        if (dbWriter.isOpen()) {
            initDBer();
            String sql = "delete from sentence where sentence_id=?";
            Object arg[] = new Object[]{sentenceId};
            dbWriter.execSQL(sql, arg);
            return true;
        } else
            return false;
    }

    /**
     * 通过单词id删除与此单词相关的所有句子
     *
     * @param wordId
     */
    public boolean deleteSentenceByword(String wordId) {
        if (dbWriter.isOpen()) {
            initDBer();
            String sql = "delete from sentence where word_id=?";
            Object arg[] = new Object[]{wordId};
            dbWriter.execSQL(sql, arg);
            return true;
        } else
            return false;
    }
}
