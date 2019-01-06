package com.pax.rowen.googlemark.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.pax.rowen.googlemark.ui.holder.BaseHolder;

import java.util.ArrayList;

/**
 * 对adapter封装
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
   private ArrayList<T> data;
   public MyBaseAdapter(ArrayList<T> data){
       this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        BaseHolder holder;
       if(convertView==null){
           //1 加载布局
           //2 初始化控件findviewByid
           //3打一个标记tag
           holder=getHolder();
       }else {
           holder= (BaseHolder) convertView.getTag();
       }
         //4根据数据刷新界面
         holder.setData(getItem(position));

         return holder.getRootView();
    }



    //返回当前对象的holder  子类adapter去实现
    public abstract BaseHolder<T> getHolder();


}
