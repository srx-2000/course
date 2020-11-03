package com.srx.discussion.entity.base;

public class AndroidUserToPost {
    private Integer belongPostsId;
    private Integer userId;
    private Integer postManId;
    private String postManNickname;
    private String postsNme;
    private String userNickname;
    private String postContext;
    private String postCreateTime;

    public AndroidUserToPost(Integer belongPostsId, Integer userId, Integer postManId, String postManNickname, String postsNme, String userNickname, String postContext, String postCreateTime) {
        this.belongPostsId = belongPostsId;
        this.userId = userId;
        this.postManId = postManId;
        this.postManNickname = postManNickname;
        this.postsNme = postsNme;
        this.userNickname = userNickname;
        this.postContext = postContext;
        this.postCreateTime = postCreateTime;
    }

    public Integer getBelongPostsId() {
        return belongPostsId;
    }

    public void setBelongPostsId(Integer belongPostsId) {
        this.belongPostsId = belongPostsId;
    }

    public Integer getPostManId() {
        return postManId;
    }

    public void setPostManId(Integer postManId) {
        this.postManId = postManId;
    }

    public String getPostManNickname() {
        return postManNickname;
    }

    public void setPostManNickname(String postManNickname) {
        this.postManNickname = postManNickname;
    }

    public String getPostContext() {
        return postContext;
    }

    public void setPostContext(String postContext) {
        this.postContext = postContext;
    }

    public String getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(String postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public AndroidUserToPost() {
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }


    public String getPostsNme() {
        return postsNme;
    }

    public void setPostsNme(String postsNme) {
        this.postsNme = postsNme;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AndroidUserToPosts{" +
                "belongPostsId=" + belongPostsId +
                ", userId=" + userId +
                ", postManId=" + postManId +
                ", postManNickname='" + postManNickname + '\'' +
                ", postsNme='" + postsNme + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", postContext='" + postContext + '\'' +
                ", postCreateTime='" + postCreateTime + '\'' +
                '}';
    }
}
