package com.pax.rowen.googlemark.ui.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.pax.rowen.googlemark.R;
import com.pax.rowen.googlemark.domain.AppInfo;
import com.pax.rowen.googlemark.http.HttpHelper;
import com.pax.rowen.googlemark.utils.BitmapHelper;
import com.pax.rowen.googlemark.utils.UIUtils;

public class HomeHolder extends BaseHolder<AppInfo> {
    private TextView tvName, tvSize, tvDes;
    private ImageView ivIcon;
    private RatingBar rbStar;
    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
        //1 加载布局
        View view=UIUtils.inflate(R.layout.list_item_home);

        // 2. 初始化控件
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvSize = (TextView) view.findViewById(R.id.tv_size);
        tvDes = (TextView) view.findViewById(R.id.tv_des);
        ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
        rbStar = (RatingBar) view.findViewById(R.id.rb_star);
//        mBitmapUtils = new BitmapUtils(UIUtils.getContext());
        mBitmapUtils = BitmapHelper.getBitmapUtils();

        return view;
    }

    @Override
    public void refreshView(AppInfo data) {
        tvName.setText(data.name);
        tvSize.setText(Formatter.formatFileSize(UIUtils.getContext(), data.size));
        tvDes.setText(data.des);
        rbStar.setRating(data.stars);
        mBitmapUtils.display(ivIcon, HttpHelper.URL + "image?name="
                + data.iconUrl);
    }
}
