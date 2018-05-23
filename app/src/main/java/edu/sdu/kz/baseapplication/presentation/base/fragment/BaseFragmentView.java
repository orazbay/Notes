package edu.sdu.kz.baseapplication.presentation.base.fragment;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.arellomobile.mvp.MvpView;

import edu.sdu.kz.baseapplication.presentation.base.BaseView;

public interface BaseFragmentView extends BaseView {
  public void showProgress();
  public void hideProgress();

  public void showToast(String message);
}
