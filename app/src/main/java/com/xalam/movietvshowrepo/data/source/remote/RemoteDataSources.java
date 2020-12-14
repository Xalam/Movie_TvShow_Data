package com.xalam.movietvshowrepo.data.source.remote;

import android.os.Handler;

import com.xalam.movietvshowrepo.data.source.remote.response.MoviesResponse;
import com.xalam.movietvshowrepo.data.source.remote.response.TvShowsResponse;
import com.xalam.movietvshowrepo.utils.EspressoIdlingResource;
import com.xalam.movietvshowrepo.utils.JsonHelper;

import java.util.List;


public class RemoteDataSources {
    private static RemoteDataSources INSTANCE;
    private final long SERVICE_LATENCY = 2000;
    private JsonHelper jsonHelper;
    private Handler handler = new Handler();

    private RemoteDataSources(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSources getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSources(helper);
        }
        return INSTANCE;
    }

    public void getAllMovies(LoadMoviesCallback callback) {
        EspressoIdlingResource.idlingIncrement();
        handler.postDelayed(() -> {
            callback.onAllMoviesReceived(jsonHelper.loadMovies());
            EspressoIdlingResource.idlingDecrement();
        }, SERVICE_LATENCY);
    }

    public void getAllTvShows(LoadTvShowsCallback callback) {
        EspressoIdlingResource.idlingIncrement();
        handler.postDelayed(() -> {
            callback.onAllTvShowsReceived(jsonHelper.loadTvShows());
            EspressoIdlingResource.idlingDecrement();
        }, SERVICE_LATENCY);
    }

    public interface LoadMoviesCallback {
        void onAllMoviesReceived(List<MoviesResponse> moviesResponses);
    }

    public interface LoadTvShowsCallback {
        void onAllTvShowsReceived(List<TvShowsResponse> tvShowsResponses);
    }
}
