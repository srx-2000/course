package com.srx.discussion.entity.DTO;

import java.util.List;

public class StartPost {


    /**
     * queryUserStarPostForAndroid : [{"postContext":"测试帖子内容1","belongPostsName":"测试吧1","postCreatTime":"2020-10-20 12:06:04","belongPostsId":"1","postmanNickname":"帅逼2号","userNickname":"帅逼1号","postmanId":"2","userId":1},{"postContext":"测试帖子内容5","belongPostsName":"测试吧3","postCreatTime":"2020-10-20 12:06:04","belongPostsId":"3","postmanNickname":"帅逼1号","userNickname":"帅逼1号","postmanId":"1","userId":1}]
     */
    private List<QueryUserStarPostForAndroidEntity> queryUserStarPostForAndroid;

    public void setQueryUserStarPostForAndroid(List<QueryUserStarPostForAndroidEntity> queryUserStarPostForAndroid) {
        this.queryUserStarPostForAndroid = queryUserStarPostForAndroid;
    }

    public List<QueryUserStarPostForAndroidEntity> getQueryUserStarPostForAndroid() {
        return queryUserStarPostForAndroid;
    }

    public class QueryUserStarPostForAndroidEntity {
        /**
         * postContext : 测试帖子内容1
         * belongPostsName : 测试吧1
         * postCreatTime : 2020-10-20 12:06:04
         * belongPostsId : 1
         * postmanNickname : 帅逼2号
         * userNickname : 帅逼1号
         * postmanId : 2
         * userId : 1
         */
        private String postContext;
        private String belongPostsName;
        private String postCreatTime;
        private Integer belongPostsId;
        private String postmanNickname;
        private String userNickname;
        private Integer postmanId;
        private Integer userId;

        public void setPostContext(String postContext) {
            this.postContext = postContext;
        }

        public void setBelongPostsName(String belongPostsName) {
            this.belongPostsName = belongPostsName;
        }

        public void setPostCreatTime(String postCreatTime) {
            this.postCreatTime = postCreatTime;
        }

        public void setBelongPostsId(Integer belongPostsId) {
            this.belongPostsId = belongPostsId;
        }

        public void setPostmanNickname(String postmanNickname) {
            this.postmanNickname = postmanNickname;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public void setPostmanId(Integer postmanId) {
            this.postmanId = postmanId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPostContext() {
            return postContext;
        }

        public String getBelongPostsName() {
            return belongPostsName;
        }

        public String getPostCreatTime() {
            return postCreatTime;
        }

        public Integer getBelongPostsId() {
            return belongPostsId;
        }

        public String getPostmanNickname() {
            return postmanNickname;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public Integer getPostmanId() {
            return postmanId;
        }

        public int getUserId() {
            return userId;
        }
    }
}
