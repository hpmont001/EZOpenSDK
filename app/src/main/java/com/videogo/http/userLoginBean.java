package com.videogo.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SJS on 2017/4/10.
 */

public class userLoginBean {
    @Expose(deserialize = false,serialize = true)
    @SerializedName("UserName")
    private String UserName;

    @Expose(deserialize = false,serialize = true)
    @SerializedName("Password")
    private String Password;

    @Expose(deserialize = true,serialize = false)
    @SerializedName("Result")
    private String Result;

    @Expose(deserialize = true,serialize = false)
    @SerializedName("UserId")
    private String UserId;

    @Expose(deserialize = true,serialize = false)
    @SerializedName("Status")
    private String Status;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public userLoginBean(String s, String s1) {
        UserName=s;
        Password=s1;
    }

    public String getUsername() {
        return UserName;
    }

    public void setUsername(String username) {
        this.UserName = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }



    @Override
    public String toString() {
        return "userLoginBean{" +
                "username='" + UserName + '\'' +
                ", password='" + Password + '\'' +
                '}';
    }
//    public static class userId {
//        private  String userId;
//
//        public String getUserId() {
//            return userId;
//        }
//
//        public void setUserId(String userId) {
//            this.userId = userId;
//        }
//
//        @Override
//        public String toString() {
//            return "userId{" +
//                    "userId='" + userId + '\'' +
//                    '}';
//        }
//        public userId(String s) {
//            userId=s;
//        }
//    }

}
