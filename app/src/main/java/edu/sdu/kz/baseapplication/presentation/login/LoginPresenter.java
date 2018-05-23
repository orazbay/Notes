package edu.sdu.kz.baseapplication.presentation.login;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import edu.sdu.kz.baseapplication.MainActivity;
import edu.sdu.kz.baseapplication.data.network.LoginService;
import edu.sdu.kz.baseapplication.data.network.RetrofitHelper;
import edu.sdu.kz.baseapplication.data.network.models.SignInRequest;
import edu.sdu.kz.baseapplication.data.network.models.SignUpRequest;
import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.base.BasePresenter;
import edu.sdu.kz.baseapplication.presentation.base.fragment.BaseFragmentView;
import edu.sdu.kz.baseapplication.presentation.example.SampleActivity;
import edu.sdu.kz.baseapplication.utils.RxUtils;


/**
 * Created by orazbay on 4/4/18.
 */

@InjectViewState
public class LoginPresenter extends BasePresenter<LoginView> {
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Log.e( "onFirstViewAttach: ", "true");
    }

    public void signUp(String name,
                       String email,
                       String password){
        getViewState().showProgress();

        Log.e("signUp","called");

        RetrofitHelper.getService(LoginService.class).signUp(
                new SignUpRequest(email,name,password)
        ).compose(RxUtils.applySchedulers()).
                subscribe(
                        response->{
                            Log.e("responseString",response.ownerId);
                            getViewState().hideProgress();
                            getViewState().changePage();
                            getViewState().showMessage("You are registered  successfully\n Sign in");

                        },

                        error->{
                            getViewState().hideProgress();
                            handleBasicErrors(error);
                        }
                        );

    }
    public void signIn(String email,
                       String password){
        getViewState().showProgress();
        Log.e("signIn","called");

        RetrofitHelper.getService(LoginService.class).signIn(
                new SignInRequest(email,password)
        ).compose(RxUtils.applySchedulers()).
                subscribe(
                        response->{
                            getViewState().hideProgress();
                            Log.e("responseString",response.user_token);
                            PreferencesHelper.INSTANCE.saveToken(response.user_token);
                            PreferencesHelper.INSTANCE.saveId(response.ownerId);
                            getViewState().goToActivity(MainActivity.class,true);
                        },
                        error->{
                            getViewState().hideProgress();
                            handleBasicErrors(error);
                        }
                );
    }


}
