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


public class SignUpFragment extends BaseFragment implements LoginView {


    @InjectPresenter
    LoginPresenter presenter;

    @BindView(R.id.nameEt)
    EditText nameEdittext;
    @BindView(R.id.emailEt)
    EditText emailEdittext;
    @BindView(R.id.passwordEt)
    EditText passwordEdittext;
    @BindView(R.id.passwordEt1)
    EditText passwordEdittext1;

    @BindView(R.id.sign_up_btn)
    Button signUp;
    @BindView(R.id.link_sign_in)
    TextView linkSignIn;


    public SignUpFragment() {
        setViewId(R.layout.fragment_sign_up);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        setupInputs();

        signUp.setOnClickListener(
                v -> {
                    if (isAllInputsFilled() && isPasswordsSame()) {
                        presenter.signUp(
                                nameEdittext.getText().toString(),
                                emailEdittext.getText().toString(),
                                passwordEdittext.getText().toString()
                        );

                    }

                });

        linkSignIn.setOnClickListener(
                v -> {
                    changePage();
                }
        );
        return view;
    }

    private void setupInputs() {

    }

    private boolean isAllInputsFilled() {
        if(isNotEmpty(nameEdittext.getText().toString()) &&
                isNotEmpty(emailEdittext.getText().toString()) &&
                isNotEmpty(passwordEdittext.getText().toString()) &&
                isNotEmpty(passwordEdittext1.getText().toString())){
            return true;

        }else {
            showErrorEmpty();
            return false;
        }

    }

    private boolean isPasswordsSame() {
        if (isNotEmpty(passwordEdittext.getText().toString()) && isNotEmpty(passwordEdittext1.getText().toString())) {
            if (passwordEdittext.getText().toString().equals(passwordEdittext1.getText().toString())) {
                return true;
            } else {
                showPasswordsNotSameError();
                return false;
            }
        }
        return false;
    }

    public void showErrorEmpty() {
        String error = "emtpy";
        if (!isNotEmpty(emailEdittext.getText().toString())) {
            emailEdittext.setError(error);
        }
        if (!isNotEmpty(passwordEdittext.getText().toString())) {
            passwordEdittext.setError(error);
        }
        if (!isNotEmpty(passwordEdittext1.getText().toString())) {
            passwordEdittext1.setError(error);
        }
        if (!isNotEmpty(nameEdittext.getText().toString())) {
            nameEdittext.setError(error);
        }

    }

    public void showPasswordsNotSameError() {
        String error = "not same";
        passwordEdittext.setError(error);
        passwordEdittext1.setError(error);

    }

    @Override
    public void changePage() {
        ((LoginActivity) getActivity()).changePage(0);
    }
}
