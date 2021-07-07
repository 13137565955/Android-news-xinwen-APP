package com.example.ex5_1_1;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;

import android.util.TypedValue;


import com.example.ex5_1_1.fragment.FirstFragment;
import com.example.ex5_1_1.fragment.SecondFragment;
import com.example.ex5_1_1.fragment.ThirdFragment;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    //fragment
    private ViewPager viewPager;
    private MyAdapter adapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    private PagerTabStrip tabStrip;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        Fragment firstFragment = new FirstFragment();
        Fragment secondFragment = new SecondFragment();
        Fragment thirdFragment = new ThirdFragment();
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        titles.add("内容相关");
        titles.add("投诉举报");
        titles.add("网易号");

        tabStrip = (PagerTabStrip) findViewById(R.id.tabStrip);
        tabStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
        tabStrip.setTextColor(Color.WHITE);
        tabStrip.setBackgroundColor(Color.RED);

        manager = getSupportFragmentManager();
//      顺序问题MyAdapter构造方法顺序
        adapter = new MyAdapter(manager,titles,fragments);
        viewPager.setAdapter(adapter);

}
    protected void onResume() {
        int id= getIntent().getIntExtra("id", 0);
        if(id== 0){
            Fragment fourFragment = new Fragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.viewPager,fourFragment);
            fragmentTransaction.commit();
            viewPager.setCurrentItem(0);
        }else if (id== 1){
            Fragment fourFragment = new Fragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.viewPager,fourFragment);
            fragmentTransaction.commit();
            viewPager.setCurrentItem(1);
        }else if (id== 2){
            Fragment fourFragment = new Fragment();
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.viewPager,fourFragment);
            fragmentTransaction.commit();
            viewPager.setCurrentItem(2);
        }
        super.onResume();
    }

}
