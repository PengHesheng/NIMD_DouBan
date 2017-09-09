package com.example.a14512.nimd_douban.utils;

import android.content.Context;

import com.example.a14512.nimd_douban.DouBanApplication;
import com.example.a14512.nimd_douban.base.Global;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 14512 on 2017/8/29.
 */

public class DouBanContext {
    private final static AtomicReference<DouBanApplication> aApplication = new AtomicReference<>();
    public static Context getApplicationContext(){
        return Global.getApplicationContext();
    }
    public static void setApplication(DouBanApplication application){


        if(application == null){
            throw new NullPointerException("application can not be null");
        }
        if(aApplication.getAndSet(application) != null){
            throw new IllegalStateException("application can only be set once");
        }
    }

    public static DouBanApplication getApplication(){
        return aApplication.get();
    }
}
