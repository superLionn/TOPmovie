package com.example.yuyingzhang.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.yuyingzhang.myapplication.Login.EmailPasswordActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String QUOTE_KEY = "quote";
    public static final String AUTHOR_KEY = "author";
    public static final String TAG = "InspiringQuote";
    private static int SPLASH_TIME_OUT = 2000;

    private DocumentReference mDocRef= FirebaseFirestore.getInstance().document("sampleData/inspiration");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: aaa");
                Intent loginIntent = new Intent(MainActivity.this, EmailPasswordActivity.class);
                startActivity(loginIntent);
                Log.d(TAG, "run: bbb");
                finish();
                Log.d(TAG, "run: ccc");

            }
        }, SPLASH_TIME_OUT);
    }
    public void saveQuote(View view){
        //TODo: Fill thisout
        Log.d(TAG, "saveQuote: save");
        EditText quoteView = (EditText) findViewById(R.id.editTextQuote);
        EditText authorView = (EditText) findViewById(R.id.editTextAuthor);
        Log.d(TAG, "saveQuote: save2");
        String   quoteText  = quoteView.getText().toString();
        String  authorText = authorView.getText().toString();


        if(quoteText.isEmpty() || authorText.isEmpty()) {
            Log.d(TAG, "saveQuote: ifsave");

            return;
        }

        Map<String,Object> dataToSave = new HashMap<String,Object>();
        dataToSave.put(QUOTE_KEY, quoteText);
        dataToSave.put(AUTHOR_KEY, authorText);
        mDocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "Document has been saved!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Document was not saved!", e);
            }
        });
    }
}