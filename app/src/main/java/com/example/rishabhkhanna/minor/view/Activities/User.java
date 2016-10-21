package com.example.rishabhkhanna.minor.view.Activities;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.view.Fragments.ShowcaseFragment;
import com.example.rishabhkhanna.minor.view.Fragments.UserFragment;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);


        //Create Items
        AHBottomNavigationItem showcase = new AHBottomNavigationItem("showcase", R.drawable.ic_bookmark_border_black_24dp, R.color.colorBottomNavigationInactiveColored);
        AHBottomNavigationItem notification = new AHBottomNavigationItem("Notifications", R.drawable.ic_notifications_black_24dp, R.color.colorBottomNavigationPrimaryDark);
        AHBottomNavigationItem nearme = new AHBottomNavigationItem("Near me", R.drawable.ic_add_location_black_24dp, R.color.colorBottomNavigationPrimary);
        AHBottomNavigationItem you = new AHBottomNavigationItem("you", R.drawable.ic_account_circle_black_24dp, R.color.colorBottomNavigationActiveColored);

        //Add Items
        bottomNavigation.addItem(showcase);
        bottomNavigation.addItem(notification);
        bottomNavigation.addItem(nearme);
        bottomNavigation.addItem(you);

        bottomNavigation.setBackgroundColor(Color.parseColor("#FEFEFE"));

        //Fragment initialization
        UserFragment userFragment = new UserFragment();
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout , userFragment , null);
        fragmentTransaction.commit();

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position){
                    case 0:
                        ShowcaseFragment showcaseFragment = new ShowcaseFragment();
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame_layout , showcaseFragment , null);
                        fragmentTransaction1.commit();
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        UserFragment userFragment = new UserFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout , userFragment , null);
                        fragmentTransaction.commit();
                        break;
                }
                return true;
            }
        });


    }
}
