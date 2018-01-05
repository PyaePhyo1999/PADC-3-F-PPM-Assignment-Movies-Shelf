package com.pyaephyomaung.padcmyanmar.movieshelf.data.models;

import com.pyaephyomaung.padcmyanmar.movieshelf.network.HttpUrlConnectionDataAgent;
import com.pyaephyomaung.padcmyanmar.movieshelf.network.MoviesDataAgent;

/**
 * Created by Acer on 1/4/2018.
 */

public class MoviesModel {
    private static MoviesModel sObjectInstance;
    private MoviesDataAgent mMovieDataAgent;

    private MoviesModel()
    {
           mMovieDataAgent = HttpUrlConnectionDataAgent.getsObjInstance();
    }
    public static MoviesModel getsObjectInstance(){
        if (sObjectInstance == null){
            sObjectInstance = new MoviesModel();
        }
        return sObjectInstance;
    }

    public void loadMovies(){
            mMovieDataAgent.loadMovies();
    }



}
