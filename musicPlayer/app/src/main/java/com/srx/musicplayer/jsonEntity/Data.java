package com.srx.musicplayer.jsonEntity;

import java.util.List;

public class Data {

    /**
     * code : 200
     * data : [{"code":200,"expi":1200,"flag":64,"level":"standard","fee":8,"type":"mp3","canExtend":false,"url":"https://m8.music.126.net/20201008230138/2718bc374f8c4cda6a959d03a12b723a/ymusic/ef75/542e/ac9e/9e503ec5d9f3966b39fdc141444ca590.mp3","gain":0,"br":128000,"uf":null,"size":2291296,"encodeType":"mp3","id":1298733696,"md5":"9e503ec5d9f3966b39fdc141444ca590","payed":0,"freeTrialInfo":null}]
     */
    private int code;
    private List<DataEntity> data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * code : 200
         * expi : 1200
         * flag : 64
         * level : standard
         * fee : 8
         * type : mp3
         * canExtend : false
         * url : https://m8.music.126.net/20201008230138/2718bc374f8c4cda6a959d03a12b723a/ymusic/ef75/542e/ac9e/9e503ec5d9f3966b39fdc141444ca590.mp3
         * gain : 0
         * br : 128000
         * uf : null
         * size : 2291296
         * encodeType : mp3
         * id : 1298733696
         * md5 : 9e503ec5d9f3966b39fdc141444ca590
         * payed : 0
         * freeTrialInfo : null
         */
        private int code;
        private int expi;
        private int flag;
        private String level;
        private int fee;
        private String type;
        private boolean canExtend;
        private String url;
        private int gain;
        private int br;
        private String uf;
        private int size;
        private String encodeType;
        private int id;
        private String md5;
        private int payed;
        private String freeTrialInfo;

        public void setCode(int code) {
            this.code = code;
        }

        public void setExpi(int expi) {
            this.expi = expi;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setCanExtend(boolean canExtend) {
            this.canExtend = canExtend;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setGain(int gain) {
            this.gain = gain;
        }

        public void setBr(int br) {
            this.br = br;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setEncodeType(String encodeType) {
            this.encodeType = encodeType;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public void setFreeTrialInfo(String freeTrialInfo) {
            this.freeTrialInfo = freeTrialInfo;
        }

        public int getCode() {
            return code;
        }

        public int getExpi() {
            return expi;
        }

        public int getFlag() {
            return flag;
        }

        public String getLevel() {
            return level;
        }

        public int getFee() {
            return fee;
        }

        public String getType() {
            return type;
        }

        public boolean isCanExtend() {
            return canExtend;
        }

        public String getUrl() {
            return url;
        }

        public int getGain() {
            return gain;
        }

        public int getBr() {
            return br;
        }

        public String getUf() {
            return uf;
        }

        public int getSize() {
            return size;
        }

        public String getEncodeType() {
            return encodeType;
        }

        public int getId() {
            return id;
        }

        public String getMd5() {
            return md5;
        }

        public int getPayed() {
            return payed;
        }

        public String getFreeTrialInfo() {
            return freeTrialInfo;
        }
    }
}
