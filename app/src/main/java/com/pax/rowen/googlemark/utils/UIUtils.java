package com.pax.rowen.googlemark.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.pax.rowen.googlemark.global.GooglePlayApplication;

import static com.pax.rowen.googlemark.global.GooglePlayApplication.getMainThreadId;

public class UIUtils {

    public static Context getContext(){
        return GooglePlayApplication.getContext();
    }

    public static Handler getHandler(){
            return GooglePlayApplication.getHandler();
    }

    public static int  getMainThread(){
        return getMainThreadId();
    }

    //////////////////////////////////
    //获取字符串
    public static String getString(int id){
        return getContext().getResources().getString(id);
    }

    /**
     * 根据id获取字符串数组
     */
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }


    /**
     * 根据id获取图片
     */
    public static Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    /**
     * 根据id获取颜色值
     */
    public static int getColor(int id) {
        return getContext().getResources().getColor(id);
    }

    //根据id获取颜色的状态选择器
    public static ColorStateList getColorStateList(int id) {
        return getContext().getResources().getColorStateList(id);
    }
    /**
     * 根据id获取尺寸
     */
    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id);
    }
    ///////////////////////////////////////
//像素密度

    /**
     * dp转px
     */
    public static int dip2px(float dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5);
    }

    /**
     * px转dp
     */
    public static float px2dip(float px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return px / density;
    }

////////////////////////////////////////////////////////
    /**
     * 加载布局文件
     */
    public static View inflate(int layoutId) {
        return View.inflate(getContext(), layoutId, null);
    }


    /**
     * 判断当前是否运行在主线程
     *
     * @return
     */
    public static boolean isRunOnUiThread() {
        return getMainThreadId() == android.os.Process.myTid();
    }

    /**
     * 保证当前的操作运行在UI主线程
     *
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        if (isRunOnUiThread()) {
            runnable.run();
        } else {
            getHandler().post(runnable);
        }
    }



    // /////////////////判断是否运行在主线程//////////////////////////
    public static boolean isRunOnUIThread() {
        // 获取当前线程id, 如果当前线程id和主线程id相同, 那么当前就是主线程
        int myTid = android.os.Process.myTid();
        if (myTid == getMainThreadId()) {
            return true;
        }

        return false;
    }
    // 运行在主线程
    public static void runOnUIThread(Runnable r) {
        if (isRunOnUIThread()) {
            // 已经是主线程, 直接运行
            r.run();
        } else {
            // 如果是子线程, 借助handler让其运行在主线程
            getHandler().post(r);
        }
    }























}
