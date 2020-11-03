package com.srx.discussion.entity.base;

public class AndroidPosts {
    private int postsId;
    private String postsName;
    private int postCount;
    private String createTime;
    private int postsManId;
    private String postsManName;

    public AndroidPosts(int postsId, String postsName, int postCount, String createTime, int postsManId, String postsManName) {
        this.postsId = postsId;
        this.postsName = postsName;
        this.postCount = postCount;
        this.createTime = createTime;
        this.postsManId = postsManId;
        this.postsManName = postsManName;
    }

    public AndroidPosts(int postsId, String postsName, int postCount, String createTime, int postsManId) {
        this.postsId = postsId;
        this.postsName = postsName;
        this.postCount = postCount;
        this.createTime = createTime;
        this.postsManId = postsManId;
    }

    public AndroidPosts() {
    }

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
    }

    public String getPostsName() {
        return postsName;
    }

    public void setPostsName(String postsName) {
        this.postsName = postsName;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getPostsManId() {
        return postsManId;
    }

    public void setPostsManId(int postsManId) {
        this.postsManId = postsManId;
    }

    public String getPostsManName() {
        return postsManName;
    }

    public void setPostsManName(String postsManName) {
        this.postsManName = postsManName;
    }

    @Override
    public String toString() {
        return "AndroidPosts{" +
                "postsId=" + postsId +
                ", postsName='" + postsName + '\'' +
                ", postCount=" + postCount +
                ", createTime='" + createTime + '\'' +
                ", postsManId=" + postsManId +
                ", postsManName='" + postsManName + '\'' +
                '}';
    }
}
