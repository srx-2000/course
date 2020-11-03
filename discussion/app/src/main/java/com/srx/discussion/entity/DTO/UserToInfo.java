package com.srx.discussion.entity.DTO;


import java.io.Serializable;

public class UserToInfo implements Serializable {

    /**
     * queryUserInfoById : {"address":"北京","sex":"秘密","nickname":"beir","avatar":null,"selfSignature":"这个人很懒还没有个性签名.....","userId":9,"age":0}
     */
    private QueryUserInfoByIdEntity queryUserInfoById;

    public void setQueryUserInfoById(QueryUserInfoByIdEntity queryUserInfoById) {
        this.queryUserInfoById = queryUserInfoById;
    }

    public QueryUserInfoByIdEntity getQueryUserInfoById() {
        return queryUserInfoById;
    }

    public class QueryUserInfoByIdEntity {
        /**
         * address : 北京
         * sex : 秘密
         * nickname : beir
         * avatar : null
         * selfSignature : 这个人很懒还没有个性签名.....
         * userId : 9
         * age : 0
         */
        private String address;
        private String sex;
        private String nickname;
        private String avatar;
        private String selfSignature;
        private int userId;
        private int age;

        public void setAddress(String address) {
            this.address = address;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setSelfSignature(String selfSignature) {
            this.selfSignature = selfSignature;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public String getSex() {
            return sex;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getSelfSignature() {
            return selfSignature;
        }

        public int getUserId() {
            return userId;
        }

        public int getAge() {
            return age;
        }
    }
}
