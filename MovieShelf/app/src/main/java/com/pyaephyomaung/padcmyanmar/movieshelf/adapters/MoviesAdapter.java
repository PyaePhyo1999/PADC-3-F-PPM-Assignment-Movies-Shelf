package com.pyaephyomaung.padcmyanmar.movieshelf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pyaephyomaung.padcmyanmar.movieshelf.Delegate.MoviesActionDelegate;
import com.pyaephyomaung.padcmyanmar.movieshelf.R;
import com.pyaephyomaung.padcmyanmar.movieshelf.data.vo.MoviesVO;
import com.pyaephyomaung.padcmyanmar.movieshelf.viewholders.MovieItemsViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by V3-575G on 09-12-2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MovieItemsViewHolder> {

    public MoviesActionDelegate mMoviesActionDelegate;

    private List<MoviesVO> mMoviesList;

    public  MoviesAdapter(MoviesActionDelegate moviesActionDelegate){
        mMoviesActionDelegate = moviesActionDelegate;
        mMoviesList = new ArrayList<>();
    }

    @Override
    public MovieItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater =  LayoutInflater.from(context);
        View MovieItemsView = inflater.inflate(R.layout.item_movies,parent,false);
        MovieItemsViewHolder MovieItemViewHolder = new MovieItemsViewHolder(MovieItemsView,mMoviesActionDelegate);
        return MovieItemViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieItemsViewHolder holder, int position) {
        holder.setMovie(mMoviesList.get(position));
    }


    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    public void setMovies(List<MoviesVO> moviesList){
        mMoviesList = moviesList;
        notifyDataSetChanged();
    }
}
