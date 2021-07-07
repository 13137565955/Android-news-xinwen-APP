package com.example.ex5_1_1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by admin on 2021/5/18.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;//侧滑容器中的“碎片”
    private ArrayList<String> titles;//每个“碎片”对应的标题
    private FragmentManager manager;

    public MyAdapter(FragmentManager manager, ArrayList<String> titles, ArrayList<Fragment> fragments) {
        super(manager);
        this.manager = manager;
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
