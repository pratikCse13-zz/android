package com.parse.starter.activities;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.parse.starter.R;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pratik on 2/17/2016.
 */
public class ActivityMain extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {

        Log.i("created","created view");
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_activity_main);


    }

}
