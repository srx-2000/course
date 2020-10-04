package com.srx.test2.contentProvider;

/**
 * @author srx
 * @description
 * @create 2020-09-28 12:18:57
 */
public abstract class providerUri {

    public static final String CONTENT="content://";

    public static final String AUTHORITIES = "com.srx.wordBook";

    public static final String WORD_TABLE = "/word";

    public static final String SENTENCE_TABLE = "/sentence";

    public static final String INSERT = "/insert";

    public static final String DELETE = "/delete";

    public static final String QUERY = "/query";

    public static final String UPDATE = "/update";

    public static final String UPDATE_WORD = UPDATE+WORD_TABLE;

    public static final String UPDATE_SENTENCE = UPDATE+SENTENCE_TABLE+WORD_TABLE;

    public static final String INSERT_WORD = INSERT+WORD_TABLE;

    public static final String INSERT_SENTENCES = INSERT+SENTENCE_TABLE+WORD_TABLE;

    public static final String QUERY_WORD = QUERY+WORD_TABLE;

    public static final String QUERY_SENTENCES = QUERY+SENTENCE_TABLE+WORD_TABLE;

    public static final String DELETE_WORD = DELETE+WORD_TABLE;

    public static final String DELETE_SENTENCE = DELETE+SENTENCE_TABLE;

    public static final String DELETE_SENTENCES = DELETE+SENTENCE_TABLE+WORD_TABLE;

}
