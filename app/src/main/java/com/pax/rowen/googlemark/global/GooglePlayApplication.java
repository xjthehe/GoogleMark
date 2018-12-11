package com.pax.rowen.googlemark.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * 自定义application，进行全局化
 *
 */
public class GooglePlayApplication extends Application {
    private static Context context;
    private static Handler handler;
    private static int mainThreadId;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        handler=new Handler();
        mainThreadId=android.os.Process.myTid();
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        GooglePlayApplication.context = context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static void setHandler(Handler handler) {
        GooglePlayApplication.handler = handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static void setMainThreadId(int mainThreadId) {
        GooglePlayApplication.mainThreadId = mainThreadId;
    }
}
