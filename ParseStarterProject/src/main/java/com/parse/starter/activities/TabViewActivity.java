package com.parse.starter.activities;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.parse.starter.R;
import com.parse.starter.adapters.TabViewAdapter;
import com.parse.starter.fragments.Fragment_b;

public class TabViewActivity extends AppCompatActivity{

    TabLayout myTabLayout;
    ViewPager myViewPager;
    TabViewAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        myViewPager = (ViewPager)findViewById(R.id.viewPager);
        myAdapter=new TabViewAdapter(getSupportFragmentManager());
        myAdapter.addFragment(new Fragment_b(), "WORK");
        myAdapter.addFragment(new Fragment_b(), "STUDY");
        /*myAdapter.addFragment(new Fragment_b(),"PLAY");
        myAdapter.addFragment(new Fragment_b(), "PLAY");
        myAdapter.addFragment(new Fragment_b(),"PLAY");
        myAdapter.addFragment(new Fragment_b(),"PLAY");
        myAdapter.addFragment(new Fragment_b(),"PLAY");*/
        myViewPager.setAdapter(myAdapter);
        myTabLayout.setupWithViewPager(myViewPager);



    }

}
