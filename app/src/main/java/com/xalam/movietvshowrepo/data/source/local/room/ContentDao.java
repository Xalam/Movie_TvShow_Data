package com.xalam.movietvshowrepo.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;

import java.util.List;

@Dao
public interface ContentDao {

    @Query("SELECT * FROM movies_entity")
    DataSource.Factory<Integer, MoviesEntity> getAllMovies();

    @Query("SELECT * FROM tv_shows_entity")
    DataSource.Factory<Integer, TVShowsEntity> getAllTvShows();

    @Query("SELECT * FROM movies_entity WHERE movieId = :id")
    LiveData<MoviesEntity> getMoviesId(String id);

    @Query("SELECT * FROM tv_shows_entity WHERE tvId = :id")
    LiveData<TVShowsEntity> getTvShowsId(String id);

    @Query("SELECT * FROM movies_entity WHERE favorite = 1")
    DataSource.Factory<Integer, MoviesEntity> getMoviesFavorite();

    @Query("SELECT * FROM tv_shows_entity WHERE favorite = 1")
    DataSource.Factory<Integer, TVShowsEntity> getTvShowsFavorite();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(List<MoviesEntity> moviesEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShows(List<TVShowsEntity> tvShowsEntities);

    @Update
    void updateMovies(MoviesEntity moviesEntity);

    @Update
    void updateTvShows(TVShowsEntity tvShowsEntity);

}
