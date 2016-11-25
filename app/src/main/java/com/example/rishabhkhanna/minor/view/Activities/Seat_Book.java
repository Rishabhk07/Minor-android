package com.example.rishabhkhanna.minor.view.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.rishabhkhanna.minor.R;


public class Seat_Book extends AppCompatActivity {

    public static final String url = "localhost:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat__book);

        Intent i = getIntent();
        int position = i.getIntExtra("position" , 0);

        WebView webView = new WebView(Seat_Book.this);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(url);




    }
}
