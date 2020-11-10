package com.srx.discussion.entity.base;

public class AndroidUserToPosts {
    private int postsId;
    private String postsTitle;
    private int userId;
    private String userNickname;

    public AndroidUserToPosts(int postsId, String postsTitle, int userId, String userNickname) {
        this.postsId = postsId;
        this.postsTitle = postsTitle;
        this.userId = userId;
        this.userNickname = userNickname;
    }

    public AndroidUserToPosts() {
    }

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postId) {
        this.postsId = postId;
    }

    public String getPostsTitle() {
        return postsTitle;
    }

    public void setPostsTitle(String postTitle) {
        this.postsTitle = postTitle;
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
                "postsId=" + postsId +
                ", postsTitle='" + postsTitle + '\'' +
                ", userId=" + userId +
                ", userNickname='" + userNickname + '\'' +
                '}';
    }
}
