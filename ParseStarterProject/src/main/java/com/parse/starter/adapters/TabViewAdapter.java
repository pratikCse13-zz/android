package com.parse.starter.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratik on 2/16/2016.
 */
public class TabViewAdapter extends FragmentPagerAdapter {

    public List<Fragment> myFragmentList = new ArrayList<>();
    public List<String> myFragmentNames = new ArrayList<>();



    public TabViewAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment myFm, String name){
        myFragmentList.add(myFm);
        myFragmentNames.add(name);
    }
    @Override
    public Fragment getItem(int position) {
        return myFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }
}
