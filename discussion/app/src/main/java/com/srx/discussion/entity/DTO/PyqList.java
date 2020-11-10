package com.srx.discussion.entity.DTO;

import java.util.List;

public class PyqList {


    /**
     * pyqList : [{"createTime":"2020-11-10 09:20:27","nickname":"帅逼1号","pyqContext":"我承认我是一个大帅比了~","userId":1},{"createTime":"2020-11-10 09:20:29","nickname":"帅逼1号","pyqContext":"我不做人了jojo~","userId":1}]
     */
    private List<PyqListEntity> pyqList;

    public void setPyqList(List<PyqListEntity> pyqList) {
        this.pyqList = pyqList;
    }

    public List<PyqListEntity> getPyqList() {
        return pyqList;
    }

    public class PyqListEntity {
        /**
         * createTime : 2020-11-10 09:20:27
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
