package com.xalam.movietvshowrepo.data.source.remote;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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

    public LiveData<ApiResponse<List<MoviesResponse>>> getAllMovies() {
        EspressoIdlingResource.idlingIncrement();
        MutableLiveData<ApiResponse<List<MoviesResponse>>> responseMutableLiveData = new MutableLiveData<>();
        handler.postDelayed(() -> {
            responseMutableLiveData.setValue(ApiResponse.success(jsonHelper.loadMovies()));
            EspressoIdlingResource.idlingDecrement();
        }, SERVICE_LATENCY);
        return responseMutableLiveData;
    }

    public LiveData<ApiResponse<List<TvShowsResponse>>> getAllTvShows() {
        EspressoIdlingResource.idlingIncrement();
        MutableLiveData<ApiResponse<List<TvShowsResponse>>> responseMutableLiveData = new MutableLiveData<>();
        handler.postDelayed(() -> {
            responseMutableLiveData.setValue(ApiResponse.success(jsonHelper.loadTvShows()));
            EspressoIdlingResource.idlingDecrement();
        }, SERVICE_LATENCY);
        return responseMutableLiveData;
    }
}
