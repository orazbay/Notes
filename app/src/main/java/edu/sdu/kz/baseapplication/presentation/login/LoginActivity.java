package edu.sdu.kz.baseapplication.presentation.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.presentation.base.BaseActivity;


public class LoginActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    public LoginActivity() {
        super(R.layout.activity_login);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewPager();
    }

    private void setupViewPager(){
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(
                getSupportFragmentManager(),
                new Fragment[]{
                        new SignInFragment(),
                        new SignUpFragment()}
        );
        viewPager.setAdapter(viewPagerAdapter);
    }
    public void changePage(int page){
        if (page==0||page==1) {
            viewPager.setCurrentItem(page);
        }
    }

}
