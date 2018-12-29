package com.pax.rowen.googlemark.ui.Fragment;

import android.view.View;
import android.widget.TextView;

import com.pax.rowen.googlemark.ui.view.LoadingPage;
import com.pax.rowen.googlemark.utils.UIUtils;

public class HomeFragment extends BaseFragment {
    //运行子线程,可以直接执行耗时网络操作。

    @Override
    public LoadingPage.ResultState onLoad() {
       //请求网络
        return LoadingPage.ResultState.STATE_SUCCESS;
    }

    //如果加载数据成功，就回调此方法，运行在主线程，只有成功才走
    @Override
    public View onCreatSuccessView(){
        TextView view=new TextView(UIUtils.getContext());
        view.setText(getClass().getSimpleName());
        return view;
    }

}
