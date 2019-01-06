package com.pax.rowen.googlemark.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.pax.rowen.googlemark.R;
import com.pax.rowen.googlemark.utils.UIUtils;

public class HomeHolder extends BaseHolder<String> {
    private  TextView tvContent;
    @Override
    public View initView() {
         //1 加载布局
          View view=UIUtils.inflate(R.layout.list_item_home);
         //2 初始化控件
        tvContent=view.findViewById(R.id.tv_content);
         return view;
    }

    @Override
    public void refreshView(String data) {
        tvContent.setText(data);
    }
}
