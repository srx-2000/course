package com.srx.discussion.entity.DTO;

import java.util.List;

public class Role {


    /**
     * queryRoleList : [{"address":"无","sex":"男","nickname":"用户02a29974-5830-4c6f-acc6-96904a9ff512","avatar":null,"selfSignature":"这个人很懒还没有个性签名.....","userId":1,"age":0},{"address":"东北","sex":"秘密","nickname":"帅逼2号","avatar":null,"selfSignature":"我不做人啦，jojo","userId":2,"age":20},null]
     */
    private List<QueryRoleListEntity> queryRoleList;

    public void setQueryRoleList(List<QueryRoleListEntity> queryRoleList) {
        this.queryRoleList = queryRoleList;
    }

    public List<QueryRoleListEntity> getQueryRoleList() {
        return queryRoleList;
    }

    public class QueryRoleListEntity {
        /**
         * address : 无
         * sex : 男
         * nickname : 用户02a29974-5830-4c6f-acc6-96904a9ff512
         * avatar : null
         * selfSignature : 这个人很懒还没有个性签名.....
         * userId : 1
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
