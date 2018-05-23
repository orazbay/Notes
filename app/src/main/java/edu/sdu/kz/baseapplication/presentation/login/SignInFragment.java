package edu.sdu.kz.baseapplication.presentation.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.presentation.base.fragment.BaseFragment;

import static edu.sdu.kz.baseapplication.utils.StringUtils.isNotEmpty;


/**
 * Created by orazbay on 4/7/18.
 */

public class SignInFragment extends BaseFragment implements LoginView {
    @InjectPresenter
    LoginPresenter presenter;
    @BindView(R.id.email_sign_in)
    EditText emailSignIn;
    @BindView(R.id.passwordEt_sign_in)
    EditText passwordEtSignIn;
    @BindView(R.id.sign_in_btn)
    Button signInBtn;
    @BindView(R.id.link_sign_up)
    TextView linkSignUp;


    public SignInFragment() {
        setViewId(R.layout.fragment_sign_in);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        signInBtn.setOnClickListener(v->{
            if (isAllInputsFilled()){
                presenter.signIn(
                        emailSignIn.getText().toString(),
                        passwordEtSignIn.getText().toString()
                );
            }

        });

        linkSignUp.setOnClickListener(v->{
            changePage();
        });
        return view;
    }

    private boolean isAllInputsFilled(){
        return isNotEmpty(emailSignIn.getText().toString())&&
                isNotEmpty(passwordEtSignIn.getText().toString());

    }


    @Override
    public void changePage() {
        ((LoginActivity)getActivity()).changePage(1);
    }
}
