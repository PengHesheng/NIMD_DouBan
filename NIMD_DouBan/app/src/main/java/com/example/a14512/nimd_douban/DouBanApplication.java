package com.example.a14512.nimd_douban;

import android.content.Context;
import android.util.Log;

import com.example.a14512.nimd_douban.base.Global;
import com.example.a14512.nimd_douban.http.RetrofitHelper;
import com.example.a14512.nimd_douban.utils.DouBanContext;

/**
 * Created by 14512 on 2017/8/29.
 */

public class DouBanApplication extends android.app.Application {

    private static Context mContext;
    public static String cacheDir = "";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        long startTime = System.currentTimeMillis();
        Log.e("startTime", startTime + "");
        DouBanContext.setApplication(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Global.init(this);
        mContext = getApplicationContext();
        RetrofitHelper.getInstance();
        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }


    public static Context getContext() {
        return mContext;
    }
}
