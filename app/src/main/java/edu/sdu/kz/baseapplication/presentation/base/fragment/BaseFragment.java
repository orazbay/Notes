package edu.sdu.kz.baseapplication.presentation.base.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;
import edu.sdu.kz.baseapplication.utils.ToastUtils;


public class BaseFragment extends MvpAppCompatFragment implements BaseFragmentView {
    private int viewId;
    protected View view;

    protected AlertDialog progressDialog;


    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        progressDialog = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog_NoActionBar
        ).setCancelable(false).setView(new ProgressBar(getContext())).create();
        if (viewId == 0) {
            return new View(getContext());
        }
        view = inflater.inflate(viewId, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showToast(String message) {
        ToastUtils.showToast(getContext(), message);
    }

    @Override
    public void showMessage(String message) {
        {
            new AlertDialog.Builder(getContext())
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, (d, i) -> {
                        d.cancel();
                    })
                    .create().show();
        }
    }

    @Override
    public void showCloseError(String message) {
        new AlertDialog.Builder(getContext())
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Close application", (d, i) -> {
                    d.cancel();
                    getActivity().finish();
                })
                .create().show();
    }

    @Override
    public void goToActivity(Class<?> activityClass, boolean finishCurrentActivity) {
        getActivity().startActivity(new Intent(getActivity(), activityClass));
        if (finishCurrentActivity) {
            getActivity().finish();
        }
    }
}
