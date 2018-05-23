package edu.sdu.kz.baseapplication.utils;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by orazbay on 3/9/18.
 */

public class FragmentUtils {
    public static void replace(AppCompatActivity appCompatActivity, int containerId, Fragment fragment){
        appCompatActivity.getSupportFragmentManager().
                beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(null)
                .commit();
    }
}
