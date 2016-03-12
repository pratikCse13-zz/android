package com.parse.starter.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.starter.R;
import com.parse.starter.models.NavDrawer_Row;

import java.util.List;


/**
 * Created by pratik on 2/4/2016.
 */
public class NavDrawer_adapter extends RecyclerView.Adapter<NavDrawer_Recycler_ViewHolder>{
    LayoutInflater myInflater;
    List<NavDrawer_Row> data;
    Context context;
    NavDrawer_Recycler_ViewHolder myViewHolder;

    public NavDrawer_adapter(Context context, List<NavDrawer_Row> data){
        this.context = context;
        myInflater = LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public NavDrawer_Recycler_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = myInflater.inflate(R.layout.nav_row,parent,false);
        myViewHolder = new NavDrawer_Recycler_ViewHolder(v);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(NavDrawer_Recycler_ViewHolder holder, int position) {
        Log.i("gotit",data.get(position).title);

        myViewHolder.myTextView.setText(data.get(position).title);
    }

    @Override
    public int getItemCount() {
        //Log.i("count",String.valueOf(data.size()));
        int i =data.size();
        return i;
    }
}
