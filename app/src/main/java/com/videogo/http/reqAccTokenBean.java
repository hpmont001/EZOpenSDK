package com.videogo.http;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SJS on 2017/3/30.
 */

public class reqAccTokenBean {
    @SerializedName("id")
    private String id;

    @SerializedName("system")
    private Systems system;

    @SerializedName("method")
    private String method;

    @SerializedName("params")
    private Params params;

    public reqAccTokenBean(String s, Systems systemBean, String s1, Params paramsBean) {
        id=s;
        system=systemBean;
        method=s1;
        params=paramsBean;
    }



    public static class   Systems{
        @SerializedName("key")
        private String key;

        @SerializedName("sign")
        private String sign;

        @SerializedName("time")
        private String time;

        @SerializedName("ver")
        private String ver;

        public Systems(String s, String s1, String s2, String s3) {
            key=s;
            sign=s1;
            time=s2;
            ver=s3;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        @Override
        public String toString() {
            return "Systems{" +
                    "key='" + key + '\'' +
                    ", sign='" + sign + '\'' +
                    ", time='" + time + '\'' +
                    ", ver='" + ver + '\'' +
                    '}';
        }
    }
    public static class   Params{
        @SerializedName("phone")
        private String phone;

        public Params(String s) {
            phone=s;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Params{" +
                    "phone='" + phone + '\'' +
                    '}';
        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public Systems getSystem() {
        return system;
    }

    public void setSystem(Systems system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "reqAccTokenBean{" +
                "id='" + id + '\'' +
                ", system=" + system +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }
}
