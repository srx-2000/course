package com.srx.test2.entities;

import java.io.Serializable;

/**
 * @author srx
 * @description
 * @create 2020-09-23 19:36:02
 */
public class ExampleSentence implements Serializable {
    private String wordId;
    private String sentenceId;
    private String sentence;
    private String mean;

    public ExampleSentence() {
    }

    public ExampleSentence(String wordId, String sentenceId, String sentence, String mean) {
        this.wordId = wordId;
        this.sentenceId = sentenceId;
        this.sentence = sentence;
        this.mean = mean;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(String sentenceId) {
        this.sentenceId = sentenceId;
    }

    public ExampleSentence(String wordId, String sentence, String mean) {
        this.wordId = wordId;
        this.sentence = sentence;
        this.mean = mean;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    @Override
    public String toString() {
        return "ExampleSentence{" +
                "wordId='" + wordId + '\'' +
                ", sentenceId='" + sentenceId + '\'' +
                ", sentence='" + sentence + '\'' +
                ", mean='" + mean + '\'' +
                '}';
    }
}
