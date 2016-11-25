package com.example.rishabhkhanna.minor.view.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.models.MovieHalls;
import com.example.rishabhkhanna.minor.view.Activities.Seat_Book;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Book extends Fragment {


    public Book() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_book2, container, false);

        RecyclerView list = (RecyclerView) root.findViewById(R.id.recycler_halls);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        HallRecyclerViewAdapter hallRecyclerViewAdapter  = new HallRecyclerViewAdapter(MovieHalls.getHalls());

        list.setLayoutManager(layoutManager);
        list.setAdapter(hallRecyclerViewAdapter);

        hallRecyclerViewAdapter.notifyDataSetChanged();



        return root;
    }

    public class HallsRecyclerViewHolder extends RecyclerView.ViewHolder{

        public TextView hallName;
        public Button book;


        public HallsRecyclerViewHolder(View itemView) {
            super(itemView);
            hallName = (TextView) itemView.findViewById(R.id.hall_Tv);
            book = (Button) itemView.findViewById(R.id.button_book);
        }
    }

    public class HallRecyclerViewAdapter extends RecyclerView.Adapter<HallsRecyclerViewHolder>{

        public ArrayList<MovieHalls.Halls> list;

        public HallRecyclerViewAdapter(ArrayList list) {
            this.list = list;
        }

        @Override
        public HallsRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater li = getLayoutInflater(null);
            View itemView = li.inflate(R.layout.movie_hall , null);

            HallsRecyclerViewHolder holder = new HallsRecyclerViewHolder(itemView);

            return holder;
        }

        @Override
        public void onBindViewHolder(final HallsRecyclerViewHolder holder, final int position) {
            MovieHalls.Halls thisHall = list.get(position);
            holder.hallName.setText(thisHall.getName());
            holder.book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity() , Seat_Book.class);
                    i.putExtra("position" , position);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

}
