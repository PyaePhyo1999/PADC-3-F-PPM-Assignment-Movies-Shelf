package com.pyaephyomaung.padcmyanmar.movieshelf.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toolbar;

import com.pyaephyomaung.padcmyanmar.movieshelf.R;
import com.pyaephyomaung.padcmyanmar.movieshelf.adapters.MovieGenreAdapter;
import com.pyaephyomaung.padcmyanmar.movieshelf.adapters.TrailersAdapter;

import java.util.concurrent.ThreadPoolExecutor;

import javax.crypto.spec.RC2ParameterSpec;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by V3-575G on 14-12-2017.
 */

public class MovieDetailsActivity extends AppCompatActivity {
    @BindView(R.id.rv_movie_trailer)
    RecyclerView rvMovieTrailer;
    @BindView(R.id.rv_genre)
    RecyclerView rvGenre;
    private TrailersAdapter mTrailersAdapter;
    private MovieGenreAdapter mMovieGenreAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_movie_details);
        ButterKnife.bind(this,this);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        mTrailersAdapter = new TrailersAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvMovieTrailer.setAdapter(mTrailersAdapter);
        rvMovieTrailer.setLayoutManager(linearLayoutManager);

        mMovieGenreAdapter = new MovieGenreAdapter();
        LinearLayoutManager linearLayoutManagerForGenre = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvGenre.setLayoutManager(linearLayoutManagerForGenre);
        rvGenre.setAdapter(mMovieGenreAdapter);

    }
}
