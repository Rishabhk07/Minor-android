package com.example.rishabhkhanna.minor.view.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.models.Notifications;
import com.example.rishabhkhanna.minor.models.movies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {


    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View root =  inflater.inflate(R.layout.fragment_notification, container, false);

        if(Notifications.notify != null) {

            RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.noti_recycler);

            NotificationRecyclerViewAdapter adapter = new NotificationRecyclerViewAdapter(Notifications.notify);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }



        return root;
    }

    public class NotifiactionRecyclerViewHolder extends RecyclerView.ViewHolder{
        public ImageView notiImage;
        public TextView notiName;
        public TextView notiPrice;

        public NotifiactionRecyclerViewHolder(View itemView) {
            super(itemView);
            notiImage = (ImageView) itemView.findViewById(R.id.notification_img);
            notiName = (TextView) itemView.findViewById(R.id.noti_name);
            notiPrice = (TextView) itemView.findViewById(R.id.price);

        }
    }

    public class NotificationRecyclerViewAdapter extends  RecyclerView.Adapter<NotificationFragment.NotifiactionRecyclerViewHolder>{

        private ArrayList<Notifications.notification> notifications;

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        public NotificationRecyclerViewAdapter(ArrayList<Notifications.notification> notifications) {
            this.notifications = notifications;
        }

        @Override
        public NotificationFragment.NotifiactionRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d("TAG" , "on create view called");

            LayoutInflater li = getLayoutInflater(null);
            View view = li.inflate(R.layout.notification_tupple , null);

            NotifiactionRecyclerViewHolder holder = new NotifiactionRecyclerViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(NotifiactionRecyclerViewHolder holder, int position) {
            Notifications.notification thisNotification = notifications.get(position);

            Picasso.with(getActivity()).load(thisNotification.getUrl()).into(holder.notiImage);
            holder.notiName.setText(thisNotification.getName());
            holder.notiPrice.setText(thisNotification.getPrice());
        }


        @Override
        public int getItemCount() {
            return notifications.size();
        }
    }

}
