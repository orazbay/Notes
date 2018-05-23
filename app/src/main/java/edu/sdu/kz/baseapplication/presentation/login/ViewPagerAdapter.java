package edu.sdu.kz.baseapplication.presentation.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by orazbay on 4/4/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;

    public ViewPagerAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
