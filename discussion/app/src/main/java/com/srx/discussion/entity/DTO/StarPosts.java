package com.srx.discussion.entity.DTO;

import java.util.List;

public class StarPosts {

    /**
     * queryUserStarPostsForAndroid : [{"postsId":"1","postsName":"测试吧1","userNickname":"帅逼1号","userId":1},{"postsId":"5","postsName":"测试吧5","userNickname":"帅逼1号","userId":1}]
     */
    private List<QueryUserStarPostsForAndroidEntity> queryUserStarPostsForAndroid;

    public void setQueryUserStarPostsForAndroid(List<QueryUserStarPostsForAndroidEntity> queryUserStarPostsForAndroid) {
        this.queryUserStarPostsForAndroid = queryUserStarPostsForAndroid;
    }

    public List<QueryUserStarPostsForAndroidEntity> getQueryUserStarPostsForAndroid() {
        return queryUserStarPostsForAndroid;
    }

    public class QueryUserStarPostsForAndroidEntity {
        /**
         * postsId : 1
         * postsName : 测试吧1
         * userNickname : 帅逼1号
         * userId : 1
         */
        private Integer postsId;
        private String postsName;
        private String userNickname;
        private Integer userId;

        public void setPostsId(Integer postsId) {
            this.postsId = postsId;
        }

        public void setPostsName(String postsName) {
            this.postsName = postsName;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Integer getPostsId() {
            return postsId;
        }

        public String getPostsName() {
            return postsName;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public int getUserId() {
            return userId;
        }
    }
}
