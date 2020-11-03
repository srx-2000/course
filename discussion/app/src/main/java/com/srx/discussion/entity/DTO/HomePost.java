package com.srx.discussion.entity.DTO;

import java.util.List;

public class HomePost {

    /**
     * paginationQueryAllPostList : [{"postsId":1,"postManNickname":"帅逼3号","postContext":"测试帖子内容3","isLive":"1","postMan":3,"belongPostsName":"测试吧1","createTime":"2020-10-20 12:06:04","postTitle":"测试帖子3","postId":3,"commentCount":1},{"postsId":2,"postManNickname":null,"postContext":"测试帖子内容4","isLive":"1","postMan":5,"belongPostsName":"测试吧2","createTime":"2020-10-20 12:06:04","postTitle":"测试帖子4","postId":4,"commentCount":0}]
     */
    private List<PaginationQueryAllPostListEntity> paginationQueryAllPostList;

    public void setPaginationQueryAllPostList(List<PaginationQueryAllPostListEntity> paginationQueryAllPostList) {
        this.paginationQueryAllPostList = paginationQueryAllPostList;
    }

    public List<PaginationQueryAllPostListEntity> getPaginationQueryAllPostList() {
        return paginationQueryAllPostList;
    }

    public class PaginationQueryAllPostListEntity {
        /**
         * postsId : 1
         * postManNickname : 帅逼3号
         * postContext : 测试帖子内容3
         * isLive : 1
         * postMan : 3
         * belongPostsName : 测试吧1
         * createTime : 2020-10-20 12:06:04
         * postTitle : 测试帖子3
         * postId : 3
         * commentCount : 1
         */
        private int postsId;
        private String postManNickname;
        private String postContext;
        private String isLive;
        private int postMan;
        private String belongPostsName;
        private String createTime;
        private String postTitle;
        private int postId;
        private int commentCount;

        public void setPostsId(int postsId) {
            this.postsId = postsId;
        }

        public void setPostManNickname(String postManNickname) {
            this.postManNickname = postManNickname;
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

        public void setBelongPostsName(String belongPostsName) {
            this.belongPostsName = belongPostsName;
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

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getPostsId() {
            return postsId;
        }

        public String getPostManNickname() {
            return postManNickname;
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

        public String getBelongPostsName() {
            return belongPostsName;
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

        public int getCommentCount() {
            return commentCount;
        }
    }
}
