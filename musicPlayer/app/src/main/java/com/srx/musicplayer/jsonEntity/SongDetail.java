package com.srx.musicplayer.jsonEntity;

import java.util.List;

public class SongDetail {
    /**
     * privileges : [{"st":0,"flag":1284,"chargeInfoList":[{"rate":128000,"chargeMessage":null,"chargeType":1,"chargeUrl":null},{"rate":192000,"chargeMessage":null,"chargeType":1,"chargeUrl":null},{"rate":320000,"chargeMessage":null,"chargeType":1,"chargeUrl":null},{"rate":999000,"chargeMessage":null,"chargeType":1,"chargeUrl":null}],"subp":0,"fl":0,"fee":1,"dl":0,"downloadMaxbr":999000,"cp":0,"preSell":false,"cs":false,"toast":false,"playMaxbr":999000,"maxbr":999000,"id":347230,"pl":0,"sp":0,"payed":0}]
     * code : 200
     * songs : [{"no":1,"rt":"600902000004240302","copyright":1,"fee":1,"rurl":null,"mst":9,"pst":0,"pop":100,"dt":326000,"rtype":0,"s_id":0,"rtUrls":[],"id":347230,"st":0,"a":null,"cd":"1","publishTime":746812800000,"cf":"","originCoverType":0,"h":{"br":320000,"fid":0,"size":13042459,"vd":0},"mv":376199,"al":{"picUrl":"http://p1.music.126.net/QHw-RuMwfQkmgtiyRpGs0Q==/102254581395219.jpg","name":"海阔天空","tns":[],"id":34209,"pic":102254581395219},"l":{"br":128000,"fid":0,"size":5217009,"vd":1324},"m":{"br":192000,"fid":0,"size":7825492,"vd":2310},"cp":7002,"alia":[],"djId":0,"noCopyrightRcmd":null,"crbt":null,"single":0,"ar":[{"name":"Beyond","tns":[],"alias":[],"id":11127}],"rtUrl":null,"ftype":0,"t":0,"v":101,"name":"海阔天空","mark":8192}]
     */
    private List<PrivilegesEntity> privileges;
    private int code;
    private List<SongsEntity> songs;

    public void setPrivileges(List<PrivilegesEntity> privileges) {
        this.privileges = privileges;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setSongs(List<SongsEntity> songs) {
        this.songs = songs;
    }

    public List<PrivilegesEntity> getPrivileges() {
        return privileges;
    }

    public int getCode() {
        return code;
    }

    public List<SongsEntity> getSongs() {
        return songs;
    }

    public class PrivilegesEntity {
        /**
         * st : 0
         * flag : 1284
         * chargeInfoList : [{"rate":128000,"chargeMessage":null,"chargeType":1,"chargeUrl":null},{"rate":192000,"chargeMessage":null,"chargeType":1,"chargeUrl":null},{"rate":320000,"chargeMessage":null,"chargeType":1,"chargeUrl":null},{"rate":999000,"chargeMessage":null,"chargeType":1,"chargeUrl":null}]
         * subp : 0
         * fl : 0
         * fee : 1
         * dl : 0
         * downloadMaxbr : 999000
         * cp : 0
         * preSell : false
         * cs : false
         * toast : false
         * playMaxbr : 999000
         * maxbr : 999000
         * id : 347230
         * pl : 0
         * sp : 0
         * payed : 0
         */
        private int st;
        private int flag;
        private List<ChargeInfoListEntity> chargeInfoList;
        private int subp;
        private int fl;
        private int fee;
        private int dl;
        private int downloadMaxbr;
        private int cp;
        private boolean preSell;
        private boolean cs;
        private boolean toast;
        private int playMaxbr;
        private int maxbr;
        private int id;
        private int pl;
        private int sp;
        private int payed;

        public void setSt(int st) {
            this.st = st;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public void setChargeInfoList(List<ChargeInfoListEntity> chargeInfoList) {
            this.chargeInfoList = chargeInfoList;
        }

        public void setSubp(int subp) {
            this.subp = subp;
        }

        public void setFl(int fl) {
            this.fl = fl;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public void setDl(int dl) {
            this.dl = dl;
        }

        public void setDownloadMaxbr(int downloadMaxbr) {
            this.downloadMaxbr = downloadMaxbr;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public void setPreSell(boolean preSell) {
            this.preSell = preSell;
        }

        public void setCs(boolean cs) {
            this.cs = cs;
        }

        public void setToast(boolean toast) {
            this.toast = toast;
        }

        public void setPlayMaxbr(int playMaxbr) {
            this.playMaxbr = playMaxbr;
        }

        public void setMaxbr(int maxbr) {
            this.maxbr = maxbr;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setPl(int pl) {
            this.pl = pl;
        }

        public void setSp(int sp) {
            this.sp = sp;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getSt() {
            return st;
        }

        public int getFlag() {
            return flag;
        }

        public List<ChargeInfoListEntity> getChargeInfoList() {
            return chargeInfoList;
        }

        public int getSubp() {
            return subp;
        }

        public int getFl() {
            return fl;
        }

        public int getFee() {
            return fee;
        }

        public int getDl() {
            return dl;
        }

        public int getDownloadMaxbr() {
            return downloadMaxbr;
        }

        public int getCp() {
            return cp;
        }

        public boolean isPreSell() {
            return preSell;
        }

        public boolean isCs() {
            return cs;
        }

        public boolean isToast() {
            return toast;
        }

        public int getPlayMaxbr() {
            return playMaxbr;
        }

        public int getMaxbr() {
            return maxbr;
        }

        public int getId() {
            return id;
        }

        public int getPl() {
            return pl;
        }

        public int getSp() {
            return sp;
        }

        public int getPayed() {
            return payed;
        }

        public class ChargeInfoListEntity {
            /**
             * rate : 128000
             * chargeMessage : null
             * chargeType : 1
             * chargeUrl : null
             */
            private int rate;
            private String chargeMessage;
            private int chargeType;
            private String chargeUrl;

            public void setRate(int rate) {
                this.rate = rate;
            }

            public void setChargeMessage(String chargeMessage) {
                this.chargeMessage = chargeMessage;
            }

            public void setChargeType(int chargeType) {
                this.chargeType = chargeType;
            }

            public void setChargeUrl(String chargeUrl) {
                this.chargeUrl = chargeUrl;
            }

            public int getRate() {
                return rate;
            }

            public String getChargeMessage() {
                return chargeMessage;
            }

            public int getChargeType() {
                return chargeType;
            }

            public String getChargeUrl() {
                return chargeUrl;
            }
        }
    }

    public class SongsEntity {
        /**
         * no : 1
         * rt : 600902000004240302
         * copyright : 1
         * fee : 1
         * rurl : null
         * mst : 9
         * pst : 0
         * pop : 100.0
         * dt : 326000
         * rtype : 0
         * s_id : 0
         * rtUrls : []
         * id : 347230
         * st : 0
         * a : null
         * cd : 1
         * publishTime : 746812800000
         * cf :
         * originCoverType : 0
         * h : {"br":320000,"fid":0,"size":13042459,"vd":0}
         * mv : 376199
         * al : {"picUrl":"http://p1.music.126.net/QHw-RuMwfQkmgtiyRpGs0Q==/102254581395219.jpg","name":"海阔天空","tns":[],"id":34209,"pic":102254581395219}
         * l : {"br":128000,"fid":0,"size":5217009,"vd":1324}
         * m : {"br":192000,"fid":0,"size":7825492,"vd":2310}
         * cp : 7002
         * alia : []
         * djId : 0
         * noCopyrightRcmd : null
         * crbt : null
         * single : 0
         * ar : [{"name":"Beyond","tns":[],"alias":[],"id":11127}]
         * rtUrl : null
         * ftype : 0
         * t : 0
         * v : 101
         * name : 海阔天空
         * mark : 8192
         */
        private int no;
        private String rt;
        private int copyright;
        private int fee;
        private String rurl;
        private int mst;
        private int pst;
        private double pop;
        private int dt;
        private int rtype;
        private int s_id;
        private List<?> rtUrls;
        private int id;
        private int st;
        private String a;
        private String cd;
        private long publishTime;
        private String cf;
        private int originCoverType;
        private HEntity h;
        private int mv;
        private AlEntity al;
        private LEntity l;
        private MEntity m;
        private int cp;
        private List<?> alia;
        private int djId;
        private String noCopyrightRcmd;
        private String crbt;
        private int single;
        private List<ArEntity> ar;
        private String rtUrl;
        private int ftype;
        private int t;
        private int v;
        private String name;
        private int mark;

        public void setNo(int no) {
            this.no = no;
        }

        public void setRt(String rt) {
            this.rt = rt;
        }

        public void setCopyright(int copyright) {
            this.copyright = copyright;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public void setRurl(String rurl) {
            this.rurl = rurl;
        }

        public void setMst(int mst) {
            this.mst = mst;
        }

        public void setPst(int pst) {
            this.pst = pst;
        }

        public void setPop(double pop) {
            this.pop = pop;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public void setRtype(int rtype) {
            this.rtype = rtype;
        }

        public void setS_id(int s_id) {
            this.s_id = s_id;
        }

        public void setRtUrls(List<?> rtUrls) {
            this.rtUrls = rtUrls;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public void setA(String a) {
            this.a = a;
        }

        public void setCd(String cd) {
            this.cd = cd;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public void setCf(String cf) {
            this.cf = cf;
        }

        public void setOriginCoverType(int originCoverType) {
            this.originCoverType = originCoverType;
        }

        public void setH(HEntity h) {
            this.h = h;
        }

        public void setMv(int mv) {
            this.mv = mv;
        }

        public void setAl(AlEntity al) {
            this.al = al;
        }

        public void setL(LEntity l) {
            this.l = l;
        }

        public void setM(MEntity m) {
            this.m = m;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public void setAlia(List<?> alia) {
            this.alia = alia;
        }

        public void setDjId(int djId) {
            this.djId = djId;
        }

        public void setNoCopyrightRcmd(String noCopyrightRcmd) {
            this.noCopyrightRcmd = noCopyrightRcmd;
        }

        public void setCrbt(String crbt) {
            this.crbt = crbt;
        }

        public void setSingle(int single) {
            this.single = single;
        }

        public void setAr(List<ArEntity> ar) {
            this.ar = ar;
        }

        public void setRtUrl(String rtUrl) {
            this.rtUrl = rtUrl;
        }

        public void setFtype(int ftype) {
            this.ftype = ftype;
        }

        public void setT(int t) {
            this.t = t;
        }

        public void setV(int v) {
            this.v = v;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public int getNo() {
            return no;
        }

        public String getRt() {
            return rt;
        }

        public int getCopyright() {
            return copyright;
        }

        public int getFee() {
            return fee;
        }

        public String getRurl() {
            return rurl;
        }

        public int getMst() {
            return mst;
        }

        public int getPst() {
            return pst;
        }

        public double getPop() {
            return pop;
        }

        public int getDt() {
            return dt;
        }

        public int getRtype() {
            return rtype;
        }

        public int getS_id() {
            return s_id;
        }

        public List<?> getRtUrls() {
            return rtUrls;
        }

        public int getId() {
            return id;
        }

        public int getSt() {
            return st;
        }

        public String getA() {
            return a;
        }

        public String getCd() {
            return cd;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public String getCf() {
            return cf;
        }

        public int getOriginCoverType() {
            return originCoverType;
        }

        public HEntity getH() {
            return h;
        }

        public int getMv() {
            return mv;
        }

        public AlEntity getAl() {
            return al;
        }

        public LEntity getL() {
            return l;
        }

        public MEntity getM() {
            return m;
        }

        public int getCp() {
            return cp;
        }

        public List<?> getAlia() {
            return alia;
        }

        public int getDjId() {
            return djId;
        }

        public String getNoCopyrightRcmd() {
            return noCopyrightRcmd;
        }

        public String getCrbt() {
            return crbt;
        }

        public int getSingle() {
            return single;
        }

        public List<ArEntity> getAr() {
            return ar;
        }

        public String getRtUrl() {
            return rtUrl;
        }

        public int getFtype() {
            return ftype;
        }

        public int getT() {
            return t;
        }

        public int getV() {
            return v;
        }

        public String getName() {
            return name;
        }

        public int getMark() {
            return mark;
        }

        public class HEntity {
            /**
             * br : 320000
             * fid : 0
             * size : 13042459
             * vd : 0.0
             */
            private int br;
            private int fid;
            private int size;
            private double vd;

            public void setBr(int br) {
                this.br = br;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public void setVd(double vd) {
                this.vd = vd;
            }

            public int getBr() {
                return br;
            }

            public int getFid() {
                return fid;
            }

            public int getSize() {
                return size;
            }

            public double getVd() {
                return vd;
            }
        }

        public class AlEntity {
            /**
             * picUrl : http://p1.music.126.net/QHw-RuMwfQkmgtiyRpGs0Q==/102254581395219.jpg
             * name : 海阔天空
             * tns : []
             * id : 34209
             * pic : 102254581395219
             */
            private String picUrl;
            private String name;
            private List<?> tns;
            private int id;
            private long pic;

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setTns(List<?> tns) {
                this.tns = tns;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setPic(long pic) {
                this.pic = pic;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public String getName() {
                return name;
            }

            public List<?> getTns() {
                return tns;
            }

            public int getId() {
                return id;
            }

            public long getPic() {
                return pic;
            }
        }

        public class LEntity {
            /**
             * br : 128000
             * fid : 0
             * size : 5217009
             * vd : 1324.0
             */
            private int br;
            private int fid;
            private int size;
            private double vd;

            public void setBr(int br) {
                this.br = br;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public void setVd(double vd) {
                this.vd = vd;
            }

            public int getBr() {
                return br;
            }

            public int getFid() {
                return fid;
            }

            public int getSize() {
                return size;
            }

            public double getVd() {
                return vd;
            }
        }

        public class MEntity {
            /**
             * br : 192000
             * fid : 0
             * size : 7825492
             * vd : 2310.0
             */
            private int br;
            private int fid;
            private int size;
            private double vd;

            public void setBr(int br) {
                this.br = br;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public void setVd(double vd) {
                this.vd = vd;
            }

            public int getBr() {
                return br;
            }

            public int getFid() {
                return fid;
            }

            public int getSize() {
                return size;
            }

            public double getVd() {
                return vd;
            }
        }

        public class ArEntity {
            /**
             * name : Beyond
             * tns : []
             * alias : []
             * id : 11127
             */
            private String name;
            private List<?> tns;
            private List<?> alias;
            private int id;

            public void setName(String name) {
                this.name = name;
            }

            public void setTns(List<?> tns) {
                this.tns = tns;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public List<?> getTns() {
                return tns;
            }

            public List<?> getAlias() {
                return alias;
            }

            public int getId() {
                return id;
            }
        }
    }
}
