package com.pax.rowen.googlemark.ui.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pax.rowen.googlemark.R;
import com.pax.rowen.googlemark.ui.view.LoadingPage;
import com.pax.rowen.googlemark.utils.UIUtils;

public abstract class BaseFragment extends Fragment {
    LoadingPage mLoadingPage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView view=new TextView(UIUtils.getContext());
//         view.setText(getClass().getSimpleName());
//        view.setTextColor(UIUtils.getColor(R.color.colorAccent));

//        LoadingPage loadingPage=new LoadingPage(UIUtils.getContext());
        ////////////////////////


        mLoadingPage=new LoadingPage(UIUtils.getContext()){
            @Override
            public View onCreatSuccessView() {
                return BaseFragment.this.onCreatSuccessView();
            }

            @Override
            protected ResultState onLoad() {
                return BaseFragment.this.onLoad();
            }
        };
        return mLoadingPage;
    }

    //加载成功布局，必须由子类实现
    public abstract View onCreatSuccessView();

    //加载网络数据 子类实现
    public abstract LoadingPage.ResultState onLoad();


    public void loadDate(){
            if(mLoadingPage!=null){
                mLoadingPage.loadDate();
            }
        }

}
