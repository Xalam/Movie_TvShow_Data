package com.xalam.movietvshowrepo.data.source;

import androidx.lifecycle.LiveData;

import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.vo.Resource;

import java.util.List;

public interface ContentDataSource {
    LiveData<Resource<List<MoviesEntity>>> getAllMovies();

    LiveData<Resource<List<TVShowsEntity>>> getAllTvShows();

    LiveData<Resource<MoviesEntity>> getMovieId(String id);

    LiveData<Resource<TVShowsEntity>> getTvShowId(String id);

    LiveData<List<MoviesEntity>>  getFavoriteMovies();

    LiveData<List<TVShowsEntity>> getFavoriteTvShows();

    void setFavoriteMovieStatus(MoviesEntity moviesEntity, boolean state);

    void setFavoriteTvShowStatus(TVShowsEntity tvShowsEntity, boolean state);
}
