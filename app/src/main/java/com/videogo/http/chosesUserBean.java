package com.videogo.http;

import java.util.List;

/**
 * Created by SJS on 2017/4/11.
 */

public class chosesUserBean {
    private String Count;
    private List<deviceInfo> Data;

    public chosesUserBean(String count, List<deviceInfo> data) {
        Count = count;
        Data = data;
    }

    public class deviceInfo{
     private String deviceSerial;
        private String deviceName;
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

        @Override
        public String toString() {
            return "deviceInfo{" +
                    "deviceSerial='" + deviceSerial + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    '}';
        }
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public List<deviceInfo> getData() {
        return Data;
    }

    public void setData(List<deviceInfo> data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "chosesUserBean{" +
                "Count='" + Count + '\'' +
                ", Data=" + Data +
                '}';
    }
}
