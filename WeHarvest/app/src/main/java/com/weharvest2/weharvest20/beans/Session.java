package com.weharvest2.weharvest20.beans;

/**
 * Created by carmenmartineznuno on 11/25/17.
 */

public class  Session {
    private static User user;

    public static User getUserSession(){
        return user;
    }

    public static void setUserSession(User userSession){
        user = userSession;
    }
}

