package com.example.rishabhkhanna.minor.view.Fragments;


import android.graphics.Movie;
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
import com.example.rishabhkhanna.minor.models.ShowCaseMovies;
import com.example.rishabhkhanna.minor.models.movies;
import com.google.firebase.iid.FirebaseInstanceId;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowcaseFragment extends Fragment {


    public ShowcaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_showcase, container, false);

        ArrayList<movies.details> arrayList = movies.getMovies();


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_showcase);

        ShowcaseRecyclerViewAdapter showcaseRecyclerViewAdapter = new ShowcaseRecyclerViewAdapter(arrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(showcaseRecyclerViewAdapter);

        showcaseRecyclerViewAdapter.notifyDataSetChanged();

        Log.d("reg token:", FirebaseInstanceId.getInstance().getToken());


        return view;
    }


    public class ShowcaseRecyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView showcaseImage;
        public TextView showcaseText;

        public ShowcaseRecyclerViewHolder(View itemView) {
            super(itemView);
            showcaseImage = (ImageView) itemView.findViewById(R.id.showcase_image);
            showcaseText = (TextView) itemView.findViewById(R.id.showcase_text);
        }
    }

    public class ShowcaseRecyclerViewAdapter extends RecyclerView.Adapter<ShowcaseRecyclerViewHolder> {

        private ArrayList<movies.details> scrapMovies;

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        public ShowcaseRecyclerViewAdapter(ArrayList<movies.details> scrapMovies) {
            this.scrapMovies = scrapMovies;
        }

        @Override
        public ShowcaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d("TAG", "on create view called");

            LayoutInflater li = getLayoutInflater(null);
            View view = li.inflate(R.layout.showcase_tupple, null);

            ShowcaseRecyclerViewHolder showcaseRecyclerViewHolder = new ShowcaseRecyclerViewHolder(view);
            return showcaseRecyclerViewHolder;
        }

        @Override
        public void onBindViewHolder(ShowcaseRecyclerViewHolder holder, int position) {

            movies.details thisMovie = scrapMovies.get(position);

            holder.showcaseText.setText(thisMovie.getName());
//            holder.showcaseImage.
            Picasso.with(getActivity()).load(thisMovie.getImage_url()).into(holder.showcaseImage);

        }

        @Override
        public int getItemCount() {
            return scrapMovies.size();
        }
    }

}
