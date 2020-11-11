package com.srx.discussion.entity.DTO;

import java.io.Serializable;
import java.util.List;

public class PostsPost implements Serializable {


    /**
     * postsTitle : 测试吧1
     * paginationQueryPostList : [{"postsId":1,"postManNickname":"帅逼2号","postContext":"第一次发帖成功！！！！","isLive":"1","postMan":2,"belongPostsName":"测试吧1","createTime":"2020-11-05 21:08:51","postTitle":"恭喜显示成功！","postId":10,"commentCount":0},{"postsId":1,"postManNickname":"帅逼2号","postContext":"第一次发帖成功！！！！","isLive":"1","postMan":2,"belongPostsName":"测试吧1","createTime":"2020-11-05 21:08:26","postTitle":"恭喜显示成功！","postId":9,"commentCount":0},{"postsId":1,"postManNickname":"帅逼2号","postContext":"第一次发帖成功！！！！","isLive":"1","postMan":2,"belongPostsName":"测试吧1","createTime":"2020-11-05 21:05:28","postTitle":"恭喜显示成功！","postId":8,"commentCount":0},{"postsId":1,"postManNickname":"帅逼2号","postContext":"第一次发帖成功！！！！","isLive":"1","postMan":2,"belongPostsName":"测试吧1","createTime":"2020-11-05 21:04:57","postTitle":"恭喜显示成功！","postId":7,"commentCount":0},{"postsId":1,"postManNickname":"帅逼2号","postContext":"第一次发帖成功！！！！","isLive":"1","postMan":2,"belongPostsName":"测试吧1","createTime":"2020-11-05 11:21:22","postTitle":"恭喜显示成功！","postId":6,"commentCount":0}]
     */
    private String postsTitle;
    private List<PaginationQueryPostListEntity> paginationQueryPostList;

    public void setPostsTitle(String postsTitle) {
        this.postsTitle = postsTitle;
    }

    public void setPaginationQueryPostList(List<PaginationQueryPostListEntity> paginationQueryPostList) {
        this.paginationQueryPostList = paginationQueryPostList;
    }

    public String getPostsTitle() {
        return postsTitle;
    }

    public List<PaginationQueryPostListEntity> getPaginationQueryPostList() {
        return paginationQueryPostList;
    }

    public class PaginationQueryPostListEntity implements Serializable{
        /**
         * postsId : 1
         * postManNickname : 帅逼2号
         * postContext : 第一次发帖成功！！！！
         * isLive : 1
         * postMan : 2
         * belongPostsName : 测试吧1
         * createTime : 2020-11-05 21:08:51
         * postTitle : 恭喜显示成功！
         * postId : 10
         * commentCount : 0
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
