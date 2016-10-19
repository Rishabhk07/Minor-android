package com.example.rishabhkhanna.minor.Utils;

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

    public static final String cinemaEndPoint = "http://172.16.97.254:8000/cinema";
    public static final String addUserEndPoint = "http://192.168.43.164:8000/addUser";
    public static final String getUserEndPoint = "http://192.168.43.164:8000/addUser";
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

    public static final JsonObjectRequest stringrequestPOST(String jsonAuthData, final serverCallback serverCallback) throws JSONException {

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, addUserEndPoint , new JSONObject(jsonAuthData), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("TAG", "user addedsuccesfuly with response:-" + response );
                Log.d("TAG", "user addedsuccesfuly with response:-" + response );
                try {
                    String email = response.getString("email");
                    String name = response.getString("name");
                    String password = response.getString("password");
                    Log.d("TAG", "email: " + email );
                    Log.d("TAG", "name: "+ name );
                    Log.d("TAG", "password: " + password );
                    AuthCredits authCredits = new AuthCredits(name , email , password);
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

    public static final JsonObjectRequest stringrequestPOSTAddUser(String email) throws JSONException {

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, getUserEndPoint , new JSONObject(jsonAuthData), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return stringRequest;
    }
}
