package edu.sdu.kz.baseapplication.presentation.base.refresh;

import com.arellomobile.mvp.MvpView;

public interface RefreshFragmentView extends MvpView {
    public void showProgress();
    public void hideProgress();

}
