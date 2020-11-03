package com.srx.discussion.entity.DTO;

import java.util.List;

public class PostsForBlurry {

    /**
     * blurryQueryPostsList : [{"postsId":1,"postsTitle":"测试吧1","isLive":"1","createTime":"2020-10-20 12:06:04","postsMan":1,"roleStatus":null},{"postsId":2,"postsTitle":"测试吧2","isLive":"1","createTime":"2020-10-20 12:06:04","postsMan":1,"roleStatus":null},{"postsId":3,"postsTitle":"测试吧3","isLive":"1","createTime":"2020-10-20 12:06:04","postsMan":5,"roleStatus":null},{"postsId":4,"postsTitle":"测试吧4","isLive":"1","createTime":"2020-10-20 12:06:04","postsMan":3,"roleStatus":null},{"postsId":5,"postsTitle":"测试吧5","isLive":"1","createTime":"2020-10-20 12:06:04","postsMan":5,"roleStatus":null}]
     */
    private List<BlurryQueryPostsListEntity> blurryQueryPostsList;

    public void setBlurryQueryPostsList(List<BlurryQueryPostsListEntity> blurryQueryPostsList) {
        this.blurryQueryPostsList = blurryQueryPostsList;
    }

    public List<BlurryQueryPostsListEntity> getBlurryQueryPostsList() {
        return blurryQueryPostsList;
    }

    public class BlurryQueryPostsListEntity {
        /**
         * postsId : 1
         * postsTitle : 测试吧1
         * isLive : 1
         * createTime : 2020-10-20 12:06:04
         * postsMan : 1
         * roleStatus : null
         */
        private int postsId;
        private String postsTitle;
        private String isLive;
        private String createTime;
        private int postsMan;
        private String roleStatus;

        public void setPostsId(int postsId) {
            this.postsId = postsId;
        }

        public void setPostsTitle(String postsTitle) {
            this.postsTitle = postsTitle;
        }

        public void setIsLive(String isLive) {
            this.isLive = isLive;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setPostsMan(int postsMan) {
            this.postsMan = postsMan;
        }

        public void setRoleStatus(String roleStatus) {
            this.roleStatus = roleStatus;
        }

        public int getPostsId() {
            return postsId;
        }

        public String getPostsTitle() {
            return postsTitle;
        }

        public String getIsLive() {
            return isLive;
        }

        public String getCreateTime() {
            return createTime;
        }

        public int getPostsMan() {
            return postsMan;
        }

        public String getRoleStatus() {
            return roleStatus;
        }
    }
}
