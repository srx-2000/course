package com.srx.discussion.entity.base;

public class AndroidReply {
    private int targetCommentId;
    private int targetReplyId;
    private int replyManId;
    private String replyTime;
    private String replyManName;
    private String replyContent;

    public AndroidReply(int targetCommentId, int targetReplyId, int replyManId, String replyTime, String replyManName, String replyContent) {
        this.targetCommentId = targetCommentId;
        this.targetReplyId = targetReplyId;
        this.replyManId = replyManId;
        this.replyTime = replyTime;
        this.replyManName = replyManName;
        this.replyContent = replyContent;
    }

    public AndroidReply(int targetCommentId, int replyManId, String replyTime, String replyManName, String replyContent) {
        this.targetCommentId = targetCommentId;
        this.replyManId = replyManId;
        this.replyTime = replyTime;
        this.replyManName = replyManName;
        this.replyContent = replyContent;
    }

    public AndroidReply() {
    }

    public int getTargetCommentId() {
        return targetCommentId;
    }

    public void setTargetCommentId(int targetCommentId) {
        this.targetCommentId = targetCommentId;
    }

    public int getTargetReplyId() {
        return targetReplyId;
    }

    public void setTargetReplyId(int targetReplyId) {
        this.targetReplyId = targetReplyId;
    }

    public int getReplyManId() {
        return replyManId;
    }

    public void setReplyManId(int replyManId) {
        this.replyManId = replyManId;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyManName() {
        return replyManName;
    }

    public void setReplyManName(String replyManName) {
        this.replyManName = replyManName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Override
    public String toString() {
        return "AndroidReply{" +
                "targetCommentId=" + targetCommentId +
                ", targetReplyId=" + targetReplyId +
                ", replyManId=" + replyManId +
                ", replyTime='" + replyTime + '\'' +
                ", replyManName='" + replyManName + '\'' +
                ", replyContent='" + replyContent + '\'' +
                '}';
    }
}
