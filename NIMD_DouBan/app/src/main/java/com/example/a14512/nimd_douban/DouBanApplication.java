package com.example.a14512.nimd_douban;

import android.content.Context;
import android.util.Log;

import com.example.a14512.nimd_douban.base.Global;
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

    }


    public static Context getContext() {
        return mContext;
    }
}
