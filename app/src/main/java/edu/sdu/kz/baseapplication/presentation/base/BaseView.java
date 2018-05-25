package edu.sdu.kz.baseapplication.presentation.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import com.arellomobile.mvp.MvpView;

public interface BaseView extends MvpView {
    public  void showMessage(String message);
    public void showCloseError(String message);
    public  void goToActivity(Class<?> activityClass, boolean finishCurrentActivity);

}
