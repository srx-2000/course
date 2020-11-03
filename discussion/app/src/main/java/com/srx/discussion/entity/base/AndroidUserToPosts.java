package com.srx.discussion.entity.base;

public class AndroidUserToPosts {
    private int postId;
    private String postTitle;
    private int userId;
    private String userNickname;

    public AndroidUserToPosts(int postId, String postTitle, int userId, String userNickname) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.userId = userId;
        this.userNickname = userNickname;
    }

    public AndroidUserToPosts() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Override
    public String toString() {
        return "AndroidUserToPost{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", userId=" + userId +
                ", userNickname='" + userNickname + '\'' +
                '}';
    }
}
