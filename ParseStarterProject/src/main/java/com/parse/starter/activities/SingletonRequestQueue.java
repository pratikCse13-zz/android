package com.parse.starter.activities;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.parse.starter.StarterApplication;

/**
 * Created by pratik on 2/19/2016.
 */
public class SingletonRequestQueue {
    public RequestQueue myRequestQueue;
    public SingletonRequestQueue(){
       // myRequestQueue = Volley.newRequestQueue(StarterApplication.myApplication);
    }
}
