package com.srx.discussion.util;

import android.util.Log;
import com.google.gson.Gson;
import com.srx.discussion.entity.DTO.*;
import com.srx.discussion.entity.base.*;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpUtil {

    private static String url = "http://106.12.193.175:8080/discussion";
    private static OkHttpClient client;
    private static String JSESSIONID = "";

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        HttpUtil.url = url;
    }

    public static OkHttpClient getClient() {
        return client;
    }

    public static void setClient(OkHttpClient client) {
        HttpUtil.client = client;
    }

    public static ErrorMessage parseErrorMessage(String errorMessage) {
        String firstString = errorMessage.replace("{\"", "");
        String secondString = firstString.replace("\"}", "");
        String[] split = secondString.split("\":\"");
        return new ErrorMessage(split[1], split[0]);
    }

    public static String parseSingleMessage(String errorMessage) {
        String firstString = errorMessage.replace("{", "");
        String secondString = firstString.replace("}", "");
        String[] split = secondString.split(":");
        return split[1];
    }

    /**
     * 该方法应该在用户注销登录时调用。
     */
    public static void clearSession() {
        JSESSIONID = "";
    }

    //
    private static Response doGetMethod(final String methodName, Object... params) {
        client = new OkHttpClient();
        Request request = null;
        Response response = null;
        if (methodName.equals(MethodNameProvider.showUserInfo)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?userId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.showUserNickName)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?userId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.showHomePostList)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?currentPage=" + params[0] + "&pageSize=" + params[1])
                    .build();
        } else if (methodName.equals(MethodNameProvider.showAllReplyList)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?targetComment=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.showPyqList)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?userId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.showUserStarPost)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?userId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.showUserStarPosts)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?userId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.showPostDetail)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postId=" + params[0] + "&pageSize=" + params[2] + "&currentPage=" + params[1])
                    .build();
        } else if (methodName.equals(MethodNameProvider.starPost)) {
            request = new Request.Builder()
                    .get()
                    .header("Cookie", "JSESSIONID=" + JSESSIONID)
                    .url(url + methodName + "?postId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.starPosts)) {
            request = new Request.Builder()
                    .get()
                    .header("Cookie", "JSESSIONID=" + JSESSIONID)
                    .url(url + methodName + "?postsId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.unStarPost)) {
            request = new Request.Builder()
                    .get()
                    .header("Cookie", "JSESSIONID=" + JSESSIONID)
                    .url(url + methodName + "?postId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.unStarPosts)) {
            request = new Request.Builder()
                    .get()
                    .header("Cookie", "JSESSIONID=" + JSESSIONID)
                    .url(url + methodName + "?postsId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.updateUserInfo)) {
            String urlParam = "";
            urlParam += "userId=" + params[0].toString();
            if (params[1] != null) {
                urlParam += "&nickname=" + params[1].toString();
            }
            if (params[2] != null) {
                urlParam += "&age=" + params[2].toString();
            }
            if (params[3] != null) {
                urlParam += "&sex=" + params[3].toString();
            }
            if (params[4] != null) {
                urlParam += "&address=" + params[4].toString();
            }
            if (params[5] != null) {
                urlParam += "&selfSignature=" + params[5].toString();
            }
            request = new Request.Builder()
                    .get()
                    .header("Cookie", "JSESSIONID=" + JSESSIONID)
                    .url(url + methodName + "?" + urlParam)
                    .build();
        } else if (methodName.equals(MethodNameProvider.insertPyq)) {
            request = new Request.Builder()
                    .get()
                    .header("Cookie", "JSESSIONID=" + JSESSIONID)
                    .url(url + methodName + "?pyqContext=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.deletePyq)) {
            request = new Request.Builder()
                    .get()
                    .header("Cookie", "JSESSIONID=" + JSESSIONID)
                    .url(url + methodName + "?userId=" + params[0] + "&createTime=" + params[1])
                    .build();
        } else if (methodName.equals(MethodNameProvider.getReplyCount)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?commentId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.deleteSingleReply)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsId=" + params[0] + "&replyId=" + params[1])
                    .build();
        } else if (methodName.equals(MethodNameProvider.deleteSingleComment)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsId=" + params[0] + "&commentId=" + params[1])
                    .build();
        } else if (methodName.equals(MethodNameProvider.deleteSinglePost)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsId=" + params[0] + "&postId=" + params[1])
                    .build();
        } else if (methodName.equals(MethodNameProvider.deleteSinglePosts)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.blurryQueryPostsList)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?blurryString=" + params[0] + "&currentPage=" + params[1] + "&pageSize=" + params[2])
                    .build();
        } else if (methodName.equals(MethodNameProvider.getPostCount)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.getPostsCount)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName)
                    .build();
        } else if (methodName.equals(MethodNameProvider.insertPosts)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsMan=" + params[0] + "&postsTitle=" + params[1])
                    .build();
        } else if (methodName.equals(MethodNameProvider.getRoleList)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsId=" + params[0])
                    .build();
        } else if (methodName.equals(MethodNameProvider.upUserRole)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsId=" + params[0] + "&upUserId=" + params[1])
                    .build();
        } else if (methodName.equals(MethodNameProvider.downUserRole)) {
            request = new Request.Builder()
                    .get()
                    .url(url + methodName + "?postsId=" + params[0] + "&downUserId=" + params[1])
                    .build();
        }
        Call call = client.newCall(request);
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    private static Response doPostMethod(String methodName, Object... params) {
        client = new OkHttpClient();
        Response response = null;
        Request request = null;
        RequestBody requestBody;
        if (methodName.equals(MethodNameProvider.login_post)) {
            requestBody = new FormBody.Builder()
                    .add("username", params[0].toString())
                    .add("password", params[1].toString())
                    .build();
            request = new Request.Builder()
                    .post(requestBody)
                    .url(url + methodName)
                    .build();
        } else if (methodName.equals(MethodNameProvider.register_post)) {
            requestBody = new FormBody.Builder()
                    .add("username", params[0].toString())
                    .add("password", params[1].toString())
                    .add("email", params[2].toString())
                    .add("authority", params[3].toString())
                    .build();
            request = new Request.Builder()
                    .post(requestBody)
                    .url(url + methodName)
                    .build();
        } else if (methodName.equals(MethodNameProvider.verification_post)) {
            requestBody = new FormBody.Builder()
                    .add("uniqueId", params[0].toString())
                    .build();
            request = new Request.Builder()
                    .post(requestBody)
                    .url(url + methodName)
                    .build();
        } else if (methodName.equals(MethodNameProvider.updatePassword_post)) {
            requestBody = new FormBody.Builder()
                    .add("username", params[0].toString())
                    .add("oldPassword", params[1].toString())
                    .add("newPassword", params[2].toString())
                    .build();
            request = new Request.Builder()
                    .post(requestBody)
                    .url(url + methodName)
                    .build();
        } else if (methodName.equals(MethodNameProvider.insertReplyForComment_post)) {
            requestBody = new FormBody.Builder()
                    .add("replyContext", params[0].toString())
                    .add("targetComment", params[1].toString())
                    .build();
            request = new Request.Builder()
                    .post(requestBody)
                    .url(url + methodName)
                    .build();
        } else if (methodName.equals(MethodNameProvider.insertReplyForReply_post)) {
            requestBody = new FormBody.Builder()
                    .add("replyContext", params[0].toString())
                    .add("targetComment", params[1].toString())
                    .add("targetReply", params[2].toString())
                    .build();
            request = new Request.Builder()
                    .post(requestBody)
                    .url(url + methodName)
                    .build();
        } else if (methodName.equals(MethodNameProvider.insertPost_post)) {
            requestBody = new FormBody.Builder()
                    .add("postMan", params[0].toString())
                    .add("postTitle", params[1].toString())
                    .add("postContext", params[2].toString())
                    .add("postsId", params[3].toString())
                    .build();
            request = new Request.Builder()
                    .post(requestBody)
                    .url(url + methodName)
                    .build();
        } else if (methodName.equals(MethodNameProvider.insertComment_post)) {
            requestBody = new FormBody.Builder()
                    .add("commentContext", params[0].toString())
                    .add("targetPost", params[1].toString())
                    .build();
            request = new Request.Builder()
                    .post(requestBody)
                    .url(url + methodName)
                    .build();
        }
        Call call = client.newCall(request);
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    /**
     * 用于显示用户信息
     *
     * @param userId
     * @return
     */
    public static Object showUserInfo(Integer userId) {
        Response response = doGetMethod(MethodNameProvider.showUserInfo, userId);
        String jsonString = null;
        try {
            ResponseBody body = response.body();
            jsonString = body.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        if (jsonString.contains("errorMessage.")) {
            ErrorMessage errorMessage = parseErrorMessage(jsonString);
            return errorMessage;
        } else {
            UserToInfo userToInfo = gson.fromJson(jsonString, UserToInfo.class);
            return new AndroidUser(userId, userToInfo.getQueryUserInfoById().getAddress(), userToInfo.getQueryUserInfoById().getSelfSignature(), userToInfo.getQueryUserInfoById().getAge(), userToInfo.getQueryUserInfoById().getNickname(), userToInfo.getQueryUserInfoById().getSex());
        }
    }

    /**
     * 用户登录，并将返回的JSESSIONID存为一个静态变量，使用户在注销登录前的所有需要权限的操作不需要在进行登录操作。
     *
     * @param username
     * @param password
     */
    public static Integer login(String username, String password) {
        if (username != null && password != null) {
            Response response = doPostMethod(MethodNameProvider.login_post, username, password);
            String string = null;
            try {
                string = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Integer integer = Integer.valueOf(string);
            if (integer>0) {
                String header = response.header("Set-Cookie");
                String sessionId = header.substring(11, 43);
                JSESSIONID = sessionId;
                return integer;
            } else {
                return integer;
            }
        } else {
            JSESSIONID = "";
            return 0;
        }
    }

    /**
     * 在首页下拉刷新的帖子
     *
     * @param refreshCount
     * @param pageSize
     * @return
     */
    public static Object showHomePostList(Integer refreshCount, Integer pageSize) {
        Response response = doGetMethod(MethodNameProvider.showHomePostList, refreshCount, pageSize);
        String jsonString = null;
        try {
            ResponseBody body = response.body();
            jsonString = body.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Log.d("TAG", "showHomePostList: " + jsonString);
        if (jsonString.contains("errorMessage.")) {
            ErrorMessage errorMessage = parseErrorMessage(jsonString);
            return errorMessage;
        } else {
            HomePost homePost = gson.fromJson(jsonString, HomePost.class);
            List<HomePost.PaginationQueryAllPostListEntity> homePostList = homePost.getPaginationQueryAllPostList();
            List<AndroidPost> postList = new ArrayList<>();
            for (HomePost.PaginationQueryAllPostListEntity p : homePostList) {
                AndroidPost androidPost = new AndroidPost(p.getCommentCount(), p.getPostsId(), p.getPostMan(), p.getPostId(), p.getPostContext(), p.getPostTitle(), p.getCreateTime(), p.getPostManNickname(), p.getBelongPostsName());
                postList.add(androidPost);
            }
            return postList;
        }
    }

    /**
     * 获取一个评论下的所有回复
     *
     * @param targetComment
     * @return
     */
    public static List<AndroidReply> showReplyList(Integer targetComment) {
        List<AndroidReply> androidReplyList = new ArrayList<>();
        Response response = doGetMethod(MethodNameProvider.showAllReplyList, targetComment);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        ReplyList jsonResult = gson.fromJson(jsonString, ReplyList.class);
        List<ReplyList.ReplyListEntity> replyList = jsonResult.getReplyList();
        for (ReplyList.ReplyListEntity r : replyList) {
            AndroidReply androidReply = new AndroidReply(r.getTargetComment(), r.getTargetReply(), r.getReplyMan(), r.getCreateTime(), r.getReplyManUsername(), r.getReplyContext());
            androidReplyList.add(androidReply);
        }
        return androidReplyList;
    }

    /**
     * 查询一个用户的所有朋友圈
     *
     * @param userId
     * @return
     */
    public static List<AndroidPyq> showPyqList(Integer userId) {
        List<AndroidPyq> pyqList = new ArrayList<>();
        Response response = doGetMethod(MethodNameProvider.showPyqList, userId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        PyqList jsonResult = gson.fromJson(jsonString, PyqList.class);
        List<PyqList.QueryPyqListByIdEntity> queryPyqListById = jsonResult.getQueryPyqListById();
        for (PyqList.QueryPyqListByIdEntity o : queryPyqListById) {
            pyqList.add(new AndroidPyq(o.getUserId(), o.getPyqContext(), o.getCreateTime(), o.getNickname()));
        }
        return pyqList;
    }

    public static List<AndroidUserToPost> showUserStarPost(Integer userId) {
        List<AndroidUserToPost> starPostList = new ArrayList<>();
        Response response = doGetMethod(MethodNameProvider.showUserStarPost, userId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        StarPost jsonResult = gson.fromJson(jsonString, StarPost.class);
        List<StarPost.QueryUserStarPostForAndroidEntity> queryUserStarPostForAndroid = jsonResult.getQueryUserStarPostForAndroid();
        for (StarPost.QueryUserStarPostForAndroidEntity o : queryUserStarPostForAndroid) {
            starPostList.add(new AndroidUserToPost(o.getBelongPostsId(), o.getUserId(), o.getPostmanId(), o.getPostmanNickname(), o.getBelongPostsName(), o.getUserNickname(), o.getPostContext(), o.getPostCreatTime()));
        }
        return starPostList;
    }

    public static List<AndroidUserToPosts> showUserStarPosts(Integer userId) {
        List<AndroidUserToPosts> starPostsList = new ArrayList<>();
        Response response = doGetMethod(MethodNameProvider.showUserStarPosts, userId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        StarPosts jsonResult = gson.fromJson(jsonString, StarPosts.class);
        List<StarPosts.QueryUserStarPostsForAndroidEntity> queryUserStarPostsForAndroid = jsonResult.getQueryUserStarPostsForAndroid();
        for (StarPosts.QueryUserStarPostsForAndroidEntity o : queryUserStarPostsForAndroid) {
            starPostsList.add(new AndroidUserToPosts(o.getPostsId(), o.getPostsName(), o.getUserId(), o.getUserNickname()));
        }
        return starPostsList;
    }

    /**
     * 获取一个帖子的所有详细信息，包括评论，但是不包含回复
     *
     * @param postId
     * @param currentPage
     * @param pageSize
     * @return
     */
    public static AndroidPostDetail showPostDetail(Integer postId, Integer currentPage, Integer pageSize) {
        Response response = doGetMethod(MethodNameProvider.showPostDetail, postId, currentPage, pageSize);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        AndroidPostDetail jsonResult = gson.fromJson(jsonString, AndroidPostDetail.class);
        return jsonResult;
    }

    /**
     * 注册函数，但是注册完了需要重新登录一下，因为接口那边的直接登录的代码被我注掉了
     *
     * @param username
     * @param password
     * @param email
     * @param authority
     * @return
     */
    public static String register(String username, String password, String email, String authority) {
        Response usernameResponse = doPostMethod(MethodNameProvider.verification_post, username);
        Response emailResponse = doPostMethod(MethodNameProvider.verification_post, email);
        String usernameVerification = null;
        String emailVerification = null;
        try {
            usernameVerification = usernameResponse.body().string();
            emailVerification = emailResponse.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ErrorMessage usernameMessage = parseErrorMessage(usernameVerification);
        ErrorMessage emailMessage = parseErrorMessage(emailVerification);
        String usernameCode = usernameMessage.getErrorCode();
        String emailCode = emailMessage.getErrorCode();
        if (usernameCode.equals("verificationMsg.success") && emailCode.equals("verificationMsg.success")) {
            Response response = doPostMethod(MethodNameProvider.register_post, username, password, email, authority);
            String jsonString = null;
            try {
                jsonString = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ErrorMessage errorMessage = parseErrorMessage(jsonString);
            String errorCode = errorMessage.getErrorCode();
            if (errorCode.equals("verificationMsg.success")) {
                return "正在加入肯德基豪华套餐";
            } else
                return "注册失败，出现莫名错误，请重试";
        } else if (usernameCode.equals("verificationMsg.username")) {
            return "该用户名已经被注册了，请换一个用户名";
        } else if (emailCode.equals("verificationMsg.email")) {
            return "该邮箱已经被注册了，请换一个邮箱";
        } else
            return "出现莫名错误，请重试";
    }

    public static String updatePassword(String username, String oldPassword, String newPassword) {
        Response response = doPostMethod(MethodNameProvider.updatePassword_post, username, oldPassword, newPassword);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "密码修改成功";
        else
            return "密码修改失败";
    }

    public static ReplyToComment insertReplyForComment(String replyContext, Integer targetComment) {
        Response response = doGetMethod(MethodNameProvider.insertReplyForComment_post, replyContext, targetComment);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        ReplyToComment jsonResult = gson.fromJson(jsonString, ReplyToComment.class);
        return jsonResult;
    }

    public static ReplyToReply insertReplyForReply(String replyContext, Integer targetComment, Integer targetReply) {
        Response response = doPostMethod(MethodNameProvider.insertReplyForReply_post, replyContext, targetComment, targetReply);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        ReplyToReply jsonResult = gson.fromJson(jsonString, ReplyToReply.class);
        return jsonResult;
    }

    public static String insertPost(Integer postMan, Integer postsId, String postTitle, String postContext) {
        Response response = doPostMethod(MethodNameProvider.insertPost_post, postMan, postTitle, postContext, postsId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "发布成功";
        else
            return "发布失败";
    }

    public static CommentToPost insertComment(Integer targetPost, String commentContext) {
        Response response = doGetMethod(MethodNameProvider.insertComment_post, commentContext, targetPost);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        CommentToPost jsonResult = gson.fromJson(jsonString, CommentToPost.class);
        return jsonResult;
    }

    public static String starPost(Integer postId) {
        Response response = doGetMethod(MethodNameProvider.starPost, postId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "帖子收藏成功";
        else
            return "你已经收藏过该帖子了";
    }

    public static String starPosts(Integer postsId) {
        Response response = doGetMethod(MethodNameProvider.starPosts, postsId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "帖吧收藏成功";
        else
            return "帖吧收藏失败";
    }

    public static String unStarPost(Integer postId) {
        Response response = doGetMethod(MethodNameProvider.unStarPost, postId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "帖子取关成功";
        else
            return "帖子取关失败";
    }

    public static String unStarPosts(Integer postsId) {
        Response response = doGetMethod(MethodNameProvider.unStarPosts, postsId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "帖吧取关成功";
        else
            return "帖吧取关失败";
    }

    public static String updateUserInfo(@NotNull Integer userId, String nickname, String age, String sex, String address, String selfSignature) {
        Response response = doGetMethod(MethodNameProvider.updateUserInfo, userId, nickname, age, sex, address, selfSignature);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "个人信息更改完毕";
        else
            return "个人信息更改失败";
    }

    public static String insertPyq(String pyqContext) {
        Response response = doGetMethod(MethodNameProvider.insertPyq, pyqContext);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "朋友圈发布成功";
        else
            return "朋友圈发布失败";
    }

    public static String deletePyq(Integer userId, String createTime) {
        Response response = doGetMethod(MethodNameProvider.deletePyq, userId, createTime);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "朋友圈删除成功";
        else
            return "朋友圈删除失败";
    }


    public static Integer getReplyCount(Integer commentId) {
        Response response = doGetMethod(MethodNameProvider.getReplyCount, commentId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String count = parseSingleMessage(jsonString);
        return Integer.valueOf(count);
    }

    public static String deleteSingleReply(Integer postsId, Integer replyId) {
        Response response = doGetMethod(MethodNameProvider.deleteSingleReply, postsId, replyId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "回复删除成功";
        else
            return "回复删除失败";
    }

    public static String deleteSingleComment(Integer postsId, Integer commentId) {
        Response response = doGetMethod(MethodNameProvider.deleteSingleComment, postsId, commentId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "评论删除成功";
        else
            return "评论删除失败";
    }

    public static String deleteSinglePost(Integer postsId, Integer postId) {
        Response response = doGetMethod(MethodNameProvider.deleteSinglePost, postsId, postId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "帖子删除成功";
        else
            return "帖子删除失败";
    }

    public static String deleteSinglePosts(Integer postsId) {
        Response response = doGetMethod(MethodNameProvider.deleteSinglePost, postsId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "帖吧删除成功";
        else
            return "帖吧删除失败";
    }

    public static Integer getPostCount(Integer postsId) {
        Response response = doGetMethod(MethodNameProvider.getPostCount, postsId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String count = parseSingleMessage(jsonString);
        return Integer.valueOf(count);
    }

    public static List<AndroidPosts> blurryPostList(String blurryString, Integer currentPage, Integer pageSize) {
        List<AndroidPosts> postsList = new ArrayList<>();
        Response response = doGetMethod(MethodNameProvider.blurryQueryPostsList, blurryString, currentPage, pageSize);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        PostsForBlurry postsForBlurry = gson.fromJson(jsonString, PostsForBlurry.class);
        List<PostsForBlurry.BlurryQueryPostsListEntity> blurryQueryPostsList = postsForBlurry.getBlurryQueryPostsList();
        for (PostsForBlurry.BlurryQueryPostsListEntity b : blurryQueryPostsList) {
            postsList.add(new AndroidPosts(b.getPostsId(), b.getPostsTitle(), getPostCount(b.getPostsId()), b.getCreateTime(), b.getPostsMan()));
        }
        return postsList;
    }

    public static Integer getPostsCount() {
        Response response = doGetMethod(MethodNameProvider.getPostsCount);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String count = parseSingleMessage(jsonString);
        return Integer.valueOf(count);
    }

    public static String insertPosts(Integer postMan, String postsTitle) {
        Response response = doGetMethod(MethodNameProvider.insertPosts, postMan, postsTitle);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "创建贴吧成功";
        else
            return "创建贴吧失败";
    }

    public static List<AndroidUser> getRoleList(String postId) {
        List<AndroidUser> postsList = new ArrayList<>();
        Response response = doGetMethod(MethodNameProvider.getRoleList, postId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Role result = gson.fromJson(jsonString, Role.class);
        List<Role.QueryRoleListEntity> queryRoleList = result.getQueryRoleList();
        for (Role.QueryRoleListEntity b : queryRoleList) {
            postsList.add(new AndroidUser(b.getUserId(), b.getAddress(), b.getSelfSignature(), b.getAge(), b.getNickname(), b.getSex()));
        }
        return postsList;
    }

    public static String upUserRole(Integer postsId, Integer upUserId) {
        Response response = doGetMethod(MethodNameProvider.upUserRole, postsId, upUserId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "升职加薪啦";
        else
            return "升职加薪失败啦";
    }

    public static String downUserRole(Integer postsId, Integer downUserId) {
        Response response = doGetMethod(MethodNameProvider.downUserRole, postsId, downUserId);
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonString.contains("true"))
            return "被拉下马了";
        else
            return "还没被拉下马了";
    }

    public static Boolean isLanded() {
        return JSESSIONID.equals("") ? false : true;
    }

}
