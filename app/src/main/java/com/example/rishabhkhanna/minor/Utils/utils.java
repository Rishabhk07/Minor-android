package com.example.rishabhkhanna.minor.Utils;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rishabhkhanna on 18/10/16.
 */

public class utils {

    public static final String cinemaEndPoint = "http://172.16.97.254:8000/cinema";
    public static final String addUserEndPoint = "http://172.16.97.254:8000/addUser";
    public String TAG = "Utils";

    public void stringGETrequest(String url){
        StringRequest StringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }

    public static final void stringrequestPOST(String jsonAuthData) throws JSONException {

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, addUserEndPoint , new JSONObject(jsonAuthData), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", "user addedsuccesfuly");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }
}
