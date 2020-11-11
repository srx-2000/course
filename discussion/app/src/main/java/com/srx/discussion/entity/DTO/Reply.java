package com.srx.discussion.entity.DTO;

import java.util.List;

public class Reply {


    /**
     * queryReplyListByUserId : [{"replyContext":"测试回复1","targetManNickname":null,"isLive":"1","replyMan":1,"createTime":"2020-10-20 12:29:41","targetComment":1,"replyId":1,"targetReply":0,"replyManNickname":null},{"replyContext":"测试回复2","targetManNickname":null,"isLive":"1","replyMan":1,"createTime":"2020-10-20 12:29:41","targetComment":1,"replyId":2,"targetReply":1,"replyManNickname":null},{"replyContext":"postman测试回复2","targetManNickname":null,"isLive":"1","replyMan":1,"createTime":"2020-11-03 17:19:00","targetComment":1,"replyId":10,"targetReply":0,"replyManNickname":null},{"replyContext":"postman测试回复3","targetManNickname":null,"isLive":"1","replyMan":1,"createTime":"2020-11-03 17:21:26","targetComment":1,"replyId":11,"targetReply":10,"replyManNickname":null},{"replyContext":"postman测试回复4","targetManNickname":null,"isLive":"1","replyMan":1,"createTime":"2020-11-03 17:28:30","targetComment":1,"replyId":12,"targetReply":10,"replyManNickname":null},{"replyContext":"postman测试回复4","targetManNickname":null,"isLive":"1","replyMan":1,"createTime":"2020-11-03 17:29:46","targetComment":1,"replyId":13,"targetReply":0,"replyManNickname":null}]
     */
    private List<QueryReplyListByUserIdEntity> queryReplyListByUserId;

    public void setQueryReplyListByUserId(List<QueryReplyListByUserIdEntity> queryReplyListByUserId) {
        this.queryReplyListByUserId = queryReplyListByUserId;
    }

    public List<QueryReplyListByUserIdEntity> getQueryReplyListByUserId() {
        return queryReplyListByUserId;
    }

    public class QueryReplyListByUserIdEntity {
        /**
         * replyContext : 测试回复1
         * targetManNickname : null
         * isLive : 1
         * replyMan : 1
         * createTime : 2020-10-20 12:29:41
         * targetComment : 1
         * replyId : 1
         * targetReply : 0
         * replyManNickname : null
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
