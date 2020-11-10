package com.srx.discussion.entity.base;

import java.io.Serializable;

public class AndroidPost implements Serializable {
    private int CommentCount;
    private int belongPosts;
    private int postMan;
    private int postId;
    private String postContent;
    private String postTitle;
    private String createTime;
    private String postManNickname;
    private String belongPostsName;


    public AndroidPost(int commentCount, int belongPosts, int postMan, String postContent, String postTitle, String createTime, String postManNickname, String belongPostsName) {
        CommentCount = commentCount;
        this.belongPosts = belongPosts;
        this.postMan = postMan;
        this.postContent = postContent;
        this.postTitle = postTitle;
        this.createTime = createTime;
        this.postManNickname = postManNickname;
        this.belongPostsName = belongPostsName;
    }

    public AndroidPost(int commentCount, int belongPosts, int postMan, int postId, String postContent, String postTitle, String createTime, String postManNickname, String belongPostsName) {
        CommentCount = commentCount;
        this.belongPosts = belongPosts;
        this.postMan = postMan;
        this.postId = postId;
        this.postContent = postContent;
        this.postTitle = postTitle;
        this.createTime = createTime;
        this.postManNickname = postManNickname;
        this.belongPostsName = belongPostsName;
    }

    public AndroidPost() {
    }

    public String getPostManNickname() {
        return postManNickname;
    }

    public void setPostManNickname(String postManNickname) {
        this.postManNickname = postManNickname;
    }

    public String getBelongPostsName() {
        return belongPostsName;
    }

    public void setBelongPostsName(String belongPostsName) {
        this.belongPostsName = belongPostsName;
    }


    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int commentCount) {
        CommentCount = commentCount;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public int getPostMan() {
        return postMan;
    }

    public void setPostMan(int postMan) {
        this.postMan = postMan;
    }

    public int getBelongPosts() {
        return belongPosts;
    }

    public void setBelongPosts(int belongPosts) {
        this.belongPosts = belongPosts;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "AndroidPost{" +
                "CommentCount=" + CommentCount +
                ", belongPosts=" + belongPosts +
                ", postMan=" + postMan +
                ", postId=" + postId +
                ", postContent='" + postContent + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", createTime='" + createTime + '\'' +
                ", postManNickname='" + postManNickname + '\'' +
                ", belongPostsName='" + belongPostsName + '\'' +
                '}';
    }
}
