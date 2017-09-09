package com.example.a14512.nimd_douban.base;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by 14512 on 2017/8/14.
 */

public class BaseFragment extends Fragment {

    public void startIntentActivity(Fragment fragment1, BaseActivity activity){
        Intent intent = new Intent();
        intent.setClass(fragment1.getContext(),activity.getClass());
        startActivity(intent);
    }

    public void startIntentActivity(Fragment fragment1, BaseActivity activity, String name, String value){
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.setClass(fragment1.getContext(), activity.getClass());
        startActivity(intent);
    }

    public void startIntentActivity(Fragment fragment1, Fragment fragment2){
        Intent intent = new Intent();
        intent.setClass(fragment1.getContext(), fragment2.getClass());
        startActivity(intent);
    }

    public void startIntentActivity(Fragment fragment1, Fragment fragment2, String name, String value){
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.setClass(fragment1.getContext(), fragment2.getClass());
        startActivity(intent);
    }

    public void startIntentActivity(Context context, BaseActivity activity){
        Intent intent = new Intent();
        intent.setClass(context,activity.getClass());
        startActivity(intent);
    }

    public void startIntentActivity(Context context, BaseActivity activity, String name, String value){
        Intent intent = new Intent();
        intent.putExtra(name, value);
        intent.setClass(context,activity.getClass());
        startActivity(intent);
    }


}
