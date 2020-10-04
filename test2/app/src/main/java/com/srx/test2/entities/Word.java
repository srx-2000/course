package com.srx.test2.entities;

import java.io.Serializable;
import java.util.List;

/**
 * @author srx
 * @description
 * @create 2020-09-23 14:29:52
 */
public class Word implements Serializable {
    private String wordId;
    private String word;
    private String wordMean;

    public Word() {
    }

    public Word(String word, String wordMean) {
        this.word = word;
        this.wordMean = wordMean;
    }

    public Word(String wordId, String word, String wordMean) {
        this.wordId = wordId;
        this.word = word;
        this.wordMean = wordMean;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordMean() {
        return wordMean;
    }

    public void setWordMean(String wordMean) {
        this.wordMean = wordMean;
    }


    @Override
    public String toString() {
        return "Word{" +
                "wordId='" + wordId + '\'' +
                ", word='" + word + '\'' +
                ", wordMean='" + wordMean + '\'' +
                '}';
    }
}
