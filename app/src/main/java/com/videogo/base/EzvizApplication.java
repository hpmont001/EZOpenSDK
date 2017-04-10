/* 
 * @ProjectName VideoGoJar
 * @Copyright HangZhou Hikvision System Technology Co.,Ltd. All Right Reserved
 * 
 * @FileName EzvizApplication.java
 * @Description 这里对文件进行描述
 * 
 * @author chenxingyf1
 * @data 2014-7-12
 * 
 * @note 这里写本文件的详细功能描述和注释
 * @note 历史记录
 * 
 * @warning 这里写本文件的相关警告
 */
package com.videogo.base;

import android.app.Application;

import com.videogo.openapi.EZOpenSDK;

import org.xutils.x;

/**
 * 自定义应用
 *
 * @author xiaxingsuo
 */
public class EzvizApplication extends Application {

    //开发者需要填入自己申请的appkey
    public static String AppKey = "04a8a34aa6394a27aca346f12254c767";
    private static EzvizApplication instance;
    public static EZOpenSDK getOpenSDK() {
        return EZOpenSDK.getInstance();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        instance = this;
        initSDK();
    }

    private void initSDK() {
        {
            /**
             * sdk日志开关，正式发布需要去掉
             */
            EZOpenSDK.showSDKLog(true);

            /**
             * 设置是否支持P2P取流,详见api
             */
            EZOpenSDK.enableP2P(false);

            /**
             * APP_KEY请替换成自己申请的
             */
            EZOpenSDK.initLib(this, AppKey, "");
        }
    }
    public static EzvizApplication getInstance(){
        return instance;
    }
}
