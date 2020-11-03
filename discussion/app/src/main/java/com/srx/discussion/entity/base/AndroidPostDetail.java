package com.srx.discussion.entity.base;

import java.util.List;

public class AndroidPostDetail {

    /**
     * commentList : [{"commentContext":"测试评论1","isLive":"1","createTime":"2020-10-20 12:13:14","commentId":1,"commentMan":1,"targetPost":1,"commentManUsername":"user1"},{"commentContext":"测试评论2","isLive":"1","createTime":"2020-10-20 12:13:14","commentId":2,"commentMan":2,"targetPost":1,"commentManUsername":"user2"},{"commentContext":"测试评论3","isLive":"1","createTime":"2020-10-20 12:13:14","commentId":3,"commentMan":3,"targetPost":1,"commentManUsername":"user3"}]
     * postManNickname : 帅逼2号
     * postContext : 测试帖子内容1
     * belongPostsName : 测试吧1
     * belongPostsId : 1
     * postManId : 2
     * postTitle : 测试帖子1
     * postId : 1
     */
    private List<CommentListEntity> commentList;
    private String postManNickname;
    private String postContext;
    private String belongPostsName;
    private int belongPostsId;
    private int postManId;
    private String postTitle;
    private int postId;

    public void setCommentList(List<CommentListEntity> commentList) {
        this.commentList = commentList;
    }

    public void setPostManNickname(String postManNickname) {
        this.postManNickname = postManNickname;
    }

    public void setPostContext(String postContext) {
        this.postContext = postContext;
    }

    public void setBelongPostsName(String belongPostsName) {
        this.belongPostsName = belongPostsName;
    }

    public void setBelongPostsId(int belongPostsId) {
        this.belongPostsId = belongPostsId;
    }

    public void setPostManId(int postManId) {
        this.postManId = postManId;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public List<CommentListEntity> getCommentList() {
        return commentList;
    }

    public String getPostManNickname() {
        return postManNickname;
    }

    public String getPostContext() {
        return postContext;
    }

    public String getBelongPostsName() {
        return belongPostsName;
    }

    public int getBelongPostsId() {
        return belongPostsId;
    }

    public int getPostManId() {
        return postManId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public int getPostId() {
        return postId;
    }

    public class CommentListEntity {
        /**
         * commentContext : 测试评论1
         * isLive : 1
         * createTime : 2020-10-20 12:13:14
         * commentId : 1
         * commentMan : 1
         * targetPost : 1
         * commentManUsername : user1
         */
        private String commentContext;
        private String isLive;
        private String createTime;
        private int commentId;
        private int commentMan;
        private int targetPost;
        private String commentManUsername;

        public void setCommentContext(String commentContext) {
            this.commentContext = commentContext;
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
