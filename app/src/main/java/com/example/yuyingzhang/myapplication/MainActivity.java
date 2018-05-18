package com.example.yuyingzhang.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuyingzhang.myapplication.Login.EmailPasswordActivity;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent  loginIntent = new Intent(MainActivity.this, EmailPasswordActivity.class);
                startActivity(loginIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
