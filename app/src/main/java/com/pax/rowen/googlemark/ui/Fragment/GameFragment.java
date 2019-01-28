package com.pax.rowen.googlemark.ui.Fragment;

import android.view.View;

import com.pax.rowen.googlemark.ui.view.LoadingPage;

public class GameFragment extends BaseFragment {

    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_EMPTY;
    }
}
