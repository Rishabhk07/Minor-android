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

        ArrayList<ShowCaseMovies> arrayList = new ArrayList<>(3);

        arrayList.add(new ShowCaseMovies("Ae dil hai mushkil" , "https://in.bmscdn.com/iedb/movies/images/website/listing/large/ae-dil-hai-mushkil-et00032168-30-08-2016-10-50-16.jpg"));
        arrayList.add(new ShowCaseMovies("Shivaay" , "https://in.bmscdn.com/iedb/movies/images/website/listing/large/et00030790_02-07-2016_12-58-47.jpg"));
        arrayList.add(new ShowCaseMovies("Rock on 2" , "https://in.bmscdn.com/iedb/movies/images/website/listing/large/rock-on-2-et00035915-02-09-2016-12-53-07.jpg"));


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_showcase);

        ShowcaseRecyclerViewAdapter showcaseRecyclerViewAdapter  = new ShowcaseRecyclerViewAdapter(arrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(showcaseRecyclerViewAdapter);

        showcaseRecyclerViewAdapter.notifyDataSetChanged();

        Log.d("reg token:" , FirebaseInstanceId.getInstance().getToken());



        return view;
    }


    public class ShowcaseRecyclerViewHolder extends RecyclerView.ViewHolder{
        public ImageView showcaseImage;
        public TextView showcaseText;

        public ShowcaseRecyclerViewHolder(View itemView) {
            super(itemView);
            showcaseImage = (ImageView) itemView.findViewById(R.id.showcase_image);
            showcaseText  = (TextView) itemView.findViewById(R.id.showcase_text);
        }
    }

    public class ShowcaseRecyclerViewAdapter extends  RecyclerView.Adapter<ShowcaseRecyclerViewHolder>{

        private ArrayList<ShowCaseMovies> scrapMovies;

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        public ShowcaseRecyclerViewAdapter(ArrayList<ShowCaseMovies> scrapMovies) {
                this.scrapMovies = scrapMovies;
        }

        @Override
        public ShowcaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d("TAG" , "on create view called");

            LayoutInflater li = getLayoutInflater(null);
            View view = li.inflate(R.layout.showcase_tupple , null);

            ShowcaseRecyclerViewHolder showcaseRecyclerViewHolder = new ShowcaseRecyclerViewHolder(view);
            return showcaseRecyclerViewHolder;
        }

        @Override
        public void onBindViewHolder(ShowcaseRecyclerViewHolder holder, int position) {

            ShowCaseMovies thisMovie = scrapMovies.get(position);

            holder.showcaseText.setText(thisMovie.getName());
//            holder.showcaseImage.
            Picasso.with(getActivity()).load(thisMovie.getImageUrl()).into(holder.showcaseImage);

        }

        @Override
        public int getItemCount() {
            return scrapMovies.size();
        }
    }

}
