package com.pyaephyomaung.padcmyanmar.movieshelf.network.responses;

import com.google.gson.annotations.SerializedName;
import com.pyaephyomaung.padcmyanmar.movieshelf.data.vo.MoviesVO;

import java.util.List;

/**
 * Created by Acer on 1/4/2018.
 */

public class GetMoviesResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    @SerializedName("popular-movies")
    private List<MoviesVO> movies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }
    public List<MoviesVO> getPopularMovies() {
        return movies;
    }
}
