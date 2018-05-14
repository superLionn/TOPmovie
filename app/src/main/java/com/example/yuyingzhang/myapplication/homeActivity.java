package com.example.yuyingzhang.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void searchClick(View view) {
        Intent intent=new Intent(this,searchpageActivity.class);
        startActivity(intent);
    }
    public void movieinfoClick(View view) {
        Intent intent=new Intent(this,movieinfoActivity.class);
        startActivity(intent);
    }
    public void personalinfoClick(View view) {
        Intent intent=new Intent(this,personalinfoActivity.class);
        startActivity(intent);
    }
}
