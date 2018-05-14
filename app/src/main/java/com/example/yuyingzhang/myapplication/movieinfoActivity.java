package com.example.yuyingzhang.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class movieinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movieinfo);
    }
    public void plusClick(View view) {
        Intent intent=new Intent(this,ReviewActivity.class);
        startActivity(intent);
    }
}
