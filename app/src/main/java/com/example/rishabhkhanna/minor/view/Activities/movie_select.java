package com.example.rishabhkhanna.minor.view.Activities;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rishabhkhanna.minor.R;
import com.example.rishabhkhanna.minor.models.movies;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class movie_select extends AppCompatActivity {

    int hallPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_select);

        hallPosition = getIntent().getIntExtra("position", 0);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_movies_recycler);
        selectRecyclerView adapter = new selectRecyclerView(movies.getMovies());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(movie_select.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }
    class selectViewHolder extends RecyclerView.ViewHolder{

        TextView movie_name;
        TextView rating;
        TextView showTime;
        ImageView movieImage;
        CardView card;

        public selectViewHolder(View itemView) {
            super(itemView);
            movie_name = (TextView) itemView.findViewById(R.id.movie_name);
            rating = (TextView) itemView.findViewById(R.id.adult_rating);
            showTime = (TextView) itemView.findViewById(R.id.show_time);
            movieImage = (ImageView) itemView.findViewById(R.id.movie_book_image);
            card = (CardView) itemView.findViewById(R.id.movie_book_card);
        }
    }

    class selectRecyclerView extends RecyclerView.Adapter<selectViewHolder>{

        ArrayList<movies.details> mList;

        public selectRecyclerView(ArrayList<movies.details> list) {
            mList = list;
        }

        @Override
        public selectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li  = getLayoutInflater();
            View view = li.inflate(R.layout.movie_select_tupple , null);

            selectViewHolder viewHolder = new selectViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(selectViewHolder holder, final int position) {

            movies.details thisMovie = mList.get(position);

            holder.movie_name.setText(thisMovie.getName());
            holder.rating.setText(thisMovie.getRating());
            Picasso.with(movie_select.this).load(thisMovie.getImage_url()).into(holder.movieImage);
            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(movie_select.this , Seat_Book.class);
                    i.putExtra("hall" , hallPosition );
                    i.putExtra("movie" , position);
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}


