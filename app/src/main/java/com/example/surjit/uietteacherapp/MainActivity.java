package com.example.surjit.uietteacherapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences mpreferences = this.getSharedPreferences("login_token", MODE_PRIVATE);
        String mtokenchecker = mpreferences.getString("logintoken", "");
        if (mtokenchecker.equalsIgnoreCase("loggedin"))
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    /*Intent mintent = new Intent(MainActivity.this, );
                    startActivity(mintent);
                    finish();*/
                }
            }, 1000);
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mintent = new Intent(MainActivity.this,LoginActivity.class );
                    startActivity(mintent);
                    finish();
                }
            }, 1000);
        }
    }
}