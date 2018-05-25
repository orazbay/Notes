package edu.sdu.kz.baseapplication.presentation.base;

import android.util.Log;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ConnectException;

import edu.sdu.kz.baseapplication.data.network.NoConnectivityException;
import retrofit2.HttpException;


public class BasePresenter<View extends BaseView> extends MvpPresenter<View> {
    public void handleBasicErrors(Throwable error) {
            Log.e("handleBasicErrors",error.toString());
            if (error instanceof HttpException){
                HttpException httpException=(HttpException)error;
                try {
                    JSONObject jsonObject=new JSONObject(httpException.response().errorBody().string());
                    getViewState().showMessage(jsonObject.getString("message"));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (error instanceof NoConnectivityException){
               getViewState().showCloseError("You don't have internet connection");
            }
    }

    public int getErrorCode(Throwable error){
        int errorCode=-1;
        if (error instanceof HttpException){
            HttpException httpException=(HttpException)error;
            try {
                JSONObject jsonObject=new JSONObject(httpException.response().errorBody().string());
                errorCode=jsonObject.getInt("code");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return errorCode;
    }
}
