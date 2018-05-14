package com.example.yuyingzhang.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class searchpageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpage);
    }
    public void actionClick(View view){
        Intent intent=new Intent(this,actionActivity.class);
        startActivity(intent);
    }
    public void comedyClick(View view){
        Intent intent=new Intent(this,comedyActivity.class);
        startActivity(intent);

    }
    public void romanceClick(View view){
        Intent intent=new Intent(this,romanceActivity.class);
        startActivity(intent);

    }
    public void scifiClick(View view){
        Intent intent=new Intent(this,scifiActivity.class);
        startActivity(intent);
    }
    public void  thrillerClick(View view){
        Intent intent=new Intent(this,thrillerActivity.class);
        startActivity(intent);
    }
}
