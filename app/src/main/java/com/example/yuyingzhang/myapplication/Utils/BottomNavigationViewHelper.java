package com.example.yuyingzhang.myapplication.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.example.yuyingzhang.myapplication.R;
import com.example.yuyingzhang.myapplication.Home.homeActivity;
import com.example.yuyingzhang.myapplication.Search.searchpageActivity;
import com.example.yuyingzhang.myapplication.Moive.movieinfoActivity;
import com.example.yuyingzhang.myapplication.Profile.personalinfoActivity;



public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel: setting up BottomNavigationView";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }
    public static void enablenavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home: //count 0
                        Intent intent1 = new Intent(context,homeActivity.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_movie: //count 1
                        Intent intent2 = new Intent(context,movieinfoActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_search: //count 2
                        Intent intent3 = new Intent(context,searchpageActivity.class);
                        context.startActivity(intent3);
                        break;

                    case R.id.ic_user: //count 3
                        Intent intent4 = new Intent(context,personalinfoActivity.class);
                        context.startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }
}
