package com.example.yuyingzhang.myapplication.User;

public class StringMainiputlation {

    public static String expendUsername(String username){
        return username.replace(".", " ");
    }
    public static String condenseUsername(String username){
        return username.replace(" ", ".");
    }
}