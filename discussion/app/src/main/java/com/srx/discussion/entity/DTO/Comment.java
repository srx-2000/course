package com.srx.discussion.entity.DTO;

import java.util.List;

public class Comment {


    /**
     * queryCommentListByUserId : [{"commentContext":"测试评论1","replyCount":null,"isLive":"1","createTime":"2020-10-20 12:13:14","commentId":1,"commentMan":1,"targetPost":1,"commentManUsername":null},{"commentContext":"测试评论4","replyCount":null,"isLive":"1","createTime":"2020-10-20 12:13:14","commentId":4,"commentMan":1,"targetPost":5,"commentManUsername":null},{"commentContext":"测试评论7","replyCount":null,"isLive":"1","createTime":"2020-10-20 12:13:14","commentId":7,"commentMan":1,"targetPost":1,"commentManUsername":null},{"commentContext":"测试评论8","replyCount":null,"isLive":"1","createTime":"2020-10-20 12:13:14","commentId":8,"commentMan":1,"targetPost":1,"commentManUsername":null},{"commentContext":"postman评论测试content","replyCount":null,"isLive":"1","createTime":"2020-11-03 18:05:38","commentId":9,"commentMan":1,"targetPost":1,"commentManUsername":null},{"commentContext":"postman评论测试content1","replyCount":null,"isLive":"1","createTime":"2020-11-03 18:09:10","commentId":10,"commentMan":1,"targetPost":1,"commentManUsername":null}]
     */
    private List<QueryCommentListByUserIdEntity> queryCommentListByUserId;

    public void setQueryCommentListByUserId(List<QueryCommentListByUserIdEntity> queryCommentListByUserId) {
        this.queryCommentListByUserId = queryCommentListByUserId;
    }

    public List<QueryCommentListByUserIdEntity> getQueryCommentListByUserId() {
        return queryCommentListByUserId;
    }

    public class QueryCommentListByUserIdEntity {
        /**
         * commentContext : 测试评论1
         * replyCount : null
         * isLive : 1
         * createTime : 2020-10-20 12:13:14
         * commentId : 1
         * commentMan : 1
         * targetPost : 1
         * commentManUsername : null
         */
        private String commentContext;
        private String replyCount;
        private String isLive;
        private String createTime;
        private int commentId;
        private int commentMan;
        private int targetPost;
        private String commentManUsername;

        public void setCommentContext(String commentContext) {
            this.commentContext = commentContext;
        }

        public void setReplyCount(String replyCount) {
            this.replyCount = replyCount;
        }

        public void setIsLive(String isLive) {
            this.isLive = isLive;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public void setCommentMan(int commentMan) {
            this.commentMan = commentMan;
        }

        public void setTargetPost(int targetPost) {
            this.targetPost = targetPost;
        }

        public void setCommentManUsername(String commentManUsername) {
            this.commentManUsername = commentManUsername;
        }

        public String getCommentContext() {
            return commentContext;
        }

        public String getReplyCount() {
            return replyCount;
        }

        public String getIsLive() {
            return isLive;
        }

        public String getCreateTime() {
            return createTime;
        }

        public int getCommentId() {
            return commentId;
        }

        public int getCommentMan() {
            return commentMan;
        }

        public int getTargetPost() {
            return targetPost;
        }

        public String getCommentManUsername() {
            return commentManUsername;
        }
    }
}
