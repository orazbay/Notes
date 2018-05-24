package edu.sdu.kz.baseapplication;

import android.os.Bundle;
import android.util.Log;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.presentation.base.ActivityWithFragmentContainer;
import edu.sdu.kz.baseapplication.presentation.notesList.NotesListFragment;
import edu.sdu.kz.baseapplication.utils.FragmentUtils;

public class MainActivity extends ActivityWithFragmentContainer {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replace(this, R.id.fragmentContainer,new NotesListFragment());

        setSupportActionBar(findViewById(R.id.toolbar));

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
