package com.jhonlee.music.view.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class ViewpagerAdapter extends FragmentPagerAdapter {

    private String[] tabTitleArray;
    private List<Fragment> fragmentList;

    public ViewpagerAdapter(FragmentManager fm, String[] tabTitleArray, List<Fragment> fragmentList) {
        super(fm);
        this.tabTitleArray = tabTitleArray;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleArray[position % tabTitleArray.length];
    }
}
