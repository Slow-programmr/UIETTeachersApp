package com.example.surjit.uietteacherapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText pass;
    Button mloginbutton;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        constraintLayout = findViewById(R.id.constraint_layout);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        mloginbutton = findViewById(R.id.login_button);
        pass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if((keyEvent!=null &&(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)||(i == EditorInfo.IME_ACTION_DONE)))
                {
                    SharedPreferences mpreferences = LoginActivity.this.getSharedPreferences("login_token", MODE_PRIVATE);
                    SharedPreferences.Editor meditor = mpreferences.edit();
                    meditor.putString("logintoken","loggedin");
                    meditor.apply();
                    /*Intent mintent = new Intent(LoginActivity.this,);
                    startActivity(mintent);
                    finish();*/
                }

                    return false;
            }
        });
    }

    public void Login(View view)
    {
        SharedPreferences mpreferences = LoginActivity.this.getSharedPreferences("login_token", MODE_PRIVATE);
        SharedPreferences.Editor meditor = mpreferences.edit();
        meditor.putString("logintoken","loggedin");
        meditor.apply();
        /*
        Intent mintent = new Intent(LoginActivity.this,);
        startActivity(mintent);
        finish();*/
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("Username", username.getText().toString());
        outState.putString("Password", pass.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        pass.setText(savedInstanceState.getString("Password"));
        username.setText(savedInstanceState.getString("Username"));
        super.onRestoreInstanceState(savedInstanceState);

    }
}
