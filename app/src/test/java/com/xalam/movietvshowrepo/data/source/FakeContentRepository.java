package com.xalam.movietvshowrepo.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.data.source.remote.RemoteDataSources;
import com.xalam.movietvshowrepo.data.source.remote.response.MoviesResponse;
import com.xalam.movietvshowrepo.data.source.remote.response.TvShowsResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeContentRepository implements ContentDataSource {
    private final RemoteDataSources remoteDataSource;

    FakeContentRepository(@NonNull RemoteDataSources remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public LiveData<List<MoviesEntity>> getAllMovies() {
        MutableLiveData<List<MoviesEntity>> movieResults = new MutableLiveData<>();
        remoteDataSource.getAllMovies(movieResponses -> {
            List<MoviesEntity> movieList = new ArrayList<>();
            for (MoviesResponse response : movieResponses) {
                MoviesEntity moviesEntity = new MoviesEntity(
                        response.getMovieId(),
                        response.getTitle(),
                        response.getYear(),
                        response.getDate(),
                        response.getGenre(),
                        response.getDuration(),
                        response.getImagePath(),
                        response.getUserScore(),
                        response.getDescription(),
                        response.getCategory());

                movieList.add(moviesEntity);
            }
            movieResults.postValue(movieList);
        });
        return movieResults;
    }

    @Override
    public LiveData<List<TVShowsEntity>> getAllTvShows() {
        final MutableLiveData<List<TVShowsEntity>> tvShowResult = new MutableLiveData<>();
        remoteDataSource.getAllTvShows(tvShowResponses -> {
            List<TVShowsEntity> tvShowList = new ArrayList<>();
            for (TvShowsResponse response : tvShowResponses) {
                TVShowsEntity tvShowsEntity = new TVShowsEntity(
                        response.getTvId(),
                        response.getTitle(),
                        response.getYear(),
                        response.getDate(),
                        response.getGenre(),
                        response.getDuration(),
                        response.getImagePath(),
                        response.getUserScore(),
                        response.getDescription(),
                        response.getCategory());

                tvShowList.add(tvShowsEntity);
            }
            tvShowResult.postValue(tvShowList);
        });
        return tvShowResult;
    }

    public LiveData<MoviesEntity> getDetailMovies(final String movieId) {
        MutableLiveData<MoviesEntity> movieResult = new MutableLiveData<>();

        remoteDataSource.getAllMovies(moviesResponses -> {
            MoviesEntity movies = null;
            for (MoviesResponse response : moviesResponses) {
                if (response.getMovieId().equals(movieId)) {
                    movies = new MoviesEntity(
                            response.getMovieId(),
                            response.getTitle(),
                            response.getYear(),
                            response.getDate(),
                            response.getGenre(),
                            response.getDuration(),
                            response.getImagePath(),
                            response.getUserScore(),
                            response.getDescription(),
                            response.getCategory());
                }
            }
            movieResult.postValue(movies);
        });
        return movieResult;
    }

    public LiveData<TVShowsEntity> getDetailTvShows(final String tvId) {
        MutableLiveData<TVShowsEntity> tvShowsResult = new MutableLiveData<>();

        remoteDataSource.getAllTvShows(tvShowsResponses -> {
            TVShowsEntity tvShows = null;
            for (TvShowsResponse response : tvShowsResponses) {
                if (response.getTvId().equals(tvId)) {
                    tvShows = new TVShowsEntity(
                            response.getTvId(),
                            response.getTitle(),
                            response.getYear(),
                            response.getDate(),
                            response.getGenre(),
                            response.getDuration(),
                            response.getImagePath(),
                            response.getUserScore(),
                            response.getDescription(),
                            response.getCategory());
                }
            }
            tvShowsResult.postValue(tvShows);
        });
        return tvShowsResult;
    }
}

