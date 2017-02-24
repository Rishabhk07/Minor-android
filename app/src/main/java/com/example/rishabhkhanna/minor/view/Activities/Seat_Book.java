package com.example.rishabhkhanna.minor.view.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.Services.NotificationService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Seat_Book extends AppCompatActivity {

    public static final String url = "http://192.168.43.164:3000/webview";
    public static final String TAG = "seat book";
    int hallPosition;
    int moviePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat__book);



        Intent i = getIntent();
        hallPosition = i.getIntExtra("hall" , 0);
        moviePosition = i.getIntExtra("movie" , 0);
        String postData = "";

        try {
             postData = "hall="+ URLEncoder.encode(String.valueOf(hallPosition), "UTF-8")+"&movie="+ URLEncoder.encode(String.valueOf(moviePosition ), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        SeatingInfo SeatingInfo = new SeatingInfo(hallPosition, moviePosition);


        Log.d(TAG , hallPosition  + "");
        Log.d(TAG  , moviePosition + "");

        WebView webView = (WebView) findViewById(R.id.seating_webview);

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(SeatingInfo , "seating" );
        Log.d("view" , url);

        webView.postUrl(url ,postData.getBytes());



    }

    class SeatingInfo{
        public  int hall;
        public int movie;
        public SeatingInfo(int hallPosition, int moviePosition) {
            hall = hallPosition;
            movie = moviePosition;
        }

        @android.webkit.JavascriptInterface
        public void info(){
            Log.d("Hello" , "worlds");
        }
    }
}
