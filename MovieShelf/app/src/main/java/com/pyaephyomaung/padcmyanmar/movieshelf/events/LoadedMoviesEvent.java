package com.pyaephyomaung.padcmyanmar.movieshelf.events;

import com.pyaephyomaung.padcmyanmar.movieshelf.data.vo.MoviesVO;

import java.util.List;

/**
 * Created by Acer on 1/4/2018.
 */

public class LoadedMoviesEvent {

    private List<MoviesVO> moviesList;
    public LoadedMoviesEvent(List<MoviesVO> MoviesList){
        this.moviesList = MoviesList;
    }

    public List<MoviesVO> getMoviesList() {
        return moviesList;
    }
}
