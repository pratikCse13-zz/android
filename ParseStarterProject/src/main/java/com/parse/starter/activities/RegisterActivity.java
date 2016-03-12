package com.parse.starter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.starter.R;

public class RegisterActivity extends AppCompatActivity implements View.OnKeyListener,View.OnFocusChangeListener{

    Button button1,button2;
    EditText editText1,editText2,editText3,editText4,editText5,editText6;
    RelativeLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        myLayout = (RelativeLayout)findViewById(R.id.layout2);
        myLayout.clearFocus();
        editText6.setOnKeyListener(this);
        editText5.setOnKeyListener(this);
        editText4.setOnKeyListener(this);
        editText3.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
        editText1.setOnKeyListener(this);
        editText1.setOnFocusChangeListener(this);
        editText2.setOnFocusChangeListener(this);
        editText3.setOnFocusChangeListener(this);
        editText4.setOnFocusChangeListener(this);
        editText5.setOnFocusChangeListener(this);
        editText6.setOnFocusChangeListener(this);


    }



    public void backToLogin(View view){
        Intent myIntent = new Intent(this,LoginActivity.class);
        startActivity(myIntent);

    }

    public void signUpDone(View view){
        ParseUser myUser = new ParseUser();

        myUser.setEmail(String.valueOf(editText4.getText()));
        myUser.setUsername(String.valueOf(editText5.getText()));
        myUser.setPassword(String.valueOf(editText6.getText()));
        myUser.put("FirstName", String.valueOf(editText1.getText()));
        myUser.put("LastName", String.valueOf(editText2.getText()));
        myUser.put("PhoneNo", String.valueOf(editText3.getText()));
        myUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(getApplicationContext(), "Sign Up failed\n"+e.getMessage()+"\nRe-enter details ", Toast.LENGTH_LONG).show();
                    Log.i("result", e.getMessage());

                }else{
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(myIntent);
                }
            }
        });



    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
            signUpDone(v);
        }
        return false;
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if(editText1.getText().toString().equals("")){
            editText1.setText("First Name");
        }
        if(editText2.getText().toString().equals("")){
            editText2.setText("Last Name");
        }
        if(editText3.getText().toString().equals("")){
            editText3.setText("Phone Number");
        }
        if(editText4.getText().toString().equals("")){
            editText4.setText("Email-ID");
        }
        if(editText5.getText().toString().equals("")){
            editText5.setText("Username");
        }
        if(editText6.getText().toString().equals("")){
            editText6.setText("Password");
        }
        if(v==editText1&& hasFocus == true){
            if(((EditText)v).getText().toString().equals("First Name")) {
                editText1.setText("");
            }
    }


        if( v == editText2 && hasFocus == true){
            if(((EditText)v).getText().toString().equals("Last Name")) {
                editText2.setText("");
            }
        }

        if( v == editText3 && hasFocus == true){
            if(((EditText)v).getText().toString().equals("Phone Number")) {
                editText3.setText("");
            }
        }

        if( v == editText4 && hasFocus == true){
            if(((EditText)v).getText().toString().equals("Email-ID")) {
                editText4.setText("");
            }
        }

        if( v == editText5 && hasFocus == true){
            if(((EditText)v).getText().toString().equals("Username")) {
                editText5.setText("");
            }
        }

        if( v == editText6 && hasFocus == true){
            if(((EditText)v).getText().toString().equals("Password")) {
                editText6.setText("");
            }
        }


}
}
