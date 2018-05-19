package com.example.yuyingzhang.myapplication.Search;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.example.yuyingzhang.myapplication.R;
import com.example.yuyingzhang.myapplication.Utils.BottomNavigationViewHelper;
import com.example.yuyingzhang.myapplication.actionActivity;
import com.example.yuyingzhang.myapplication.comedyActivity;
import com.example.yuyingzhang.myapplication.romanceActivity;
import com.example.yuyingzhang.myapplication.scifiActivity;
import com.example.yuyingzhang.myapplication.thrillerActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class searchpageActivity extends AppCompatActivity {
    private static final String TAG = "searchpageActivity";
    private Context mContext = searchpageActivity.this;
    private static final int ACTIVITY_NUM=1;

    AutoCompleteTextView search_box;
    Spinner movies;
    ArrayList<String> movie=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpage);
        Log.d(TAG, "onCreate: started");

        setupBottomNavigationView();
        search_box=(AutoCompleteTextView)findViewById(R.id.search_box);
        movies=(Spinner)findViewById(R.id.movies);
        movie.add("Titanic");
        movie.add("La La Land");
        movie.add("Love Actually");
        movie.add("A Walk to Remember");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(searchpageActivity.this,android.R.layout.simple_spinner_dropdown_item,movie);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(searchpageActivity.this,android.R.layout.simple_spinner_dropdown_item,movie);
        search_box.setAdapter(adapter);
        movies.setAdapter(adapter);
    }
    /**
     * bottomNavigationView setup
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView.");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enablenavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
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
    public void thrillerClick(View view){
        Intent intent=new Intent(this,thrillerActivity.class);
        startActivity(intent);
    }
}
