package com.srx.test2.entities;

import java.io.Serializable;
import java.util.List;

public class ResultObject implements Serializable {

    /**
     * trans_result : [{"dst":"Height 600 m","src":"高度600米"}]
     * from : zh
     * to : en
     */
    private List<Trans_resultEntity> trans_result;
    private String from;
    private String to;

    public void setTrans_result(List<Trans_resultEntity> trans_result) {
        this.trans_result = trans_result;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<Trans_resultEntity> getTrans_result() {
        return trans_result;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public class Trans_resultEntity {
        /**
         * dst : Height 600 m
         * src : 高度600米
         */
        private String dst;
        private String src;

        public void setDst(String dst) {
            this.dst = dst;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getDst() {
            return dst;
        }

        public String getSrc() {
            return src;
        }
    }
}
