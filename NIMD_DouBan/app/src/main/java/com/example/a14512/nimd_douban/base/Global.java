package com.example.a14512.nimd_douban.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * Created by Soully on 2017/7/26.
 */

public final class Global {

    private static Context context;
    private static boolean isDebug = false;


    public final static void init(Context ctx)
    {
        setContext(ctx);
    }

    public final static Context getContext()
    {
        if (context == null)
        {
            throw new NullPointerException("Global's Context is NULL, have your DouBanApplication in manifest "
                    + "subclasses BaseApplication or Call 'Global.init(this)' in your own DouBanApplication ? ");
        }

        return context;
    }

    public final static void setContext(Context context)
    {
        Global.context = context;

        try
        {
            ApplicationInfo info = context.getApplicationInfo();

            isDebug = ((info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0);

            if (isDebug)
            {
                android.util.Log.w("Wns.Global.Runtime", "DEBUG is ON");
            }
        }
        catch (Exception e)
        {
            isDebug = false;
        }
    }

    public final static Context getApplicationContext() {
        return getContext().getApplicationContext();
    }
}
