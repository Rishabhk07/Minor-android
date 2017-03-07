package com.example.rishabhkhanna.minor.models;

import java.util.ArrayList;

/**
 * Created by rishabhkhanna on 30/11/16.
 */

public class movies {
    public static class details {
        String name;
        String rating;
        String image_url;
        String cast;

        public details(String name, String rating, String image_url, String cast) {
            this.name = name;
            this.rating = rating;
            this.image_url = image_url;
            this.cast = cast;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getCast() {
            return cast;
        }

        public void setCast(String cast) {
            this.cast = cast;
        }
    }

    public static ArrayList<details> getMovies() {

        ArrayList<details> movies = new ArrayList<>(3);

        movies.add(new details("Dear Zindagi", "84", "https://in.bmscdn.com/iedb/movies/images/mobile/listing/large/dear-zindagi-et00044213-04-10-2016-03-12-36.jpg", "sharukh khan, Aliya BHatt"));
        movies.add(new details("Force 2", "74", "https://in.bmscdn.com/iedb/movies/images/mobile/listing/large/force-2-et00035930-28-09-2016-12-53-10.jpg", "John Abraham, Sonakshi Sinha"));
        movies.add(new details("Ae Dil Hai Mushkil", "76", "https://in.bmscdn.com/iedb/movies/images/mobile/listing/large/ae-dil-hai-mushkil-et00032168-30-08-2016-10-50-16.jpg", "Ranbir Kapoor , Aeshwarya rai Bachan , Anushka sharma"));
        movies.add(new details("Rock on 2", "60", "https://images.bewakoof.com/utter/banner-rock-on-2-teaser-out-why-we-love-it-and-why-we-don-t-1473160450.jpg", "Farhan Akhtar, Shradha Kapoor"));

        return movies;


    }

}
