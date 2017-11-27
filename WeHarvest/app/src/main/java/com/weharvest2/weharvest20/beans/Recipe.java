package com.weharvest2.weharvest20.beans;

/**
 * Created by fernando on 22/11/17.
 */

public class Recipe {
    private String username;
    private String title;
    private String description;
    private String date;
    private String category;

    public Recipe() {

    }

    public Recipe(String username, String title, String description, String date, String category) {
        this.username = username;
        this.title = title;
        this.description = description;
        this.date = date;
        this.category = category;
    }


    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getRecipeTitle() {
        return title;
    }

    public void setTitle(String titulo) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
