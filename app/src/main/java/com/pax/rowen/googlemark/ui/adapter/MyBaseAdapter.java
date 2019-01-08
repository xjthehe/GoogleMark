package com.pax.rowen.googlemark.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.pax.rowen.googlemark.ui.holder.BaseHolder;
import com.pax.rowen.googlemark.ui.holder.MoreHolder;

import java.util.ArrayList;

/**
 * 对adapter封装
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    //注意: 此处必须要从0开始写
    private static final int TYPE_NORMAL = 0;// 正常布局类型
    private static final int TYPE_MORE = 1;// 加载更多类型

   private ArrayList<T> data;
   public MyBaseAdapter(ArrayList<T> data){
       this.data = data;
    }
    @Override
    public int getCount() {
        return data.size()+1;// 增加加载更多布局数量
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 返回布局类型个数
    @Override
    public int getViewTypeCount() {
        return 2;// 返回两种类型,普通布局+加载更多布局
    }

    // 返回当前位置应该展示那种布局类型
    @Override
    public int getItemViewType(int position) {
       if(position==getCount()-1){
           return TYPE_MORE;
       }else{
           return getInnerType();
       }
    }

    // 子类可以重写此方法来更改返回的布局类型
    public int getInnerType() {
        return TYPE_NORMAL;// 默认就是普通类型
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        BaseHolder holder;
       if(convertView==null){
           //1 加载布局
           //2 初始化控件findviewByid
           //3打一个标记tag
           if(getItemViewType(position)==TYPE_MORE){
            // 加载更多的类型
               holder = new MoreHolder(hasMore());
           }else {
               holder=getHolder();// 子类返回具体对象
           }
       }else {
           holder= (BaseHolder) convertView.getTag();
       }
         //4根据数据刷新界面
        if(getItemViewType(position)!=TYPE_MORE){
            holder.setData(getItem(position));
        }else{
           //加载更多
        }
         return holder.getRootView();
    }


    //子类重写方法  加载更多
    public boolean hasMore(){
       return true;
    }

    //返回当前对象的holder  子类adapter去实现
    public abstract BaseHolder<T> getHolder();


}
