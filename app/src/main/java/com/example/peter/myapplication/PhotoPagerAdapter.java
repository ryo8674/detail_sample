package com.example.peter.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class PhotoPagerAdapter extends FragmentPagerAdapter {

    private List<Integer> list;

    public PhotoPagerAdapter(FragmentManager fm, List<Integer> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return PhotoFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
