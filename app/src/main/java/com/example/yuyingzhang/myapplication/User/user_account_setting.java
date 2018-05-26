package com.example.yuyingzhang.myapplication.User;

public class user_account_setting {

    private String description, first_name, last_name, prefer_movie_type, profile_photo;
    private long phone;

    public user_account_setting(String description, String first_name,String last_name, String prefer_movie_type, String profile_photo, long phone) {
        this.description = description;
        this.first_name = first_name;
        this.last_name = last_name;
        this.prefer_movie_type = prefer_movie_type;
        this.profile_photo = profile_photo;
        this.phone = phone;
    }
    public user_account_setting(user_account_setting settings) {

    }

    public user_account_setting() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPrefer_movie_type() {
        return prefer_movie_type;
    }

    public void setPrefer_movie_type(String prefer_movie_type) {
        this.prefer_movie_type = prefer_movie_type;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "user_account_setting{" +
                "description='" + description + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", prefer_movie_type='" + prefer_movie_type + '\'' +
                ", profile_photo='" + profile_photo + '\'' +
                ", phone=" + phone +
                '}';
    }
}
