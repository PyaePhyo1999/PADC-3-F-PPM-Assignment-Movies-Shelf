package com.pyaephyomaung.padcmyanmar.movieshelf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pyaephyomaung.padcmyanmar.movieshelf.Delegate.MoviesActionDelegate;
import com.pyaephyomaung.padcmyanmar.movieshelf.R;
import com.pyaephyomaung.padcmyanmar.movieshelf.viewholders.MovieDetailItemsViewHolder;

/**
 * Created by V3-575G on 15-12-2017.
 */

public class TrailersAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items_movie_trailers,parent,false);
        MovieDetailItemsViewHolder movieDetailItemsViewHolder = new MovieDetailItemsViewHolder(view);
        return movieDetailItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
