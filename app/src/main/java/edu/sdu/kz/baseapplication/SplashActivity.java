package edu.sdu.kz.baseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import edu.sdu.kz.baseapplication.data.prefs.PreferencesHelper;
import edu.sdu.kz.baseapplication.presentation.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(
                ()->{
                    Intent intent;
                    if(PreferencesHelper.INSTANCE.getToken().equals("")){
                        intent=new Intent(this,LoginActivity.class);
                    }else {
                        intent=new Intent(this,MainActivity.class);
                    }
                    startActivity(intent);
                    finish();

                },
                1500
        );
    }
}
