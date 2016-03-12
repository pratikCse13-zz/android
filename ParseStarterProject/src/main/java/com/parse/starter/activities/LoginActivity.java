/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter.activities;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.starter.R;


public class LoginActivity extends AppCompatActivity implements View.OnKeyListener, View.OnFocusChangeListener {

  Button login, signup;
  EditText username, password;
  RelativeLayout myLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_layout);
    login = (Button) findViewById(R.id.login);
    signup = (Button) findViewById(R.id.signup);
    username = (EditText) findViewById(R.id.username);
    password = (EditText) findViewById(R.id.password);
    myLayout = (RelativeLayout)findViewById(R.id.layout1);
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
    username.setOnKeyListener(this);
    password.setOnKeyListener(this);
    username.setOnFocusChangeListener(this);
    password.setOnFocusChangeListener(this);
    myLayout.clearFocus();
  }


  public void username(View view) {
    username.setText("");
  }

  public void password(View view) {
    password.setText("");
  }

  public void logMeIn(View view) {

    ParseUser.logInInBackground(String.valueOf(username.getText()), String.valueOf(password.getText()), new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if (e != null) {
          Toast.makeText(getApplicationContext(), e.toString().substring(e.toString().indexOf(" ")) + "\n re-enter details", Toast.LENGTH_LONG).show();

        } else {
          Toast.makeText(getApplicationContext(), String.valueOf(username.getText()) + " logged in", Toast.LENGTH_LONG).show();
          Log.i("hello", String.valueOf(username.getText()));
          Intent myIntent1 = new Intent(getApplicationContext(), MainActivity3.class);
          startActivity(myIntent1);
        }
      }
    });


  }

  public void goToSignIn(View view) {

    Intent myIntent = new Intent(this, RegisterActivity.class);

    startActivity(myIntent);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public void onBackPressed() {
    this.finish();
    Intent myIntent = new Intent(this, ActivityMain.class);
    startActivity(myIntent);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
  
  @Override
  public boolean onKey(View v, int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
      logMeIn(v);

    }
    return false;
  }

  @Override
  public void onFocusChange(View v, boolean hasFocus) {
    if (username.getText().toString().equals("")) {
      username.setText("Username");

    }
    if (password.getText().toString().equals("")) {
      password.setText("Password");
    }
    if (v == username && hasFocus == true) {
      if (((EditText) v).getText().toString().equals("Username")) {
        username.setText("");
      }}
    if (v == password && hasFocus == true) {
      if (((EditText) v).getText().toString().equals("Password")) {
        password.setText("");
      }}
    }
  }

