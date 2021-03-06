package com.example.yuyingzhang.myapplication.Profile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yuyingzhang.myapplication.R;
import com.example.yuyingzhang.myapplication.User.user_account_setting;
import com.example.yuyingzhang.myapplication.Utils.BottomNavigationViewHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.squareup.picasso.Picasso;

public class personalinfoActivity extends AppCompatActivity {

    private static final String TAG ="PersonalinfoActivity" ;
    private Context mContext = personalinfoActivity.this;
    private static final int ACTIVITY_NUM=2;
    protected static final int CHOOSE_PICTURE = 0;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    private ImageView profile;

    private EditText mFirstName;
    private EditText mLastName;
    private EditText mDescription;
    private EditText mPhone;
    private EditText mPreferMovieType;
    private user_account_setting mSettings;

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private FirebaseMethods mFirebaseMethods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);
        Log.d(TAG, "onCreate: started");
        profile=(ImageView) findViewById(R.id.profile);

        mFirstName = (EditText) findViewById(R.id.wfirstname);
        mLastName = (EditText) findViewById(R.id.wlastname);
        mDescription = (EditText) findViewById(R.id.wdescription);
        mPhone = (EditText) findViewById(R.id.wphone);
        mPreferMovieType = (EditText) findViewById(R.id.wfm);
        Button mBtnsave = (Button) findViewById(R.id.btnsave);

        mBtnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserSetting();
            }
        });

        mFirebaseMethods = new FirebaseMethods(mContext);

        setupFirebaseAuth();
        setupBottomNavigationView();

}

    /**
     * Setup Firebase auth object
     */

    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: test");

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                // check if the user is logged in
                //checkCurrentUser(user);

                if (user != null){
                    // user is signed in
                    Log.d(TAG, "onAuthStateChanged: signed_in: " + user.getUid());

                } else {
                    // user is signed out
                    Log.d(TAG, "onAuthStateChanged: signed_out");

                }
            }
        };

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                setUserWidgets(mFirebaseMethods.getUserAccountSetting(dataSnapshot));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void saveUserSetting() {
        Log.d(TAG, "saveUserSetting: test save");
        final String firstName = mFirstName.getText().toString();
        Log.d(TAG, "saveUserSetting:  test fn");
        final String lastName = mLastName.getText().toString();
        Log.d(TAG, "saveUserSetting:  test ln");

        final String description = mDescription.getText().toString();
        Log.d(TAG, "saveUserSetting:  test de");

        final long phone = Long.parseLong(mPhone.getText().toString());
        Log.d(TAG, "saveUserSetting:  test ph");

        final String prefermovie = mPreferMovieType.getText().toString();

        Log.d(TAG, "saveUserSetting: test again");

        //变更保存
        if(!description.equals(mSettings.getDescription())) {
            Log.d(TAG, "saveUserSetting: test description");
            mFirebaseMethods.updateUserAccountSetting(description,null,null,null,0);
            Toast.makeText(mContext, "SAVED:p", Toast.LENGTH_SHORT).show();
        }
        else if (!firstName.equals(mSettings.getFirst_name())) {
            mFirebaseMethods.updateUserAccountSetting(null,firstName,null,null,0);
            Toast.makeText(mContext, "SAVED:p", Toast.LENGTH_SHORT).show();
        }
        else if (!lastName.equals(mSettings.getLast_name())) {
            mFirebaseMethods.updateUserAccountSetting(null,null,lastName,null,0);
            Toast.makeText(mContext, "SAVED:p", Toast.LENGTH_SHORT).show();
        }
        else if (!prefermovie.equals(mSettings.getPrefer_movie_type())) {
            mFirebaseMethods.updateUserAccountSetting(description,null,null,prefermovie,0);
            Toast.makeText(mContext, "SAVED:p", Toast.LENGTH_SHORT).show();
        }
        else if (phone!=0) {
            mFirebaseMethods.updateUserAccountSetting(description,null,null,null,phone);
            Toast.makeText(mContext, "SAVED:p", Toast.LENGTH_SHORT).show();
        }
    }

    private void setUserWidgets(user_account_setting userAccountSetting){
        mSettings = userAccountSetting;
        Log.d(TAG, "setUserWidgets: test");
        mFirstName.setText(userAccountSetting.getFirst_name());
        Log.d(TAG, "setUserWidgets: test first name");
        mLastName.setText(userAccountSetting.getLast_name());
        Log.d(TAG, "setUserWidgets: test last name");
        mDescription.setText(userAccountSetting.getDescription());
        Log.d(TAG, "setUserWidgets: test description");
        mPreferMovieType.setText(userAccountSetting.getPrefer_movie_type());
        Log.d(TAG, "setUserWidgets: test prefer movie");
        mPhone.setText(String.valueOf(userAccountSetting.getPhone()));
        Log.d(TAG, "setUserWidgets: test phone");
        Picasso.with(mContext).load(userAccountSetting.getProfile_photo()).into(profile);
        Log.d(TAG, "setUserWidgets: test photo");
    }

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView.");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enablenavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
    public void showChoosePicDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("setting profile");
        String[] items = { "choose from album" };
        builder.setNegativeButton("cancel", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE:
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;

                }
            }
        });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {

                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData());
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data);
                    }
                    break;
            }
        }
    }
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");

        intent.putExtra("crop", "true");

        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            Log.d(TAG,"setImageToView:"+photo);
            photo = ImageUtils.toRoundBitmap(photo);
            profile.setImageBitmap(photo);
            uploadPic(photo);
        }
    }
    private void uploadPic(Bitmap bitmap) {

        String imagePath = ImageUtils.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath+"");
        if(imagePath != null){

            Log.d(TAG,"imagePath:"+imagePath);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        } else {

            Toast.makeText(this, "Need Permission", Toast.LENGTH_SHORT).show();
        }
    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);
    }
    public void onStop(){
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


}
