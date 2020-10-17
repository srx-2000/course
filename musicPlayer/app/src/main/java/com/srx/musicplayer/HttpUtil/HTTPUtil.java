package com.srx.musicplayer.HttpUtil;

import android.widget.ArrayAdapter;
import com.google.gson.Gson;
import com.srx.musicplayer.jsonEntity.*;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTTPUtil {

    public static String url1 = "https://api.imjad.cn/cloudmusic/";
    public static String url2 = "https://musicapi.leanapp.cn";
    private static OkHttpClient client;

    public static String getUrl(boolean flag) {
        if (flag)
            return url2;
        else
            return url1;
    }

    public static void setUrl1(String url1) {
        HTTPUtil.url1 = url1;
    }

    public static void setUrl2(String url2) {
        HTTPUtil.url2 = url2;
    }

    /**
     * 使用的是https://api.imjad.cn/cloudmusic这个接口，提供的方法比较少，主要用于弥补下面那个接口无法请求歌曲url的问题
     *
     * @param type
     * @param id
     * @return
     */
    private static Response doGetMethod1(String type, String id) {
        client = new OkHttpClient();
        final Request request = new Request.Builder()
                .get()
                .url(url1 + "?type=" + type + "&id=" + id)
                .build();
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String getSingleSongMp3(String songId) {
        String string = null;
        try {
            Response response = doGetMethod1("song", songId);
            string = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Data data = gson.fromJson(string, Data.class);
        String url = data.getData().get(0).getUrl();
        return url;
    }

    public static List<String> getSongListMethod1(String listId) {
        String string = null;
        try {
            Response response = doGetMethod1("playlist", listId);
            string = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> songList = new ArrayList<>();
        Gson gson = new Gson();
        SongList list = gson.fromJson(string, SongList.class);
        List<SongList.PlaylistEntity.TracksEntity> tracks = list.getPlaylist().getTracks();
        for (SongList.PlaylistEntity.TracksEntity t : tracks) {
            String id = String.valueOf(t.getId());
            songList.add(id);
        }

        return songList;
    }

    public static Response doGetMethod2(String path, String id) {
        OkHttpClient client = new OkHttpClient();
        Request request;
        HttpUrl.Builder builder;
        if (path.equals("/song/detail")) {
            request = new Request.Builder()
                    .get()
                    .url(url2 + path + "?ids=" + id)
                    .build();
        } else if (path.equals("/search")) {
            request = new Request.Builder()
                    .get()
                    .url(url2 + path + "?keywords=" + id)
                    .build();
        } else {
            if (id != null) {
                request = new Request.Builder()
                        .get()
                        .url(url2 + path + "?id=" + id)
                        .build();
            } else {
                request = new Request.Builder()
                        .get()
                        .url(url2 + path)
                        .build();
            }
        }
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    public static List<String> getSongListMethod2(String listId) {
        String string = null;
        try {
            Response response = doGetMethod2("/playlist/detail", listId);
            string = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> songList = new ArrayList<>();
        Gson gson = new Gson();
        SongList list = gson.fromJson(string, SongList.class);
        List<SongList.PlaylistEntity.TracksEntity> tracks = list.getPlaylist().getTracks();
        for (SongList.PlaylistEntity.TracksEntity t : tracks) {
            String id = String.valueOf(t.getId());
            songList.add(id);
        }
        return songList;
    }

    public static List<String> getHotList() {
        List<String> hotList = new ArrayList<>();
        String string = null;
        try {
            Response response = doGetMethod2("/search/hot", null);
            string = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        HotList list = gson.fromJson(string, HotList.class);
        List<HotList.ResultEntity.HotsEntity> hots = list.getResult().getHots();
        for (HotList.ResultEntity.HotsEntity item : hots) {
            hotList.add(item.getFirst());
        }
        return hotList;
    }

    public static Song getSingleSongDetail(String songId) {
        String string = null;
        try {
            Response response = doGetMethod2("/song/detail", songId);
            string = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        SongDetail songDetail = gson.fromJson(string, SongDetail.class);
        SongDetail.SongsEntity songsEntity = songDetail.getSongs().get(0);
        Song song = new Song(songsEntity.getId(), songsEntity.getName(), songsEntity.getAr().get(0).getName());
        return song;
    }

    public static List<Song> searchSong(String searchString) {
        String string = null;
        try {
            Response response = doGetMethod2("/search", searchString);
            string = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson=new Gson();
        SearchResult searchResult = gson.fromJson(string, SearchResult.class);
        List<SearchResult.ResultEntity.SongsEntity> songs = searchResult.getResult().getSongs();
        List<Song> songList=new  ArrayList<>();
        for (SearchResult.ResultEntity.SongsEntity song :songs) {
            songList.add(new Song(song.getId(),song.getName(),song.getArtists().get(0).getName()));
        }
        return songList;
    }
}
