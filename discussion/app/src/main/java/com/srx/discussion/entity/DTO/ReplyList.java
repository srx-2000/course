package com.srx.discussion.entity.DTO;

import java.util.List;

public class ReplyList {

    /**
     * replyList : [{"replyContext":"测试回复1","isLive":"1","replyManUsername":null,"replyMan":1,"createTime":"2020-10-20 12:29:41","targetComment":1,"replyId":1,"targetReply":0},{"replyContext":"测试回复2","isLive":"1","replyManUsername":null,"replyMan":1,"createTime":"2020-10-20 12:29:41","targetComment":1,"replyId":2,"targetReply":1},{"replyContext":"测试回复3","isLive":"1","replyManUsername":null,"replyMan":2,"createTime":"2020-10-20 12:29:41","targetComment":1,"replyId":3,"targetReply":2},{"replyContext":"测试回复5","isLive":"1","replyManUsername":null,"replyMan":3,"createTime":"2020-10-20 12:29:41","targetComment":1,"replyId":5,"targetReply":0},{"replyContext":"测试回复6","isLive":"1","replyManUsername":null,"replyMan":8,"createTime":"2020-10-20 12:29:41","targetComment":1,"replyId":6,"targetReply":0},{"replyContext":"测试回复7","isLive":"1","replyManUsername":null,"replyMan":8,"createTime":"2020-10-20 12:29:41","targetComment":1,"replyId":7,"targetReply":2}]
     */
    private List<ReplyListEntity> replyList;

    public void setReplyList(List<ReplyListEntity> replyList) {
        this.replyList = replyList;
    }

    public List<ReplyListEntity> getReplyList() {
        return replyList;
    }

    public class ReplyListEntity {
        /**
         * replyContext : 测试回复1
         * isLive : 1
         * replyManUsername : null
         * replyMan : 1
         * createTime : 2020-10-20 12:29:41
         * targetComment : 1
         * replyId : 1
         * targetReply : 0
         */
        private String replyContext;
        private String isLive;
        private String replyManUsername;
        private int replyMan;
        private String createTime;
        private int targetComment;
        private int replyId;
        private int targetReply;

        public void setReplyContext(String replyContext) {
            this.replyContext = replyContext;
        }

        public void setIsLive(String isLive) {
            this.isLive = isLive;
        }

        public void setReplyManUsername(String replyManUsername) {
            this.replyManUsername = replyManUsername;
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

        public String getReplyContext() {
            return replyContext;
        }

        public String getIsLive() {
            return isLive;
        }

        public String getReplyManUsername() {
            return replyManUsername;
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
    }
}
