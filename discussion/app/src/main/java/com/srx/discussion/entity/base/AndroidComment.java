package com.srx.discussion.entity.base;

public class AndroidComment {
    private String commentManName;
    private int commentManId;
    private String commentContent;
    private String commentTime;
    private int commentId;

    public AndroidComment(String commentManName, int commentManId, String commentContent, String commentTime, int commentId) {
        this.commentManName = commentManName;
        this.commentManId = commentManId;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
        this.commentId = commentId;
    }

    public AndroidComment() {
    }

    public AndroidComment(String commentManName, String commentContent, String commentTime) {
        this.commentManName = commentManName;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }

    public String getCommentManName() {
        return commentManName;
    }

    public void setCommentManName(String commentManName) {
        this.commentManName = commentManName;
    }

    public int getCommentManId() {
        return commentManId;
    }

    public void setCommentManId(int commentManId) {
        this.commentManId = commentManId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "AndroidComment{" +
                "commentManName='" + commentManName + '\'' +
                ", commentManId=" + commentManId +
                ", commentContent='" + commentContent + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", commentId=" + commentId +
                '}';
    }
}
