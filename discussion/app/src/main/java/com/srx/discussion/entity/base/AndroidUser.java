package com.srx.discussion.entity.base;

public class AndroidUser {
    private String username;
    private String password;
    private Integer userId;
    private String address;
    private String selfSignature;
    private Integer age;
    private String nickname;
    private String sex;


    public AndroidUser(Integer userId, String address, String selfSignature, Integer age, String nickname, String sex) {
        this.userId = userId;
        this.address = address;
        this.selfSignature = selfSignature;
        this.age = age;
        this.nickname = nickname;
        this.sex = sex;
    }

    public AndroidUser(String username, String password, Integer userId, String address, String selfSignature, Integer age, String nickname, String sex) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.address = address;
        this.selfSignature = selfSignature;
        this.age = age;
        this.nickname = nickname;
        this.sex = sex;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSelfSignature() {
        return selfSignature;
    }

    public void setSelfSignature(String selfSignature) {
        this.selfSignature = selfSignature;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "AndroidUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", selfSignature='" + selfSignature + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
