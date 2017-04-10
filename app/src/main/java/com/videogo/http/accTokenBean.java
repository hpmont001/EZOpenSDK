package com.videogo.http;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SJS on 2017/3/31.
 */

public class accTokenBean {
    @SerializedName("result")
    private ResultBean result;

    public accTokenBean(ResultBean reBean) {
        result=reBean;
    }

    public static class   ResultBean {
        @SerializedName("data")
        private DataBean data;

        @SerializedName("code")
        private String code;

        @SerializedName("msg")
        private String msg;

        public ResultBean(DataBean bean, String s, String ss) {
            data=bean;
            code=s;
            msg=ss;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "data=" + data +
                    ", code='" + code + '\'' +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

    public static class   DataBean {
        @SerializedName("accessToken")
        private String accessToken;

        @SerializedName("userId")
        private String userId;
        public DataBean(String s,String ss) {
            accessToken=s;
            userId = ss;

        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "accessToken='" + accessToken + '\'' +
                    ", userId='" + userId + '\'' +
                    '}';
        }
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "timeBean{" +
                "result=" + result +
                '}';
    }
}
