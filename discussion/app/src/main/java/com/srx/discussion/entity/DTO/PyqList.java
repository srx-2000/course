package com.srx.discussion.entity.DTO;

import java.util.List;

public class PyqList {

    /**
     * queryPyqListById : [{"createTime":"2020-10-26 21:32:17","nickname":"帅逼1号","pyqContext":"我承认我是一个大帅比了~","userId":1},{"createTime":"2020-11-02 13:27:28","nickname":"帅逼1号","pyqContext":"我不做人了jojo~","userId":1}]
     */
    private List<QueryPyqListByIdEntity> queryPyqListById;

    public void setQueryPyqListById(List<QueryPyqListByIdEntity> queryPyqListById) {
        this.queryPyqListById = queryPyqListById;
    }

    public List<QueryPyqListByIdEntity> getQueryPyqListById() {
        return queryPyqListById;
    }

    public class QueryPyqListByIdEntity {
        /**
         * createTime : 2020-10-26 21:32:17
         * nickname : 帅逼1号
         * pyqContext : 我承认我是一个大帅比了~
         * userId : 1
         */
        private String createTime;
        private String nickname;
        private String pyqContext;
        private int userId;

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setPyqContext(String pyqContext) {
            this.pyqContext = pyqContext;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getNickname() {
            return nickname;
        }

        public String getPyqContext() {
            return pyqContext;
        }

        public int getUserId() {
            return userId;
        }
    }
}
