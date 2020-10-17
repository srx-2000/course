package com.srx.musicplayer.jsonEntity;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private long songId;
    private String songName;
    private String singer;

    public Song(int id, long songId, String songName, String singer) {
        this.id = id;
        this.songId = songId;
        this.songName = songName;
        this.singer = singer;
    }

    public Song() {
    }

    public Song(long songId, String songName, String singer) {
        this.songId = songId;
        this.songName = songName;
        this.singer = singer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songId=" + songId +
                ", songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
