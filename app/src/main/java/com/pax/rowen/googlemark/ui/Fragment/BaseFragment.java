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

public class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView view=new TextView(UIUtils.getContext());
//         view.setText(getClass().getSimpleName());
//        view.setTextColor(UIUtils.getColor(R.color.colorAccent));

        LoadingPage loadingPage=new LoadingPage(UIUtils.getContext());

         return loadingPage;
    }
}
