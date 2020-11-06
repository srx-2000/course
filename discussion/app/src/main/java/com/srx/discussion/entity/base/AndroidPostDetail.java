package com.srx.discussion.entity.base;

import java.io.Serializable;
import java.util.List;

public class AndroidPostDetail implements Serializable {


    /**
     * commentList : [{"commentContext":"postman评论测试content1","replyCount":0,"isLive":"1","createTime":"2020-11-03 18:09:10","commentId":10,"commentMan":1,"targetPost":1,"commentManUsername":"用户02a29974-5830-4c6f-acc6-96904a9ff512"},{"commentContext":"postman评论测试content","replyCount":0,"isLive":"1","createTime":"2020-11-03 18:05:38","commentId":9,"commentMan":1,"targetPost":1,"commentManUsername":"用户02a29974-5830-4c6f-acc6-96904a9ff512"},{"commentContext":"测试评论1","replyCount":12,"isLive":"1","createTime":"2020-10-20 12:13:14","commentId":1,"commentMan":1,"targetPost":1,"commentManUsername":"用户02a29974-5830-4c6f-acc6-96904a9ff512"},{"commentContext":"测试评论2","replyCount":1,"isLive":"1","createTime":"2020-10-20 12:13:14","commentId":2,"commentMan":2,"targetPost":1,"commentManUsername":"帅逼2号"},{"commentContext":"测试评论3","replyCount":0,"isLive":"1","createTime":"2020-10-20 12:13:14","commentId":3,"commentMan":3,"targetPost":1,"commentManUsername":"帅逼3号"}]
     * postManNickname : 帅逼2号
     * postContext : 测试帖子内容1
     * belongPostsName : 测试吧1
     * belongPostsId : 1
     * postManId : 2
     * postTitle : 测试帖子1
     * postId : 1
     * postCreateTime : 2020-10-20 12:06:04
     */
    private List<CommentListEntity> commentList;
    private String postManNickname;
    private String postContext;
    private String belongPostsName;
    private int belongPostsId;
    private int postManId;
    private String postTitle;
    private int postId;
    private String postCreateTime;

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

    public void setPostCreateTime(String postCreateTime) {
        this.postCreateTime = postCreateTime;
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

    public String getPostCreateTime() {
        return postCreateTime;
    }

    public class CommentListEntity implements Serializable{
        /**
         * commentContext : postman评论测试content1
         * replyCount : 0
         * isLive : 1
         * createTime : 2020-11-03 18:09:10
         * commentId : 10
         * commentMan : 1
         * targetPost : 1
         * commentManUsername : 用户02a29974-5830-4c6f-acc6-96904a9ff512
         */
        private String commentContext;
        private int replyCount;
        private String isLive;
        private String createTime;
        private int commentId;
        private int commentMan;
        private int targetPost;
        private String commentManUsername;

        public void setCommentContext(String commentContext) {
            this.commentContext = commentContext;
        }

        public void setReplyCount(int replyCount) {
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

        public int getReplyCount() {
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
