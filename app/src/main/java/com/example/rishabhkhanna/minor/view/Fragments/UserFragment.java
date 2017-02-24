package com.example.rishabhkhanna.minor.view.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishabhkhanna.minor.MainActivity;
import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.Utils.utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_user, container, false);


        TextView name= (TextView) root.findViewById(R.id.profile_name);
        TextView emailTV = (TextView) root.findViewById(R.id.profile_email);
        Button btn = (Button) root.findViewById(R.id.logout);

        String username = utils.authenticatedCredits.getName();
        name.setText(username);
        String email = utils.authenticatedCredits.getEmail();
        emailTV.setText(email);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth firebaseUser = FirebaseAuth.getInstance();
                firebaseUser.signOut();
                Toast.makeText(getActivity(), "Signout Successfull", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity() , MainActivity.class);
                startActivity(i);
            }
        });
        return root;
    }

}
