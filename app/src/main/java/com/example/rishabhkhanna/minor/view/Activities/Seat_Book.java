package com.example.rishabhkhanna.minor.view.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.Services.NotificationService;


public class Seat_Book extends AppCompatActivity {

    public static final String url = "http://192.168.1.101:3000/webview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat__book);



        Intent i = getIntent();
        int position = i.getIntExtra("position" , 0);

        WebView webView = (WebView) findViewById(R.id.seating_webview);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        Log.d("view" , url);
        webView.loadUrl(url);

        Intent intent = new Intent(Seat_Book.this , NotificationService.class);
        startService(intent);

    }
}
