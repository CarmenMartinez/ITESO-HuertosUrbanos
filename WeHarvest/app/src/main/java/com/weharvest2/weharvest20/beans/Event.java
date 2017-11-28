package com.weharvest2.weharvest20.beans;

/**
 * Created by carmenmartineznuno on 11/26/17.
 */

public class Event {
    private String username;
    private String title;
    private String description;
    private String date;
    private String place;

    public Event(){

    }

    public Event(String username, String title, String description, String date, String place){
        setUsername(username);
        setTitle(title);
        setDescription(description);
        setDate(date);
        setPlace(place);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
