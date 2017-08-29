package com.example.a14512.nimd_douban.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by 14512 on 2017/8/14.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 设置状态栏颜色
     * Android4.4以上可用
     */
    public void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//状态栏
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintResource(color);
            tintManager.setStatusBarTintEnabled(true);
        }
    }

    /**
     * 活动跳转
     * @param activity1 当前活动
     * @param activity2 目标活动
     */
    public void startIntentActivity(BaseActivity activity1,BaseActivity activity2){
        Intent intent = new Intent();
        intent.setClass(activity1, activity2.getClass());
        startActivity(intent);
    }

    public void startIntentActivity(BaseActivity activity1,BaseActivity activity2, String name, String value){
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.setClass(activity1, activity2.getClass());
        startActivity(intent);
    }

    public void startIntentActivity(BaseActivity activity1,Fragment fragment2){
        Intent intent = new Intent();
        intent.setClass(activity1, fragment2.getClass());
        startActivity(intent);
    }

    public void startIntentActivity(BaseActivity activity1,Fragment fragment2, String name, String value){
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.setClass(activity1, fragment2.getClass());
        startActivity(intent);
    }

}
