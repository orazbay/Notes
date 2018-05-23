package edu.sdu.kz.baseapplication.presentation.example;

import android.os.Bundle;
import android.util.Log;

import edu.sdu.kz.baseapplication.R;
import edu.sdu.kz.baseapplication.presentation.base.refresh.ActivityWithRefreshLayout;
import edu.sdu.kz.baseapplication.utils.FragmentUtils;

public class SampleActivity extends ActivityWithRefreshLayout {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentUtils.replace(this, R.id.fragmentContainer,new SampleFragment());
        FragmentUtils.replace(this, R.id.fragmentContainer,new SampleFragment());

    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        Log.e("onBackPressed: ", "count " + count);
        if (count == 1) {
            finish();

        }else {
            super.onBackPressed();
        }

    }
}
