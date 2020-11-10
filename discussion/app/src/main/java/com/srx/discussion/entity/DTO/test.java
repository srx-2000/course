package com.srx.discussion.entity.DTO;

import java.util.List;

public class test {


    private String cachetime;
    private List<OtherlistEntity> otherlist;
    private Add_dailyEntity add_daily;
    private String sustotal;
    private String asymptomNum;
    private List<JwsrTopEntity> jwsrTop;
    private List<WorldlistEntity> worldlist;
    private String curetotal;
    private String mtime;
    private List<ListEntity> list;
    private String heconNum;
    private String gntotal;
    private CaseClearCityInfoEntity caseClearCityInfo;
    private String times;
    private String deathtotal;
    private String jwsrNum;
    private List<HistorylistEntity> historylist;
    private List<OtherhistorylistEntity> otherhistorylist;
    private String econNum;
    private OthertotalEntity othertotal;

    public void setCachetime(String cachetime) {
        this.cachetime = cachetime;
    }

    public void setOtherlist(List<OtherlistEntity> otherlist) {
        this.otherlist = otherlist;
    }

    public void setAdd_daily(Add_dailyEntity add_daily) {
        this.add_daily = add_daily;
    }

    public void setSustotal(String sustotal) {
        this.sustotal = sustotal;
    }

    public void setAsymptomNum(String asymptomNum) {
        this.asymptomNum = asymptomNum;
    }

    public void setJwsrTop(List<JwsrTopEntity> jwsrTop) {
        this.jwsrTop = jwsrTop;
    }

    public void setWorldlist(List<WorldlistEntity> worldlist) {
        this.worldlist = worldlist;
    }

    public void setCuretotal(String curetotal) {
        this.curetotal = curetotal;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public void setHeconNum(String heconNum) {
        this.heconNum = heconNum;
    }

    public void setGntotal(String gntotal) {
        this.gntotal = gntotal;
    }

    public void setCaseClearCityInfo(CaseClearCityInfoEntity caseClearCityInfo) {
        this.caseClearCityInfo = caseClearCityInfo;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public void setDeathtotal(String deathtotal) {
        this.deathtotal = deathtotal;
    }

    public void setJwsrNum(String jwsrNum) {
        this.jwsrNum = jwsrNum;
    }

    public void setHistorylist(List<HistorylistEntity> historylist) {
        this.historylist = historylist;
    }

    public void setOtherhistorylist(List<OtherhistorylistEntity> otherhistorylist) {
        this.otherhistorylist = otherhistorylist;
    }

    public void setEconNum(String econNum) {
        this.econNum = econNum;
    }

    public void setOthertotal(OthertotalEntity othertotal) {
        this.othertotal = othertotal;
    }

    public String getCachetime() {
        return cachetime;
    }

    public List<OtherlistEntity> getOtherlist() {
        return otherlist;
    }

    public Add_dailyEntity getAdd_daily() {
        return add_daily;
    }

    public String getSustotal() {
        return sustotal;
    }

    public String getAsymptomNum() {
        return asymptomNum;
    }

    public List<JwsrTopEntity> getJwsrTop() {
        return jwsrTop;
    }

    public List<WorldlistEntity> getWorldlist() {
        return worldlist;
    }

    public String getCuretotal() {
        return curetotal;
    }

    public String getMtime() {
        return mtime;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public String getHeconNum() {
        return heconNum;
    }

    public String getGntotal() {
        return gntotal;
    }

    public CaseClearCityInfoEntity getCaseClearCityInfo() {
        return caseClearCityInfo;
    }

    public String getTimes() {
        return times;
    }

    public String getDeathtotal() {
        return deathtotal;
    }

    public String getJwsrNum() {
        return jwsrNum;
    }

    public List<HistorylistEntity> getHistorylist() {
        return historylist;
    }

    public List<OtherhistorylistEntity> getOtherhistorylist() {
        return otherhistorylist;
    }

    public String getEconNum() {
        return econNum;
    }

    public OthertotalEntity getOthertotal() {
        return othertotal;
    }

    public class OtherlistEntity {
        /**
         * conadd : 0
         * cureNum : 41742
         * deathadd : 0
         * is_show_map : 0
         * susadd : 0
         * citycode : SCDK0045
         * is_show_entrance : 1
         * susNum : 0
         * deathNum : 747
         * name : 丹麦
         * cureadd : 0
         * conNum : 56406
         * econNum : 13917
         * value : 56406
         */
        private String conadd;
        private String cureNum;
        private String deathadd;
        private int is_show_map;
        private String susadd;
        private String citycode;
        private int is_show_entrance;
        private String susNum;
        private String deathNum;
        private String name;
        private String cureadd;
        private String conNum;
        private String econNum;
        private String value;

        public void setConadd(String conadd) {
            this.conadd = conadd;
        }

        public void setCureNum(String cureNum) {
            this.cureNum = cureNum;
        }

        public void setDeathadd(String deathadd) {
            this.deathadd = deathadd;
        }

        public void setIs_show_map(int is_show_map) {
            this.is_show_map = is_show_map;
        }

        public void setSusadd(String susadd) {
            this.susadd = susadd;
        }

        public void setCitycode(String citycode) {
            this.citycode = citycode;
        }

        public void setIs_show_entrance(int is_show_entrance) {
            this.is_show_entrance = is_show_entrance;
        }

        public void setSusNum(String susNum) {
            this.susNum = susNum;
        }

        public void setDeathNum(String deathNum) {
            this.deathNum = deathNum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCureadd(String cureadd) {
            this.cureadd = cureadd;
        }

        public void setConNum(String conNum) {
            this.conNum = conNum;
        }

        public void setEconNum(String econNum) {
            this.econNum = econNum;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getConadd() {
            return conadd;
        }

        public String getCureNum() {
            return cureNum;
        }

        public String getDeathadd() {
            return deathadd;
        }

        public int getIs_show_map() {
            return is_show_map;
        }

        public String getSusadd() {
            return susadd;
        }

        public String getCitycode() {
            return citycode;
        }

        public int getIs_show_entrance() {
            return is_show_entrance;
        }

        public String getSusNum() {
            return susNum;
        }

        public String getDeathNum() {
            return deathNum;
        }

        public String getName() {
            return name;
        }

        public String getCureadd() {
            return cureadd;
        }

        public String getConNum() {
            return conNum;
        }

        public String getEconNum() {
            return econNum;
        }

        public String getValue() {
            return value;
        }
    }

    public class Add_dailyEntity {
        /**
         * wjw_addsus : 2
         * addcure_new : +86917
         * addhecon_new :  待公布
         * adddeath : 4748
         * addsus : 3
         * adddeath_new : +4748
         * addecon_new : +607
         * wjw_addsus_new :  待公布
         * addasymptom :  待公布
         * addcon_new : +92272
         * addcon : 92272
         * addcure : 86917
         * addjwsr :  待公布
         */
        private String wjw_addsus;
        private String addcure_new;
        private String addhecon_new;
        private int adddeath;
        private int addsus;
        private String adddeath_new;
        private String addecon_new;
        private String wjw_addsus_new;
        private String addasymptom;
        private String addcon_new;
        private int addcon;
        private int addcure;
        private String addjwsr;

        public void setWjw_addsus(String wjw_addsus) {
            this.wjw_addsus = wjw_addsus;
        }

        public void setAddcure_new(String addcure_new) {
            this.addcure_new = addcure_new;
        }

        public void setAddhecon_new(String addhecon_new) {
            this.addhecon_new = addhecon_new;
        }

        public void setAdddeath(int adddeath) {
            this.adddeath = adddeath;
        }

        public void setAddsus(int addsus) {
            this.addsus = addsus;
        }

        public void setAdddeath_new(String adddeath_new) {
            this.adddeath_new = adddeath_new;
        }

        public void setAddecon_new(String addecon_new) {
            this.addecon_new = addecon_new;
        }

        public void setWjw_addsus_new(String wjw_addsus_new) {
            this.wjw_addsus_new = wjw_addsus_new;
        }

        public void setAddasymptom(String addasymptom) {
            this.addasymptom = addasymptom;
        }

        public void setAddcon_new(String addcon_new) {
            this.addcon_new = addcon_new;
        }

        public void setAddcon(int addcon) {
            this.addcon = addcon;
        }

        public void setAddcure(int addcure) {
            this.addcure = addcure;
        }

        public void setAddjwsr(String addjwsr) {
            this.addjwsr = addjwsr;
        }

        public String getWjw_addsus() {
            return wjw_addsus;
        }

        public String getAddcure_new() {
            return addcure_new;
        }

        public String getAddhecon_new() {
            return addhecon_new;
        }

        public int getAdddeath() {
            return adddeath;
        }

        public int getAddsus() {
            return addsus;
        }

        public String getAdddeath_new() {
            return adddeath_new;
        }

        public String getAddecon_new() {
            return addecon_new;
        }

        public String getWjw_addsus_new() {
            return wjw_addsus_new;
        }

        public String getAddasymptom() {
            return addasymptom;
        }

        public String getAddcon_new() {
            return addcon_new;
        }

        public int getAddcon() {
            return addcon;
        }

        public int getAddcure() {
            return addcure;
        }

        public String getAddjwsr() {
            return addjwsr;
        }
    }

    public class JwsrTopEntity {
        /**
         * ename : shanghai
         * jwsrNum : 916
         * name : 上海
         */
        private String ename;
        private String jwsrNum;
        private String name;

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setJwsrNum(String jwsrNum) {
            this.jwsrNum = jwsrNum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEname() {
            return ename;
        }

        public String getJwsrNum() {
            return jwsrNum;
        }

        public String getName() {
            return name;
        }
    }

    public class WorldlistEntity {
        /**
         * cureNum : 86917
         * susNum : 3
         * deathNum : 4748
         * name : 中国
         * value : 92272
         * econNum : 607
         */
        private String cureNum;
        private String susNum;
        private String deathNum;
        private String name;
        private String value;
        private String econNum;

        public void setCureNum(String cureNum) {
            this.cureNum = cureNum;
        }

        public void setSusNum(String susNum) {
            this.susNum = susNum;
        }

        public void setDeathNum(String deathNum) {
            this.deathNum = deathNum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setEconNum(String econNum) {
            this.econNum = econNum;
        }

        public String getCureNum() {
            return cureNum;
        }

        public String getSusNum() {
            return susNum;
        }

        public String getDeathNum() {
            return deathNum;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public String getEconNum() {
            return econNum;
        }
    }

    public class ListEntity {
        /**
         * conadd : 待公布
         * cureNum : 929
         * city : [{"conadd":"待公布","cureNum":"179","zerodays":"85","asymptomNum":"2","hejian":"","conadd_str":" 待公布","citycode":"","susNum":"0","deathNum":"0","name":"境外输入人员","conNum":"188","mapName":"","econNum":"9","jwsr":""},{"conadd":"待公布","cureNum":"19","zerodays":"22","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11010100000000","susNum":"0","deathNum":"0","name":"东城区","conNum":"19","mapName":"东城区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"59","zerodays":"16","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11010200000000","susNum":"0","deathNum":"0","name":"西城区","conNum":"59","mapName":"西城区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"77","zerodays":"17","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11010500000000","susNum":"0","deathNum":"0","name":"朝阳区","conNum":"77","mapName":"朝阳区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"82","zerodays":"13","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11010800000000","susNum":"0","deathNum":"0","name":"海淀区","conNum":"82","mapName":"海淀区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"273","zerodays":"3","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11010600000000","susNum":"0","deathNum":"0","name":"丰台区","conNum":"273","mapName":"丰台区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"15","zerodays":"24","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11010700000000","susNum":"0","deathNum":"0","name":"石景山区","conNum":"15","mapName":"石景山区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"5","zerodays":"23","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11010900000000","susNum":"0","deathNum":"0","name":"门头沟区","conNum":"5","mapName":"门头沟区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"20","zerodays":"23","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11011100000000","susNum":"0","deathNum":"0","name":"房山区","conNum":"20","mapName":"房山区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"11","zerodays":"18","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11011200000000","susNum":"0","deathNum":"9","name":"通州区","conNum":"20","mapName":"通州区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"10","zerodays":"151","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11011300000000","susNum":"0","deathNum":"0","name":"顺义区","conNum":"10","mapName":"顺义区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"30","zerodays":"13","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11011400000000","susNum":"0","deathNum":"0","name":"昌平区","conNum":"30","mapName":"昌平区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"104","zerodays":"8","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11011500000000","susNum":"0","deathNum":"0","name":"大兴区","conNum":"104","mapName":"大兴区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"7","zerodays":"153","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11011600000000","susNum":"0","deathNum":"0","name":"怀柔区","conNum":"7","mapName":"怀柔区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"7","zerodays":"148","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11011800000000","susNum":"0","deathNum":"0","name":"密云区","conNum":"7","mapName":"密云区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"1","zerodays":"156","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"CN11011900000000","susNum":"0","deathNum":"0","name":"延庆区","conNum":"1","mapName":"延庆区","econNum":"0","jwsr":""},{"conadd":"待公布","cureNum":"25","zerodays":"135","asymptomNum":"","hejian":"","conadd_str":" 待公布","citycode":"","susNum":"0","deathNum":"0","name":"外地来京人员","conNum":"25","mapName":"","econNum":"0","jwsr":""}]
         * asymptomNum : 2
         * zerodays : 3
         * adddaily : {"conadd":" 待公布","econadd":" 待公布","deathadd":" 待公布","cureadd":" 待公布","conadd_n":"待公布","cureadd_n":"待公布","deathadd_n":"待公布"}
         * hejian :
         * ename : beijing
         * jwsrNum : 188
         * showCurData : 0
         * susNum : 0
         * deathNum : 9
         * name : 北京
         * value : 947
         * econNum : 9
         * jwsr : 含境外输入
         */
        private String conadd;
        private String cureNum;
        private List<CityEntity> city;
        private String asymptomNum;
        private String zerodays;
        private AdddailyEntity adddaily;
        private String hejian;
        private String ename;
        private String jwsrNum;
        private String showCurData;
        private String susNum;
        private String deathNum;
        private String name;
        private String value;
        private String econNum;
        private String jwsr;

        public void setConadd(String conadd) {
            this.conadd = conadd;
        }

        public void setCureNum(String cureNum) {
            this.cureNum = cureNum;
        }

        public void setCity(List<CityEntity> city) {
            this.city = city;
        }

        public void setAsymptomNum(String asymptomNum) {
            this.asymptomNum = asymptomNum;
        }

        public void setZerodays(String zerodays) {
            this.zerodays = zerodays;
        }

        public void setAdddaily(AdddailyEntity adddaily) {
            this.adddaily = adddaily;
        }

        public void setHejian(String hejian) {
            this.hejian = hejian;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public void setJwsrNum(String jwsrNum) {
            this.jwsrNum = jwsrNum;
        }

        public void setShowCurData(String showCurData) {
            this.showCurData = showCurData;
        }

        public void setSusNum(String susNum) {
            this.susNum = susNum;
        }

        public void setDeathNum(String deathNum) {
            this.deathNum = deathNum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setEconNum(String econNum) {
            this.econNum = econNum;
        }

        public void setJwsr(String jwsr) {
            this.jwsr = jwsr;
        }

        public String getConadd() {
            return conadd;
        }

        public String getCureNum() {
            return cureNum;
        }

        public List<CityEntity> getCity() {
            return city;
        }

        public String getAsymptomNum() {
            return asymptomNum;
        }

        public String getZerodays() {
            return zerodays;
        }

        public AdddailyEntity getAdddaily() {
            return adddaily;
        }

        public String getHejian() {
            return hejian;
        }

        public String getEname() {
            return ename;
        }

        public String getJwsrNum() {
            return jwsrNum;
        }

        public String getShowCurData() {
            return showCurData;
        }

        public String getSusNum() {
            return susNum;
        }

        public String getDeathNum() {
            return deathNum;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public String getEconNum() {
            return econNum;
        }

        public String getJwsr() {
            return jwsr;
        }

        public class CityEntity {
            /**
             * conadd : 待公布
             * cureNum : 179
             * zerodays : 85
             * asymptomNum : 2
             * hejian :
             * conadd_str :  待公布
             * citycode :
             * susNum : 0
             * deathNum : 0
             * name : 境外输入人员
             * conNum : 188
             * mapName :
             * econNum : 9
             * jwsr :
             */
            private String conadd;
            private String cureNum;
            private String zerodays;
            private String asymptomNum;
            private String hejian;
            private String conadd_str;
            private String citycode;
            private String susNum;
            private String deathNum;
            private String name;
            private String conNum;
            private String mapName;
            private String econNum;
            private String jwsr;

            public void setConadd(String conadd) {
                this.conadd = conadd;
            }

            public void setCureNum(String cureNum) {
                this.cureNum = cureNum;
            }

            public void setZerodays(String zerodays) {
                this.zerodays = zerodays;
            }

            public void setAsymptomNum(String asymptomNum) {
                this.asymptomNum = asymptomNum;
            }

            public void setHejian(String hejian) {
                this.hejian = hejian;
            }

            public void setConadd_str(String conadd_str) {
                this.conadd_str = conadd_str;
            }

            public void setCitycode(String citycode) {
                this.citycode = citycode;
            }

            public void setSusNum(String susNum) {
                this.susNum = susNum;
            }

            public void setDeathNum(String deathNum) {
                this.deathNum = deathNum;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setConNum(String conNum) {
                this.conNum = conNum;
            }

            public void setMapName(String mapName) {
                this.mapName = mapName;
            }

            public void setEconNum(String econNum) {
                this.econNum = econNum;
            }

            public void setJwsr(String jwsr) {
                this.jwsr = jwsr;
            }

            public String getConadd() {
                return conadd;
            }

            public String getCureNum() {
                return cureNum;
            }

            public String getZerodays() {
                return zerodays;
            }

            public String getAsymptomNum() {
                return asymptomNum;
            }

            public String getHejian() {
                return hejian;
            }

            public String getConadd_str() {
                return conadd_str;
            }

            public String getCitycode() {
                return citycode;
            }

            public String getSusNum() {
                return susNum;
            }

            public String getDeathNum() {
                return deathNum;
            }

            public String getName() {
                return name;
            }

            public String getConNum() {
                return conNum;
            }

            public String getMapName() {
                return mapName;
            }

            public String getEconNum() {
                return econNum;
            }

            public String getJwsr() {
                return jwsr;
            }
        }

        public class AdddailyEntity {
            /**
             * conadd :  待公布
             * econadd :  待公布
             * deathadd :  待公布
             * cureadd :  待公布
             * conadd_n : 待公布
             * cureadd_n : 待公布
             * deathadd_n : 待公布
             */
            private String conadd;
            private String econadd;
            private String deathadd;
            private String cureadd;
            private String conadd_n;
            private String cureadd_n;
            private String deathadd_n;

            public void setConadd(String conadd) {
                this.conadd = conadd;
            }

            public void setEconadd(String econadd) {
                this.econadd = econadd;
            }

            public void setDeathadd(String deathadd) {
                this.deathadd = deathadd;
            }

            public void setCureadd(String cureadd) {
                this.cureadd = cureadd;
            }

            public void setConadd_n(String conadd_n) {
                this.conadd_n = conadd_n;
            }

            public void setCureadd_n(String cureadd_n) {
                this.cureadd_n = cureadd_n;
            }

            public void setDeathadd_n(String deathadd_n) {
                this.deathadd_n = deathadd_n;
            }

            public String getConadd() {
                return conadd;
            }

            public String getEconadd() {
                return econadd;
            }

            public String getDeathadd() {
                return deathadd;
            }

            public String getCureadd() {
                return cureadd;
            }

            public String getConadd_n() {
                return conadd_n;
            }

            public String getCureadd_n() {
                return cureadd_n;
            }

            public String getDeathadd_n() {
                return deathadd_n;
            }
        }
    }

    public class CaseClearCityInfoEntity {
        /**
         * ljCityNum : 346
         * ljNoClearCityNum : 16
         * ljClearCityNum : 330
         */
        private int ljCityNum;
        private int ljNoClearCityNum;
        private int ljClearCityNum;

        public void setLjCityNum(int ljCityNum) {
            this.ljCityNum = ljCityNum;
        }

        public void setLjNoClearCityNum(int ljNoClearCityNum) {
            this.ljNoClearCityNum = ljNoClearCityNum;
        }

        public void setLjClearCityNum(int ljClearCityNum) {
            this.ljClearCityNum = ljClearCityNum;
        }

        public int getLjCityNum() {
            return ljCityNum;
        }

        public int getLjNoClearCityNum() {
            return ljNoClearCityNum;
        }

        public int getLjClearCityNum() {
            return ljClearCityNum;
        }
    }

    public class HistorylistEntity {
        /**
         * date : 08.10
         * cn_susNum : 3
         * wuhan_conNum : 50340
         * cn_heconNum : 44
         * cn_econNum : 1999
         * wjw_susNum : 2
         * wuhan_cureNum : 46471
         * cn_cureRate : 92.51
         * cn_jwsrNum : 2200
         * cn_cureNum : 82688
         * is_show : true
         * cn_deathNum : 4696
         * wuhan_susNum : null
         * cn_conadd : 113
         * cn_deathRate : 5.25
         * cn_asymptomNum : 285
         * cn_conNum : 89383
         * wuhan_deathNum : 3869
         * cn_addjwsrNum : 31
         */
        private String date;
        private String cn_susNum;
        private String wuhan_conNum;
        private String cn_heconNum;
        private String cn_econNum;
        private String wjw_susNum;
        private String wuhan_cureNum;
        private String cn_cureRate;
        private String cn_jwsrNum;
        private String cn_cureNum;
        private String is_show;
        private String cn_deathNum;
        private String wuhan_susNum;
        private String cn_conadd;
        private String cn_deathRate;
        private String cn_asymptomNum;
        private String cn_conNum;
        private String wuhan_deathNum;
        private String cn_addjwsrNum;

        public void setDate(String date) {
            this.date = date;
        }

        public void setCn_susNum(String cn_susNum) {
            this.cn_susNum = cn_susNum;
        }

        public void setWuhan_conNum(String wuhan_conNum) {
            this.wuhan_conNum = wuhan_conNum;
        }

        public void setCn_heconNum(String cn_heconNum) {
            this.cn_heconNum = cn_heconNum;
        }

        public void setCn_econNum(String cn_econNum) {
            this.cn_econNum = cn_econNum;
        }

        public void setWjw_susNum(String wjw_susNum) {
            this.wjw_susNum = wjw_susNum;
        }

        public void setWuhan_cureNum(String wuhan_cureNum) {
            this.wuhan_cureNum = wuhan_cureNum;
        }

        public void setCn_cureRate(String cn_cureRate) {
            this.cn_cureRate = cn_cureRate;
        }

        public void setCn_jwsrNum(String cn_jwsrNum) {
            this.cn_jwsrNum = cn_jwsrNum;
        }

        public void setCn_cureNum(String cn_cureNum) {
            this.cn_cureNum = cn_cureNum;
        }

        public void setIs_show(String is_show) {
            this.is_show = is_show;
        }

        public void setCn_deathNum(String cn_deathNum) {
            this.cn_deathNum = cn_deathNum;
        }

        public void setWuhan_susNum(String wuhan_susNum) {
            this.wuhan_susNum = wuhan_susNum;
        }

        public void setCn_conadd(String cn_conadd) {
            this.cn_conadd = cn_conadd;
        }

        public void setCn_deathRate(String cn_deathRate) {
            this.cn_deathRate = cn_deathRate;
        }

        public void setCn_asymptomNum(String cn_asymptomNum) {
            this.cn_asymptomNum = cn_asymptomNum;
        }

        public void setCn_conNum(String cn_conNum) {
            this.cn_conNum = cn_conNum;
        }

        public void setWuhan_deathNum(String wuhan_deathNum) {
            this.wuhan_deathNum = wuhan_deathNum;
        }

        public void setCn_addjwsrNum(String cn_addjwsrNum) {
            this.cn_addjwsrNum = cn_addjwsrNum;
        }

        public String getDate() {
            return date;
        }

        public String getCn_susNum() {
            return cn_susNum;
        }

        public String getWuhan_conNum() {
            return wuhan_conNum;
        }

        public String getCn_heconNum() {
            return cn_heconNum;
        }

        public String getCn_econNum() {
            return cn_econNum;
        }

        public String getWjw_susNum() {
            return wjw_susNum;
        }

        public String getWuhan_cureNum() {
            return wuhan_cureNum;
        }

        public String getCn_cureRate() {
            return cn_cureRate;
        }

        public String getCn_jwsrNum() {
            return cn_jwsrNum;
        }

        public String getCn_cureNum() {
            return cn_cureNum;
        }

        public String getIs_show() {
            return is_show;
        }

        public String getCn_deathNum() {
            return cn_deathNum;
        }

        public String getWuhan_susNum() {
            return wuhan_susNum;
        }

        public String getCn_conadd() {
            return cn_conadd;
        }

        public String getCn_deathRate() {
            return cn_deathRate;
        }

        public String getCn_asymptomNum() {
            return cn_asymptomNum;
        }

        public String getCn_conNum() {
            return cn_conNum;
        }

        public String getWuhan_deathNum() {
            return wuhan_deathNum;
        }

        public String getCn_addjwsrNum() {
            return cn_addjwsrNum;
        }
    }

    public class OtherhistorylistEntity {
        /**
         * date : 11.09
         * die : 1259731
         * certain_inc : 679309
         * recure_inc : 321691
         * die_inc : 7644
         * certain : 50864660
         * uncertain : 0
         * recure : 35669724
         * uncertain_inc : 0
         */
        private String date;
        private String die;
        private String certain_inc;
        private String recure_inc;
        private String die_inc;
        private String certain;
        private String uncertain;
        private String recure;
        private String uncertain_inc;

        public void setDate(String date) {
            this.date = date;
        }

        public void setDie(String die) {
            this.die = die;
        }

        public void setCertain_inc(String certain_inc) {
            this.certain_inc = certain_inc;
        }

        public void setRecure_inc(String recure_inc) {
            this.recure_inc = recure_inc;
        }

        public void setDie_inc(String die_inc) {
            this.die_inc = die_inc;
        }

        public void setCertain(String certain) {
            this.certain = certain;
        }

        public void setUncertain(String uncertain) {
            this.uncertain = uncertain;
        }

        public void setRecure(String recure) {
            this.recure = recure;
        }

        public void setUncertain_inc(String uncertain_inc) {
            this.uncertain_inc = uncertain_inc;
        }

        public String getDate() {
            return date;
        }

        public String getDie() {
            return die;
        }

        public String getCertain_inc() {
            return certain_inc;
        }

        public String getRecure_inc() {
            return recure_inc;
        }

        public String getDie_inc() {
            return die_inc;
        }

        public String getCertain() {
            return certain;
        }

        public String getUncertain() {
            return uncertain;
        }

        public String getRecure() {
            return recure;
        }

        public String getUncertain_inc() {
            return uncertain_inc;
        }
    }

    public class OthertotalEntity {
        /**
         * die : 1264259
         * certain_inc : +333554
         * recure_inc : +172875
         * die_inc : +4528
         * ecertain : 14090945
         * ecertain_inc : +156151
         * certain : 51197803
         * uncertain : 0
         * recure : 35842599
         * uncertain_inc : +0
         */
        private String die;
        private String certain_inc;
        private String recure_inc;
        private String die_inc;
        private String ecertain;
        private String ecertain_inc;
        private String certain;
        private String uncertain;
        private String recure;
        private String uncertain_inc;

        public void setDie(String die) {
            this.die = die;
        }

        public void setCertain_inc(String certain_inc) {
            this.certain_inc = certain_inc;
        }

        public void setRecure_inc(String recure_inc) {
            this.recure_inc = recure_inc;
        }

        public void setDie_inc(String die_inc) {
            this.die_inc = die_inc;
        }

        public void setEcertain(String ecertain) {
            this.ecertain = ecertain;
        }

        public void setEcertain_inc(String ecertain_inc) {
            this.ecertain_inc = ecertain_inc;
        }

        public void setCertain(String certain) {
            this.certain = certain;
        }

        public void setUncertain(String uncertain) {
            this.uncertain = uncertain;
        }

        public void setRecure(String recure) {
            this.recure = recure;
        }

        public void setUncertain_inc(String uncertain_inc) {
            this.uncertain_inc = uncertain_inc;
        }

        public String getDie() {
            return die;
        }

        public String getCertain_inc() {
            return certain_inc;
        }

        public String getRecure_inc() {
            return recure_inc;
        }

        public String getDie_inc() {
            return die_inc;
        }

        public String getEcertain() {
            return ecertain;
        }

        public String getEcertain_inc() {
            return ecertain_inc;
        }

        public String getCertain() {
            return certain;
        }

        public String getUncertain() {
            return uncertain;
        }

        public String getRecure() {
            return recure;
        }

        public String getUncertain_inc() {
            return uncertain_inc;
        }
    }
}
