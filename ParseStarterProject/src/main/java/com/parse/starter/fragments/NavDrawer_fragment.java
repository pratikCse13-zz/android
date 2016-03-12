package com.parse.starter.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.parse.starter.R;
import com.parse.starter.adapters.NavDrawer_adapter;

import com.parse.starter.models.NavDrawer_Row;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class NavDrawer_fragment extends Fragment {

    ActionBarDrawerToggle myDrawerToggler;
    DrawerLayout myDrawerLayout;
    Activity myActivity;
    Context myContext;
    RecyclerView myRecyclerView;
    NavDrawer_adapter myAdapter;
    String[] data = {"Home", "B", "C", "D", "E"};

    public List<NavDrawer_Row> makeModel() {
        List<NavDrawer_Row> temp = new ArrayList<NavDrawer_Row>();
        for (int i = 0; i < data.length; i++) {
            temp.add(i, new NavDrawer_Row(data[i]));
        }
        return temp;
    }

    public NavDrawer_fragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myActivity = activity;
        myContext = myActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation1, container, false);
        myRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        myAdapter = new NavDrawer_adapter(myContext, makeModel());
        myRecyclerView.setAdapter(myAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(myContext));
        return view;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void run(DrawerLayout dL, Toolbar tB, ActionBarDrawerToggle myDrawerToggler) {
        myDrawerLayout = dL;
        this.myDrawerToggler = myDrawerToggler;
    }


}

