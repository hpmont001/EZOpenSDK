package com.videogo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.videogo.base.EzvizApplication;
import com.videogo.http.accTokenBean;
import com.videogo.http.cameraListBean;
import com.videogo.http.chosesUserBean;
import com.videogo.http.reqAccTokenBean;
import com.videogo.http.reqCameraListBean;
import com.videogo.http.timeBean;
import com.videogo.http.userIdBean;
import com.videogo.http.userLoginBean;
import com.videogo.openapi.EZOpenSDK;
import com.videogo.scan.main.Contents;
import com.videogo.ui.cameralist.EZCameraListActivity;
import com.videogo.ui.util.ActivityUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import ezviz.ezopensdk.R;

import static com.videogo.util.hasxAndStr.string2HexString;
import static org.xutils.common.util.MD5.md5;

public class MainActivity extends Activity {
    private String TAG = this.getClass().getSimpleName();
    private String URL="https://open.ys7.com/api/method";
    private String RequestStr="";
    private String timeUTC="";
    private String key ="04a8a34aa6394a27aca346f12254c767";
    private String sign ="";
    private String ver= "1.0";
    private String phone= "18610056339";
    private String accessToken= "";
    private List<cameraListBean.DataBean> cameraList;
    private Gson gson;
    private EditText usernameEt, passwordEt;
    private Button loginBtn;
    private List<chosesUserBean.deviceInfo> InfoList;
    private SharedPreferences sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        gson = new Gson();
        sharedPrefs = getSharedPreferences("EZShare", Context.MODE_PRIVATE);
        if(!sharedPrefs.getString("UserId","USER_ACCOUNT").equals("USER_ACCOUNT")){
            Intent toIntent = new Intent(MainActivity.this, EZCameraListActivity.class);
            toIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    toIntent.putExtra("deviceInfoList", (Serializable) InfoList);
            MainActivity.this.startActivity(toIntent);
        }

        usernameEt =(EditText)findViewById(R.id.et_acc);
        passwordEt =(EditText)findViewById(R.id.et_password);
        loginBtn = (Button)findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i(TAG, "cameraList.size()="+String.valueOf(cameraList.size()));
//                if(cameraList.size()>0){
                //获取透明云账号验证
                    Login(usernameEt.getText(),passwordEt.getText());

                    Intent toIntent = new Intent(MainActivity.this, EZCameraListActivity.class);
                    toIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    toIntent.putExtra("deviceInfoList", (Serializable) InfoList);
                    MainActivity.this.startActivity(toIntent);

//                }
//                else {
//                    Toast.makeText(MainActivity.this,"密码错误",Toast.LENGTH_LONG).show();
//                    usernameEt.setText("");
//                    passwordEt.setText("");
//                }

            }
        });

    //获取时间戳
        hasTime();
        //调用萤石云登录web
        // ActivityUtils.goToLoginAgain(MainActivity.this);



    }

    private void hasTime() {
        RequestParams requestparams = new RequestParams("https://open.ys7.com/api/time/get");
        requestparams.addParameter("id", "11000");
        requestparams.addParameter("appKey",key);
//        //根据当前请求方式添加参数位置
//        params.addParameter("passWord", PASSWORD);
        Log.i(TAG, "params：" + requestparams);
        x.http().post(requestparams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG,"Time="+result);
                java.lang.reflect.Type  timeType =new TypeToken<timeBean>() {}.getType();
                timeBean timeResult = gson.fromJson(result,timeType);
                timeUTC = timeResult.getResult().getData().getServerTime().toString();
                Log.i(TAG,"timeUTC="+timeUTC);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                  if (!timeUTC.isEmpty()){
                      hasAcc();
                  }
            }
        });
        }


    private void hasAcc() {
        RequestParams requestparams = new RequestParams(URL);
        /***
         * "key": "116622259fed4920a3e8957e13dc2346",
         "sign": "8845c7ad6066c9cf1df170afd7dd5f06",
         "time": 1415843917,
         "ver":
         */
        sign=md5("phone:"+phone+",method:token/getAccessToken,time:"+timeUTC+",secret:a6ccdcaccfd162e7206a1f27da069341");
        reqAccTokenBean.Systems systemBean = new reqAccTokenBean.Systems(
                key,sign,timeUTC,ver);
        reqAccTokenBean.Params paramsBean = new reqAccTokenBean.Params(phone);
        reqAccTokenBean bean = new reqAccTokenBean("123456",systemBean,"token/getAccessToken",paramsBean);
        String RequestStr = gson.toJson(bean);
//        requestparams.addParameter("aaa", RequestStr);
        requestparams.setAsJsonContent(true);
        requestparams.setBodyContent(RequestStr);
        requestparams.setCharset("UTF-8");
        Log.i(TAG, "hasAcc_params：" + requestparams);
        Log.i(TAG, "hasAcc_params：" + requestparams+RequestStr);
        x.http().post(requestparams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, "hasAcc_params：" + result);
                java.lang.reflect.Type  Type =new TypeToken<accTokenBean>() {}.getType();
                accTokenBean relt = gson.fromJson(result,Type);
                accessToken = relt.getResult().getData().getAccessToken();
                Log.i(TAG,"hasAcc_accessToken="+accessToken);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
               if(!accessToken.isEmpty()){
                   EzvizApplication.getOpenSDK().setAccessToken(accessToken);
               }
                hasCameraList();
            }
        });
    }

    private void hasCameraList() {
        RequestParams requestparams = new RequestParams(URL);
        /***
         * "key": "116622259fed4920a3e8957e13dc2346",
         "sign": "8845c7ad6066c9cf1df170afd7dd5f06",
         "time": 1415843917,
         "ver":
         */
        Log.i(TAG,"hasCameraList_accessToken="+accessToken);
        sign=md5("accessToken:"+accessToken+",pageSize:20,pageStart:0"+",method:cameraList,time:"+timeUTC+",secret:a6ccdcaccfd162e7206a1f27da069341");
        Log.i(TAG,"hasCameraList_sign="+"accessToken:"+accessToken+",pageSize:20,pageStart:0"+",method:token/getAccessToken,time:"+timeUTC+",secret:a6ccdcaccfd162e7206a1f27da069341");
        Log.i(TAG,"hasCameraList_sign="+sign);
        reqCameraListBean.Systems systemBean = new reqCameraListBean.Systems(
                key,sign,timeUTC,ver);
        reqCameraListBean.Params paramsBean = new reqCameraListBean.Params(accessToken,"20","0");
        reqCameraListBean bean = new reqCameraListBean("123456","cameraList",paramsBean,systemBean);
        String RequestStr = gson.toJson(bean);
//        requestparams.addParameter("aaa", RequestStr);
        requestparams.setAsJsonContent(true);
        requestparams.setBodyContent(RequestStr);
        requestparams.setCharset("UTF-8");
        Log.i(TAG, "hasCameraList_params：" + requestparams);
        Log.i(TAG, "hasCameraList_params：" + requestparams+RequestStr);
        x.http().post(requestparams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, "hasCameraList_params：" + result);
                java.lang.reflect.Type  Type =new TypeToken<cameraListBean>() {}.getType();
                cameraListBean relt = gson.fromJson(result,Type);
                cameraList = relt.getResult().getData();
                Log.i(TAG,"hasCameraList_cameraList="+cameraList);


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                if(!accessToken.isEmpty()){
                    EzvizApplication.getOpenSDK().setAccessToken(accessToken);
                }
            }
        });
    }

    private void Login(Editable usernameEtText, Editable passwordEtText) {
//        RequestParams requestparams = new RequestParams(URL);
        RequestParams requestparams = new RequestParams("http://182.92.173.223:8082/api/User");
//        requestparams.addParameter("UserName", usernameEtText.toString());
//        requestparams.addParameter("Password",passwordEtText.toString());
//        requestparams.addParameter("Md5", "0");passwordEtText.toString()
//        requestparams.addParameter("LoginTime","0");
        userLoginBean bean = new userLoginBean(usernameEtText.toString(),passwordEtText.toString());
        String RequestStr = gson.toJson(bean);
//        requestparams.addParameter("aaa", RequestStr);
        requestparams.setAsJsonContent(true);
        requestparams.setBodyContent(RequestStr);
//        requestparams.setCharset("UTF-8");
        Log.i(TAG,"Login_tmy_RequestStr:"+RequestStr);
        Log.i(TAG,"Login_tmy_requestparams:"+requestparams);
        x.http().post(requestparams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG,"Login_tmy_result:"+result);
                java.lang.reflect.Type  Type =new TypeToken<userLoginBean>() {}.getType();
                userLoginBean relt = gson.fromJson(result,Type);
                if(relt.getResult().equals("Yes")){
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("UserId", relt.getUserId());
                    editor.commit();

                }
                Log.i(TAG,"hasCameraList_cameraList="+cameraList);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }



}
