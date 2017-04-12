package com.videogo.http;

/**
 * Created by SJS on 2017/4/10.
 */

public  class userIdBean {
    private  String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "userId{" +
                "userId='" + userId + '\'' +
                '}';
    }
    public userIdBean(String s) {
        userId=s;
    }
}