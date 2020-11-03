package com.srx.discussion.entity.DTO;

public class ReplyToComment {


    /**
     * replyContext : postman测试回复4
     * targetManNickname : 帅逼1号
     * replyMan : 1
     * createTime : 2020-11-03 17:29:46
     * targetComment : 1
     * replyId : 13
     * targetMan : 1
     * replyManNickname : 帅逼1号
     */
    private String replyContext;
    private String targetManNickname;
    private int replyMan;
    private String createTime;
    private int targetComment;
    private int replyId;
    private int targetMan;
    private String replyManNickname;

    public void setReplyContext(String replyContext) {
        this.replyContext = replyContext;
    }

    public void setTargetManNickname(String targetManNickname) {
        this.targetManNickname = targetManNickname;
    }

    public void setReplyMan(int replyMan) {
        this.replyMan = replyMan;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setTargetComment(int targetComment) {
        this.targetComment = targetComment;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public void setTargetMan(int targetMan) {
        this.targetMan = targetMan;
    }

    public void setReplyManNickname(String replyManNickname) {
        this.replyManNickname = replyManNickname;
    }

    public String getReplyContext() {
        return replyContext;
    }

    public String getTargetManNickname() {
        return targetManNickname;
    }

    public int getReplyMan() {
        return replyMan;
    }

    public String getCreateTime() {
        return createTime;
    }

    public int getTargetComment() {
        return targetComment;
    }

    public int getReplyId() {
        return replyId;
    }

    public int getTargetMan() {
        return targetMan;
    }

    public String getReplyManNickname() {
        return replyManNickname;
    }
}
