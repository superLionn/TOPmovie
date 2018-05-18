package com.example.yuyingzhang.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yuyingzhang.myapplication.Home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *  Class for storing fragments for tabs
 */
public class SectionPagerAdapter extends FragmentPagerAdapter{

    private static final String TAG = "SectionsPagerAdapter";

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public SectionPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        return mFragmentList.get(position);
    }
    @Override
    public int getCount(){
        return mFragmentList.size();
    }
    public void addFragment(Fragment fragment){
        mFragmentList.add(fragment);
    }

}
