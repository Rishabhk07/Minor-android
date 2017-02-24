package com.example.rishabhkhanna.minor.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by rishabhkhanna on 01/12/16.
 */

public class Notifications {

    public static class notification {
        String name;
        String url;
        String price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public notification(String name, String url, String price) {

            this.name = name;
            this.url = url;
            this.price = price;
        }
    }

    public static final ArrayList<notification> notify = null;


}
