package com.xalam.movietvshowrepo.data.source.local;

import androidx.lifecycle.LiveData;

import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.data.source.local.room.ContentDao;

import java.util.List;

public class LocalDataSources {

    private static LocalDataSources INSTANCE;
    private final ContentDao mContentDao;

    private LocalDataSources(ContentDao contentDao) {
        this.mContentDao = contentDao;
    }

    public static LocalDataSources getInstance(ContentDao contentDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSources(contentDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MoviesEntity>> getAllMovies() {
        return mContentDao.getAllMovies();
    }

    public LiveData<List<TVShowsEntity>> getAllTvShows() {
        return mContentDao.getAllTvShows();
    }

    public LiveData<MoviesEntity> getMoviesId(String id) {
        return mContentDao.getMoviesId(id);
    }

    public LiveData<TVShowsEntity> getTvShowsId(String id) {
        return mContentDao.getTvShowsId(id);
    }

    public LiveData<List<MoviesEntity>> getMoviesFavorite() {
        return mContentDao.getMoviesFavorite();
    }

    public LiveData<List<TVShowsEntity>> getTvShowsFavorite() {
        return mContentDao.getTvShowsFavorite();
    }

    public void insertMovies(List<MoviesEntity> moviesEntities) {
        mContentDao.insertMovies(moviesEntities);
    }

    public void insertTvShows(List<TVShowsEntity> tvShowsEntities) {
        mContentDao.insertTvShows(tvShowsEntities);
    }

    public void setFavoriteMovie(MoviesEntity movie, boolean newState) {
        movie.setFavorite(newState);
        mContentDao.updateMovies(movie);
    }

    public void setFavoriteTvShow(TVShowsEntity tvShow, boolean newState) {
        tvShow.setFavorite(newState);
        mContentDao.updateTvShows(tvShow);
    }
}
