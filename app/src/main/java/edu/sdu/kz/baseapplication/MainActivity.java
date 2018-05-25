package edu.sdu.kz.baseapplication;

import android.os.Bundle;
import android.util.Log;

import butterknife.BindView;
import edu.sdu.kz.baseapplication.presentation.base.ActivityWithFragmentContainer;
import edu.sdu.kz.baseapplication.presentation.notesList.NotesListFragment;
import edu.sdu.kz.baseapplication.utils.FragmentUtils;

public class MainActivity extends ActivityWithFragmentContainer {

    public interface OnBackPressedFragment{
        public void onBack();
    }

    private OnBackPressedFragment onBackPressedFragment;

    public void setOnBackPressedFragment(OnBackPressedFragment onBackPressedFragment) {
        this.onBackPressedFragment = onBackPressedFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentUtils.replace(this, R.id.fragmentContainer,new NotesListFragment());

        setSupportActionBar(findViewById(R.id.toolbar));

    }


    @Override
    public void onBackPressed() {
        if (onBackPressedFragment==null) {
            int count = getSupportFragmentManager().getBackStackEntryCount();
            if (count == 1) {
                finish();

            } else {
                super.onBackPressed();
            }
        }else {
            onBackPressedFragment.onBack();
        }

    }


}
