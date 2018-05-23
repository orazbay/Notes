package edu.sdu.kz.baseapplication.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;



public class BaseActivity extends MvpAppCompatActivity{
    protected int layoutId;
    public BaseActivity(int layoutId){
        this.layoutId=layoutId;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId!=0) {
            setContentView(layoutId);
            ButterKnife.bind(this);
        }
    }
}
