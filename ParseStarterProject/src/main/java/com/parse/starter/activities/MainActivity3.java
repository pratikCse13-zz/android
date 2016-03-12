package com.parse.starter.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parse.ParseUser;
import com.parse.starter.R;
import com.parse.starter.activities.LoginActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    public void logOut(View view){
        ParseUser myUser = ParseUser.getCurrentUser();
        if(myUser != null) {

            ParseUser.logOut();
        }
        Intent myIntent = new Intent(this,LoginActivity.class);
        startActivity(myIntent);
    }
    public void onBackPressed() {
        System.exit(1);
    }

}
