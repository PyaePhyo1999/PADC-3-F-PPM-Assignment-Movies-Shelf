package com.pyaephyomaung.padcmyanmar.movieshelf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.pyaephyomaung.padcmyanmar.movieshelf.Delegate.MoviesActionDelegate;
import com.pyaephyomaung.padcmyanmar.movieshelf.R;
import com.pyaephyomaung.padcmyanmar.movieshelf.viewholders.GenreViewHolder;
import com.pyaephyomaung.padcmyanmar.movieshelf.viewholders.MovieItemsViewHolder;

/**
 * Created by V3-575G on 21-12-2017.
 */

public class MovieGenreAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View moviegenre = inflater.inflate(R.layout.item_movie_genre,parent,false);
        GenreViewHolder genreViewHolder = new GenreViewHolder(moviegenre);
        return genreViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
