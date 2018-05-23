package edu.sdu.kz.baseapplication.presentation.example;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import edu.sdu.kz.baseapplication.data.network.LoginService;
import edu.sdu.kz.baseapplication.data.network.RetrofitHelper;
import edu.sdu.kz.baseapplication.data.network.models.SignInRequest;
import edu.sdu.kz.baseapplication.presentation.base.BasePresenter;
import edu.sdu.kz.baseapplication.utils.RxUtils;


@InjectViewState
public class SamplePresenter extends BasePresenter<SampleView> {
    public SamplePresenter(){

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public void show(){



        getViewState().setText1("text1");
        getViewState().setText2("text2");
        getViewState().setText3("text3");
        getViewState().setText4("text4");
        getViewState().setText5("text5");
    }
}
