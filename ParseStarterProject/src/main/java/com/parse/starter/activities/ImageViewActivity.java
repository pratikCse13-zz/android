package com.parse.starter.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.parse.starter.R;

/**
 * Created by pratik on 2/19/2016.
 */
public class ImageViewActivity extends Activity {

    ImageView myImageView;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_imageview);
        Log.i("here","completed ");
        myImageView = (ImageView)findViewById(R.id.imageView6);
        String url = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSdG0GtdFxdzJutZGQ6EPyvXBXjfscfSHp6pIEdfoaut5dHZHvP";
        try {
            ImageRequest myRequest = new ImageRequest(url,new Response.Listener<Bitmap>(){
                @Override
                public void onResponse(Bitmap response) {
                    myImageView.setImageBitmap(response);
                    myImageView.setImageResource(R.drawable.profile_icon);
                }
            }
                    ,0,0,null,null,new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            new SingletonRequestQueue().myRequestQueue.add(myRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
