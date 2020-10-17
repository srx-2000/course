package com.srx.musicplayer.jsonEntity;

import java.util.List;

public class HotList {

    /**
     * result : {"hots":[{"third":null,"iconType":1,"first":"中国新说唱 冷血","second":1},{"third":null,"iconType":1,"first":"讽刺的情书","second":1},{"third":null,"iconType":1,"first":"姚晨公开朋友圈","second":1},{"third":null,"iconType":1,"first":"鱼丁糸","second":1},{"third":null,"iconType":1,"first":"像小强一样活着","second":1},{"third":null,"iconType":1,"first":"天外来物","second":1},{"third":null,"iconType":1,"first":"Tfboys","second":1},{"third":null,"iconType":1,"first":"巴巴爸爸我看见哦","second":1},{"third":null,"iconType":1,"first":"米津玄师","second":1},{"third":null,"iconType":1,"first":"Taylor Swift","second":1}]}
     * code : 200
     */
    private ResultEntity result;
    private int code;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public class ResultEntity {
        /**
         * hots : [{"third":null,"iconType":1,"first":"中国新说唱 冷血","second":1},{"third":null,"iconType":1,"first":"讽刺的情书","second":1},{"third":null,"iconType":1,"first":"姚晨公开朋友圈","second":1},{"third":null,"iconType":1,"first":"鱼丁糸","second":1},{"third":null,"iconType":1,"first":"像小强一样活着","second":1},{"third":null,"iconType":1,"first":"天外来物","second":1},{"third":null,"iconType":1,"first":"Tfboys","second":1},{"third":null,"iconType":1,"first":"巴巴爸爸我看见哦","second":1},{"third":null,"iconType":1,"first":"米津玄师","second":1},{"third":null,"iconType":1,"first":"Taylor Swift","second":1}]
         */
        private List<HotsEntity> hots;

        public void setHots(List<HotsEntity> hots) {
            this.hots = hots;
        }

        public List<HotsEntity> getHots() {
            return hots;
        }

        public class HotsEntity {
            /**
             * third : null
             * iconType : 1
             * first : 中国新说唱 冷血
             * second : 1
             */
            private String third;
            private int iconType;
            private String first;
            private int second;

            public void setThird(String third) {
                this.third = third;
            }

            public void setIconType(int iconType) {
                this.iconType = iconType;
            }

            public void setFirst(String first) {
                this.first = first;
            }

            public void setSecond(int second) {
                this.second = second;
            }

            public String getThird() {
                return third;
            }

            public int getIconType() {
                return iconType;
            }

            public String getFirst() {
                return first;
            }

            public int getSecond() {
                return second;
            }
        }
    }
}
