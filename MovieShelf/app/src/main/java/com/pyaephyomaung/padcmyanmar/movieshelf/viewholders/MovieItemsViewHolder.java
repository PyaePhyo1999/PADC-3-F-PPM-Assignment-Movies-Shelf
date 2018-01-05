package com.pyaephyomaung.padcmyanmar.movieshelf.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pyaephyomaung.padcmyanmar.movieshelf.Delegate.MoviesActionDelegate;
import com.pyaephyomaung.padcmyanmar.movieshelf.R;
import com.pyaephyomaung.padcmyanmar.movieshelf.data.vo.MoviesVO;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by V3-575G on 09-12-2017.
 */

public class MovieItemsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_movie_poster)
    ImageView ivMoviePoster;
    @BindView(R.id.tv_movie_title)
    TextView tvMovieTitle;
    @BindView(R.id.tv_movie_genre)
    TextView tvMovieGenre;
    @BindView(R.id.tv_current_popularity)
    TextView tvMoviePopularity;
    @BindView(R.id.rb_movie_rating)
    RatingBar rbMovieRating;

    @BindView(R.id.tv_movie_favourite)
    TextView tvMovieFavourite;


    private MoviesActionDelegate mMovieActionDelegate;

    public MovieItemsViewHolder(View itemView, MoviesActionDelegate mMovieActionDelegate) {
        super(itemView);
        this.mMovieActionDelegate = mMovieActionDelegate;
        ButterKnife.bind(this, itemView);
    }


    @OnClick(R.id.cv_movies_item)
    public void onTapItemView(View view) {
        mMovieActionDelegate.onTapItemView();

    }

    public void setMovie(MoviesVO movie) {
        tvMovieTitle.setText(movie.getTitle());

        rbMovieRating.setNumStars(movie.getVoteCount());
        tvMovieFavourite.setText(movie.getVoteAverage().toString());


        if (movie.getPosterPath() != null) {
            ivMoviePoster.setVisibility(View.VISIBLE);

            Glide.with(ivMoviePoster.getContext())
                    .load(movie.getPosterPath())
                    .into(ivMoviePoster);

        } else {
            ivMoviePoster.setVisibility(View.INVISIBLE);
        }


    }
}



