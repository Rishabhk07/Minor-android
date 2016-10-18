package com.example.rishabhkhanna.minor.view.Activities;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.Utils.utils;
import com.example.rishabhkhanna.minor.models.AuthCredits;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;


import org.json.JSONException;
import org.w3c.dom.Text;

public class Signup extends AppCompatActivity {

    Button signupBtn;
    EditText nameET;
    EditText emailEt;
    EditText passwordET;
    TextView loginLink;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    String TAG = "Signup Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupBtn = (Button) findViewById(R.id.signup_btn);
        nameET = (EditText) findViewById(R.id.name_signup);
        emailEt = (EditText) findViewById(R.id.email_signup);
        passwordET = (EditText) findViewById(R.id.password_signup);
        loginLink = (TextView) findViewById(R.id.login_link);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null){
                    Log.d(TAG, "cant sign up now Error" );
                }else{
                    Log.d(TAG , "onAuthStateChanged: " + user.getEmail());
                }

            }
        };
    }

    private void signup() {
        ProgressDialog progressDialog = new ProgressDialog(Signup.this , R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating User...");
        progressDialog.show();
        final String name = nameET.getText().toString();
        final String email = emailEt.getText().toString();
        final String password = passwordET.getText().toString();

        mAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(Signup.this, "Cannot Signup right now !!", Toast.LENGTH_SHORT).show();
                }else{
                    Log.d(TAG , "Signup Completed !!");
                    AuthCredits authCredits = new AuthCredits(name, email , password);
                    Gson gson = new Gson();
                    String signupJson = gson.toJson(authCredits);
                    //server call POST request
                    try {
                        utils.stringrequestPOST(signupJson);
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
