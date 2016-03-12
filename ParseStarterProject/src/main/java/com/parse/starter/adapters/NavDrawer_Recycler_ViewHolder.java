package com.parse.starter.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.parse.starter.R;

/**
 * Created by pratik on 2/4/2016.
 */
public class NavDrawer_Recycler_ViewHolder extends RecyclerView.ViewHolder{
    TextView myTextView;
    public NavDrawer_Recycler_ViewHolder(View itemView) {
        super(itemView);
        myTextView = (TextView)itemView.findViewById(R.id.textView);

    }

}
