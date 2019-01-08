package com.pax.rowen.googlemark.ui.Fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pax.rowen.googlemark.R;
import com.pax.rowen.googlemark.ui.adapter.MyBaseAdapter;
import com.pax.rowen.googlemark.ui.holder.BaseHolder;
import com.pax.rowen.googlemark.ui.holder.HomeHolder;
import com.pax.rowen.googlemark.ui.view.LoadingPage;
import com.pax.rowen.googlemark.utils.UIUtils;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {
    //运行子线程,可以直接执行耗时网络操作。

    private ArrayList<String> data;

    @Override
    public LoadingPage.ResultState onLoad() {
       data=new ArrayList<String>();
        for (int i = 0; i <20; i++) {
            data.add("测试数据："+i);
        }
        //请求网络
        return LoadingPage.ResultState.STATE_SUCCESS;
    }

    //如果加载数据成功，就回调此方法，运行在主线程，只有成功才走
    @Override
    public View onCreatSuccessView(){
//        TextView view=new TextView(UIUtils.getContext());
//        view.setText(getClass().getSimpleName());
//        return view;
        ListView view=new ListView(UIUtils.getContext());
        view.setAdapter(new HomeAdapter(data));
        return view;
    }

    class HomeAdapter extends MyBaseAdapter<String>{

        public HomeAdapter(ArrayList<String> data) {
            super(data);
        }

        @Override
        public BaseHolder<String> getHolder() {
            return new HomeHolder();
        }

        @Override
        public boolean hasMore() {
            return false;
        }
        //        @Override
//        public View getView(int position, View converview, ViewGroup viewGroup) {
//            ViewHolder holder;
//            if(converview==null){
//                //1 加载布局
//                converview=UIUtils.inflate(R.layout.list_item_home);
//                holder=new ViewHolder();
//                //初始化控件
//                holder.tvContent=converview.findViewById(R.id.tv_content);
//                //打一个标记
//                converview.setTag(holder);
//            }else{
//                holder= (ViewHolder) converview.getTag();
//            }
//
//            String content=getItem(position);
//            holder.tvContent.setText(content);
//            return converview;
//        }
    }

    static class ViewHolder{
        private TextView tvContent;
    }

}
