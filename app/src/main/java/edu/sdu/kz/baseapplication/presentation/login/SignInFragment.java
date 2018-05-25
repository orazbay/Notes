package edu.sdu.kz.baseapplication.presentation.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
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
    @BindView(R.id.textInputLayoutEmail)
    TextInputLayout textInputLayoutEmail;
    @BindView(R.id.textInputLayoutPassword)
    TextInputLayout textInputLayoutPassword;
    @BindView(R.id.container_sign_in_inputs)
    LinearLayout containerSignInInputs;


    public SignInFragment() {
        setViewId(R.layout.fragment_sign_in);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        signInBtn.setOnClickListener(v -> {
            if (isAllInputsFilled()) {
                presenter.signIn(
                        emailSignIn.getText().toString(),
                        passwordEtSignIn.getText().toString()
                );
            }else {
                showErrorEmpty();
            }

        });

        linkSignUp.setOnClickListener(v -> {
            changePage();
        });
        return view;
    }

    private boolean isAllInputsFilled() {
        return isNotEmpty(emailSignIn.getText().toString()) &&
                isNotEmpty(passwordEtSignIn.getText().toString());

    }


    @Override
    public void changePage() {
        ((LoginActivity) getActivity()).changePage(1);
    }


    public void showErrorEmpty(){
        String error="emtpy";
        if (!isNotEmpty(emailSignIn.getText().toString())){
            emailSignIn.setError(error);
        }
        if (!isNotEmpty(passwordEtSignIn.getText().toString())){
            passwordEtSignIn.setError(error);
        }

    }
}
