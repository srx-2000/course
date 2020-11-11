package com.srx.discussion.entity.base;

public class Message {
    private String createTime;
    private String userNickname;
    private String content;

    public Message(String createTime, String userNickname, String content) {
        this.createTime = createTime;
        this.userNickname = userNickname;
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "createTime='" + createTime + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
