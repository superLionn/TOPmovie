package com.example.yuyingzhang.myapplication.Moive;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.yuyingzhang.myapplication.R;
import com.example.yuyingzhang.myapplication.ReviewActivity;
import com.example.yuyingzhang.myapplication.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class movieinfoActivity extends AppCompatActivity {

    private static final String TAG ="PersonalinfoActivity" ;
    private Context mContext = movieinfoActivity.this;
    private static final int ACTIVITY_NUM=1;
    private Button btnAddToDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started");
        //declare buttons

        setupBottomNavigationView();


    }
    /**
     * bottomNavigationView setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView.");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enablenavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    public void plusClick(View view) {
            Intent intent=new Intent(this, ReviewActivity.class);
            startActivity(intent);
    }
}

