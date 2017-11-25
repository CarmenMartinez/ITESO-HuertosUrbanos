package com.weharvest2.weharvest20.beans;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fernando on 26/10/17.
 */

public class User {
    private  String username;
    private String password;
    private String email;
    private boolean isLogged;

    public User getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.iteso.PDDM_Sesion13.CACAHUATE",
                Context.MODE_PRIVATE);
        User user = new User();
        user.setUsername(sharedPreferences.getString("USER",null));
        user.setPassword(sharedPreferences.getString("PWD",null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED",false));
        user.setEmail(sharedPreferences.getString("EMAIL",null));
        return user;
    }

    public User () {
        username = "";
        password = "";
        email = "";
    }

    public User (String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public void savePreferences(Context context){
        SharedPreferences sharedPreferences =
                context.getSharedPreferences("com.iteso.PDDM_Sesion13.CACAHUATE",
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER",getUsername());
        editor.putString("PWD",getPassword());
        editor.putBoolean("LOGGED",true);
        editor.apply();
    }
}
