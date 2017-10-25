package com.iteso.fernando.proyecto_huertosubarnos.beans;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fernando on 16/10/17.
 */

public class User {
    private  String username;
    private String password;
    private boolean isLogged;

    public User getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.iteso.PDDM_Sesion13.CACAHUATE",
                Context.MODE_PRIVATE);
        User user = new User();
        user.setUsername(sharedPreferences.getString("USER",null));
        user.setPassword(sharedPreferences.getString("PWD",null));
        user.setLogged(sharedPreferences.getBoolean("LOGGED",false));
        return user;
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
