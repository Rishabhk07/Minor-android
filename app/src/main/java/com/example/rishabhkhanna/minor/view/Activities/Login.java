package com.example.rishabhkhanna.minor.view.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.Utils.utils;
import com.example.rishabhkhanna.minor.models.AuthCredits;
import com.example.rishabhkhanna.minor.models.emailObject;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import org.json.JSONException;

public class Login extends AppCompatActivity {

    Button login;
    EditText emailET;
    EditText passwordET;
    TextView signup_linkTV;
    String TAG = "Login Activity";
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login_btn);
        emailET = (EditText) findViewById(R.id.email_login);
        passwordET = (EditText) findViewById(R.id.password_login);
        signup_linkTV = (TextView) findViewById(R.id.signup_link);

        mAuth = FirebaseAuth.getInstance();

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    Log.d(TAG, "cant Login");
                    Toast.makeText(Login.this, "Cant login in firebase", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d(TAG, "onAuthStateChanged: " + user.getEmail().toString());

                }

            }
        };


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        signup_linkTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void Login() {
        final ProgressDialog progressDialog = new ProgressDialog(Login.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {
                    Toast.makeText(Login.this, "Cannot Login right now !!", Toast.LENGTH_SHORT).show();
                } else {
                    //make network request to fetch
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    RequestQueue que = Volley.newRequestQueue(Login.this);
                    try {
                        //Gson for making email as a JSON object
                        Gson gson = new Gson();
                        emailObject email = new emailObject(user.getEmail().toString());
                        String emailJson = gson.toJson(email);
                        que.add(utils.stringrequestPOSTgetUser(emailJson, new utils.serverCallback() {
                            // server call  back to be implemented after network call
                            @Override
                            public void onSuccess(AuthCredits authCredits) {
                                Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Login.this, User.class);
                                progressDialog.dismiss();
                                startActivity(i);

                            }


                        }, Login.this));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListner);
    }
}
