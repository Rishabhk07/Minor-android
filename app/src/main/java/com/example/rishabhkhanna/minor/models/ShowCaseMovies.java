package com.example.rishabhkhanna.minor.models;

/**
 * Created by rishabhkhanna on 13/11/16.
 */

public class ShowCaseMovies {

    String name;
    String imageUrl;

    public ShowCaseMovies(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
