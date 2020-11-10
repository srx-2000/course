package com.srx.discussion.entity.DTO;

import java.io.Serializable;
import java.util.List;

public class ReplyList implements Serializable{


    /**
     * replyList : [{"replyContext":"测试回复1","targetManNickname":null,"isLive":"1","replyMan":1,"createTime":"2020-10-29 11:56:06","targetComment":1,"replyId":1,"targetReply":0,"replyManNickname":"帅逼1号"},{"replyContext":"测试回复2","targetManNickname":"帅逼1号","isLive":"1","replyMan":1,"createTime":"2020-10-29 11:56:06","targetComment":1,"replyId":2,"targetReply":1,"replyManNickname":"帅逼1号"},{"replyContext":"测试回复3","targetManNickname":"帅逼1号","isLive":"1","replyMan":2,"createTime":"2020-10-29 11:56:06","targetComment":1,"replyId":3,"targetReply":2,"replyManNickname":"帅逼2号"},{"replyContext":"测试回复5","targetManNickname":null,"isLive":"1","replyMan":3,"createTime":"2020-10-29 11:56:06","targetComment":1,"replyId":5,"targetReply":0,"replyManNickname":"帅逼3号"},{"replyContext":"测试回复6","targetManNickname":null,"isLive":"1","replyMan":8,"createTime":"2020-10-29 11:56:06","targetComment":1,"replyId":6,"targetReply":0,"replyManNickname":"帅逼8号"},{"replyContext":"测试回复7","targetManNickname":"帅逼1号","isLive":"1","replyMan":8,"createTime":"2020-10-29 11:56:06","targetComment":1,"replyId":7,"targetReply":2,"replyManNickname":"帅逼8号"}]
     */
    private List<ReplyListEntity> replyList;

    public void setReplyList(List<ReplyListEntity> replyList) {
        this.replyList = replyList;
    }

    public List<ReplyListEntity> getReplyList() {
        return replyList;
    }

    public class ReplyListEntity implements Serializable {
        /**
         * replyContext : 测试回复1
         * targetManNickname : null
         * isLive : 1
         * replyMan : 1
         * createTime : 2020-10-29 11:56:06
         * targetComment : 1
         * replyId : 1
         * targetReply : 0
         * replyManNickname : 帅逼1号
         */
        private String replyContext;
        private String targetManNickname;
        private String isLive;
        private int replyMan;
        private String createTime;
        private int targetComment;
        private int replyId;
        private int targetReply;
        private String replyManNickname;

        public void setReplyContext(String replyContext) {
            this.replyContext = replyContext;
        }

        public void setTargetManNickname(String targetManNickname) {
            this.targetManNickname = targetManNickname;
        }

        public void setIsLive(String isLive) {
            this.isLive = isLive;
        }

        public void setReplyMan(int replyMan) {
            this.replyMan = replyMan;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setTargetComment(int targetComment) {
            this.targetComment = targetComment;
        }

        public void setReplyId(int replyId) {
            this.replyId = replyId;
        }

        public void setTargetReply(int targetReply) {
            this.targetReply = targetReply;
        }

        public void setReplyManNickname(String replyManNickname) {
            this.replyManNickname = replyManNickname;
        }

        public String getReplyContext() {
            return replyContext;
        }

        public String getTargetManNickname() {
            return targetManNickname;
        }

        public String getIsLive() {
            return isLive;
        }

        public int getReplyMan() {
            return replyMan;
        }

        public String getCreateTime() {
            return createTime;
        }

        public int getTargetComment() {
            return targetComment;
        }

        public int getReplyId() {
            return replyId;
        }

        public int getTargetReply() {
            return targetReply;
        }

        public String getReplyManNickname() {
            return replyManNickname;
        }
    }
}
