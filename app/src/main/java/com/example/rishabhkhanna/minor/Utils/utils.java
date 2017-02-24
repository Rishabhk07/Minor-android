package com.example.rishabhkhanna.minor.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.rishabhkhanna.minor.models.AuthCredits;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rishabhkhanna on 18/10/16.
 */

public class utils {

    public static final String cinemaEndPoint = "http://192.168.43.164:3000/cinema";
    public static final String addUserEndPoint = "http://192.168.43.164:3000/addUser";
    public static final String getUserEndPoint = "http://192.168.43.164:3000/getUser";
    public static final String movieTickets = "http://192.168.43.164:3000/getUser";
    public static AuthCredits authenticatedCredits = null;
    public String TAG = "Utils";

    public interface serverCallback{
        void onSuccess(AuthCredits authCredits);
    }

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

    public static final JsonObjectRequest stringrequestPOST(String jsonAuthData, final serverCallback serverCallback , final Context context) throws JSONException {

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, addUserEndPoint , new JSONObject(jsonAuthData), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", "user addedsuccesfuly with response:-" + response );
                Log.d("TAG", "user addedsuccesfuly with response:-" + response );
                try {
                    String email = response.getString("email");
                    String name = response.getString("name");
                    String password = response.getString("password");
//
//                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("email" , email);
//                    editor.putString("name" , name);
//                    editor.commit();

                    Log.d("TAG", "email: " + email );
                    Log.d("TAG", "name: "+ name );
                    Log.d("TAG", "password: " + password );
                    AuthCredits authCredits = new AuthCredits(name , email , password);
                    authenticatedCredits = authCredits;
                    serverCallback.onSuccess(authCredits);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return stringRequest;
    }

    public static final JsonObjectRequest stringrequestPOSTgetUser(String email, final serverCallback serverCallback , Context context) throws JSONException {

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, getUserEndPoint , new JSONObject(email), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
             Log.d("LoginTAG" , "Login wiht" + response);
                String email = null;
                try {
                    email = response.getString("email");
                    String name = response.getString("name");
                    String password = response.getString("password");
                    Log.d("TAG", "email: " + email );
                    Log.d("TAG", "name: "+ name );
                    Log.d("TAG", "password: " + password );

////                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("email" , email);
//                    editor.putString("name" , name);
//                    editor.commit();

                    AuthCredits authCredits = new AuthCredits(name , email , password);
                    authenticatedCredits = authCredits;
                    serverCallback.onSuccess(authCredits);
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return stringRequest;
    }


}
