package com.srx.discussion.entity.base;


import java.io.Serializable;

public class AndroidPyq implements Serializable {
    private Integer userId;
    private String pyqContext;
    private String createTime;
    private String nickname;

    /**
     * 该构造方法用于删除朋友圈
     * @param userId
     * @param createTime
     */
    public AndroidPyq(Integer userId, String createTime) {
        this.userId = userId;
        this.createTime = createTime;
    }

    public AndroidPyq(Integer userId, String pyqContext, String createTime, String nickname) {
        this.userId = userId;
        this.pyqContext = pyqContext;
        this.createTime = createTime;
        this.nickname = nickname;
    }

    public AndroidPyq() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPyqContext() {
        return pyqContext;
    }

    public void setPyqContext(String pyqContext) {
        this.pyqContext = pyqContext;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Pyq{" +
                "userId=" + userId +
                ", pyqContext='" + pyqContext + '\'' +
                ", createTime='" + createTime + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
