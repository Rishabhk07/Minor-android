package com.example.rishabhkhanna.minor.view.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.Utils.utils;

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
        TextView textView = (TextView) root.findViewById(R.id.profile_name);
        String username = utils.authenticatedCredits.getName();
        textView.setText(username);
        return root;
    }

}
