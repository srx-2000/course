package com.srx.discussion.entity.DTO;

import java.util.List;

public class Post {

    /**
     * queryPostListByUserId : [{"postsId":3,"postContext":"测试帖子内容5","isLive":"1","postMan":1,"createTime":"2020-10-20 12:06:04","postTitle":"测试帖子5","postId":5},{"postsId":1,"postContext":"postman帖子测试content","isLive":"1","postMan":1,"createTime":"2020-11-03 18:01:37","postTitle":"postman帖子测试title","postId":6}]
     */
    private List<QueryPostListByUserIdEntity> queryPostListByUserId;

    public void setQueryPostListByUserId(List<QueryPostListByUserIdEntity> queryPostListByUserId) {
        this.queryPostListByUserId = queryPostListByUserId;
    }

    public List<QueryPostListByUserIdEntity> getQueryPostListByUserId() {
        return queryPostListByUserId;
    }

    public class QueryPostListByUserIdEntity {
        /**
         * postsId : 3
         * postContext : 测试帖子内容5
         * isLive : 1
         * postMan : 1
         * createTime : 2020-10-20 12:06:04
         * postTitle : 测试帖子5
         * postId : 5
         */
        private int postsId;
        private String postContext;
        private String isLive;
        private int postMan;
        private String createTime;
        private String postTitle;
        private int postId;

        public void setPostsId(int postsId) {
            this.postsId = postsId;
        }

        public void setPostContext(String postContext) {
            this.postContext = postContext;
        }

        public void setIsLive(String isLive) {
            this.isLive = isLive;
        }

        public void setPostMan(int postMan) {
            this.postMan = postMan;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setPostTitle(String postTitle) {
            this.postTitle = postTitle;
        }

        public void setPostId(int postId) {
            this.postId = postId;
        }

        public int getPostsId() {
            return postsId;
        }

        public String getPostContext() {
            return postContext;
        }

        public String getIsLive() {
            return isLive;
        }

        public int getPostMan() {
            return postMan;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getPostTitle() {
            return postTitle;
        }

        public int getPostId() {
            return postId;
        }
    }
}
