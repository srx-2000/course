package com.srx.test2.Api;


public class Main {
    private static final String APP_ID = "20160607000022919";
    private static final String SECURITY_KEY = "666LECAoOcuiIv7xZe70";

    public Main() {
    }

    public static void main(String[] args) {
        TransApi api = new TransApi("20200312000397153", "BT5RjK9zi8m3hwJbJuM9");
        String query = "高度600米";
        System.out.println(api.getTransResult(query, "auto", "auto"));
    }
}
