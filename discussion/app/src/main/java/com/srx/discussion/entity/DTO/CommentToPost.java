package com.srx.discussion.entity.DTO;

public class CommentToPost {

    /**
     * commentManId : 1
     * commentContext : postman评论测试content1
     * targetManNickname : 帅逼2号
     * commentManNickname : 帅逼1号
     * targetPostTitle : 测试帖子1
     * targetManId : 2
     * commentTime : 2020-11-03 18:09:10
     * targetPostId : 1
     */
    private int commentManId;
    private String commentContext;
    private String targetManNickname;
    private String commentManNickname;
    private String targetPostTitle;
    private int targetManId;
    private String commentTime;
    private int targetPostId;

    public void setCommentManId(int commentManId) {
        this.commentManId = commentManId;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public void setTargetManNickname(String targetManNickname) {
        this.targetManNickname = targetManNickname;
    }

    public void setCommentManNickname(String commentManNickname) {
        this.commentManNickname = commentManNickname;
    }

    public void setTargetPostTitle(String targetPostTitle) {
        this.targetPostTitle = targetPostTitle;
    }

    public void setTargetManId(int targetManId) {
        this.targetManId = targetManId;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public void setTargetPostId(int targetPostId) {
        this.targetPostId = targetPostId;
    }

    public int getCommentManId() {
        return commentManId;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public String getTargetManNickname() {
        return targetManNickname;
    }

    public String getCommentManNickname() {
        return commentManNickname;
    }

    public String getTargetPostTitle() {
        return targetPostTitle;
    }

    public int getTargetManId() {
        return targetManId;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public int getTargetPostId() {
        return targetPostId;
    }
}
