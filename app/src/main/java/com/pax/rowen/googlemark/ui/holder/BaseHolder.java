package com.pax.rowen.googlemark.ui.holder;

import android.view.View;

public  abstract class BaseHolder<T> {
    private View mRootView;
    private T data;

    public BaseHolder(){
        mRootView=initView();
        //3.打标记TAG
        mRootView.setTag(this);
    }

    // 1.加载布局
    //2 findviewById
    public  abstract View initView();

    public View getRootView(){
        return mRootView;
    }
    //设置数据
    public void setData(T data){
        this.data=data;
        refreshView(data);
    }

    public T getData(){
        return data;
    }
    //4根据数据 刷新界面
    public abstract void refreshView(T data);

}
