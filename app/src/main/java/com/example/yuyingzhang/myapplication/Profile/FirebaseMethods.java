package com.example.yuyingzhang.myapplication.Profile;

import android.content.Context;
import android.util.Log;

import com.example.yuyingzhang.myapplication.User.user_account_setting;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseMethods {
    private static final String TAG = "FirebaseMethods";

    private FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    private Context mContext;
    private String userID;

    public FirebaseMethods(Context context) {
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        if (mAuth.getCurrentUser() != null) {
            userID = mAuth.getCurrentUser().getUid();
        }
    }

    public void updateUserAccountSetting(String description, String first_name,String last_name, String prefer_movie_type, String profile_photo, long phone){

        if (description != null){
            myRef.child("user_account_setting")
                    .child(userID)
                    .child("first_name")
                    .setValue(first_name);
        }
        if (first_name != null){
            myRef.child("user_account_setting")
                    .child(userID)
                    .child("first_name")
                    .setValue(first_name);
        }
        if (last_name != null){
            myRef.child("user_account_setting")
                    .child(userID)
                    .child("first_name")
                    .setValue(first_name);
        }
        if (prefer_movie_type != null){
            myRef.child("user_account_setting")
                    .child(userID)
                    .child("first_name")
                    .setValue(first_name);
        }
        if (profile_photo != null){
            myRef.child("user_account_setting")
                    .child(userID)
                    .child("first_name")
                    .setValue(first_name);
        }
        if ( phone != 0){
            myRef.child("user_account_setting")
                    .child(userID)
                    .child("first_name")
                    .setValue(first_name);
        }
    }

    public void addNewUser (String email, String firstName, String lastName){
        user_account_setting setting = new user_account_setting(
                "",
                firstName,
                lastName,
                "",
                "http://www.wtupian.com/file/20173/1_35152428942.jpg",
                61
                );

        myRef.child("user_account_setting")
                .child(userID)
                .setValue(setting);

    }


    /**
     * retrieves the account settings for the user currently logged in
     * database: user_account_settings node
     * database: user node
     * @param dataSnapshot
     * @return
     */
    public user_account_setting getUserAccountSetting(DataSnapshot dataSnapshot){
        Log.d(TAG, "getUserAccountSettings: retrieving user account setting from firebase.");

        user_account_setting settings = new user_account_setting();

        for (DataSnapshot ds: dataSnapshot.getChildren()){
            //user_account_settings node
            Log.d(TAG, "getUserSettings: snapshot key: " + ds.getKey());
            if (ds.getKey().equals("user_account_settings")){
                //Log.d(TAG, "getUserAccountSettings: datasnapshot: "+ ds);

                try {
                    settings.setFirst_name(
                            ds.child(userID)
                                    .getValue(user_account_setting.class)
                                    .getFirst_name()
                    );
                    settings.setLast_name(
                            ds.child(userID)
                                    .getValue(user_account_setting.class)
                                    .getLast_name()
                    );
                    settings.setProfile_photo(
                            ds.child(userID)
                                    .getValue(user_account_setting.class)
                                    .getProfile_photo()
                    );
                    settings.setDescription(
                            ds.child(userID)
                                    .getValue(user_account_setting.class)
                                    .getDescription()
                    );

                    settings.setPrefer_movie_type(
                            ds.child(userID)
                                    .getValue(user_account_setting.class)
                                    .getPrefer_movie_type()
                    );
                    settings.setPhone(
                            ds.child(userID)
                                    .getValue(user_account_setting.class)
                                    .getPhone()
                    );

                    Log.d(TAG, "getUserAccountSettings: retrieved user_account_settings information: " + settings.toString());
                }catch (NullPointerException e){
                    Log.d(TAG, "getUserSettings: NullPointerException: " + e.getMessage());
                }
            }
            }

        return new user_account_setting(settings);
    }
}
