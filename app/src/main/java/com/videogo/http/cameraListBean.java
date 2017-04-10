package com.videogo.http;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SJS on 2017/3/31.
 */

public class cameraListBean {
    @SerializedName("result")
    private ResultBean result;

    public cameraListBean(ResultBean reBean) {
        result=reBean;
    }

    public static class   ResultBean {
        @SerializedName("page")
        private PageBean page;

        @SerializedName("data")
        private List<DataBean> data;

        @SerializedName("code")
        private String code;

        @SerializedName("msg")
        private String msg;

        public ResultBean(PageBean aa, List<DataBean> bean, String s, String ss) {
            page=aa;
            data=bean;
            code=s;
            msg=ss;
        }

        public List<DataBean> getData() {
            return  data;
        }

        public void setData(List<DataBean> data) {
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
                    "page=" + page +
                    ", data=" + data +
                    ", code='" + code + '\'' +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

    public static class   DataBean {
        @SerializedName("deviceId")
        private String deviceId;

        @SerializedName("deviceSerial")
        private String deviceSerial;

        @SerializedName("deviceName")
        private String deviceName;

        @SerializedName("cameraId")
        private String cameraId;

        @SerializedName("cameraNo")
        private String cameraNo;

        @SerializedName("cameraName")
        private String cameraName;

        @SerializedName("status")
        private String status;

        @SerializedName("isShared")
        private String isShared;

        @SerializedName("picUrl")
        private String picUrl;

        @SerializedName("isEncrypt")
        private String isEncrypt;

        @SerializedName("defence")
        private String defence;

        @SerializedName("videoLevel")
        private String videoLevel;


        public DataBean(String s,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10,String s11,String s12) {
            deviceId=s;
            deviceSerial=s2;
            deviceName=s3;
            cameraId=s4;
            cameraNo=s5;
            cameraName=s6;
            status=s7;
            isShared=s8;
            picUrl=s9;
            isEncrypt=s10;
            defence=s11;
            videoLevel=s12;


        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceSerial() {
            return deviceSerial;
        }

        public void setDeviceSerial(String deviceSerial) {
            this.deviceSerial = deviceSerial;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getCameraId() {
            return cameraId;
        }

        public void setCameraId(String cameraId) {
            this.cameraId = cameraId;
        }

        public String getCameraNo() {
            return cameraNo;
        }

        public void setCameraNo(String cameraNo) {
            this.cameraNo = cameraNo;
        }

        public String getCameraName() {
            return cameraName;
        }

        public void setCameraName(String cameraName) {
            this.cameraName = cameraName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIsShared() {
            return isShared;
        }

        public void setIsShared(String isShared) {
            this.isShared = isShared;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getIsEncrypt() {
            return isEncrypt;
        }

        public void setIsEncrypt(String isEncrypt) {
            this.isEncrypt = isEncrypt;
        }

        public String getDefence() {
            return defence;
        }

        public void setDefence(String defence) {
            this.defence = defence;
        }

        public String getVideoLevel() {
            return videoLevel;
        }

        public void setVideoLevel(String videoLevel) {
            this.videoLevel = videoLevel;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "deviceId='" + deviceId + '\'' +
                    ", deviceSerial='" + deviceSerial + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", cameraId='" + cameraId + '\'' +
                    ", cameraNo='" + cameraNo + '\'' +
                    ", cameraName='" + cameraName + '\'' +
                    ", status='" + status + '\'' +
                    ", isShared='" + isShared + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", isEncrypt='" + isEncrypt + '\'' +
                    ", defence='" + defence + '\'' +
                    ", videoLevel='" + videoLevel + '\'' +
                    '}';
        }
    }
    public static class  PageBean {
        @SerializedName("total")
        private String total;

        @SerializedName("page")
        private String page;

        @SerializedName("size")
        private String size;
        public PageBean(String s,String ss,String sss) {
            total=s;
            page = ss;
            size=sss;

        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "PageBean{" +
                    "total='" + total + '\'' +
                    ", page='" + page + '\'' +
                    ", size='" + size + '\'' +
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
