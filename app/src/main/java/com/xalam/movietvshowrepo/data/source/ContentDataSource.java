package com.xalam.movietvshowrepo.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.vo.Resource;

public interface ContentDataSource {
    LiveData<Resource<PagedList<MoviesEntity>>> getAllMovies();

    LiveData<Resource<PagedList<TVShowsEntity>>> getAllTvShows();

    LiveData<Resource<MoviesEntity>> getMovieId(String id);

    LiveData<Resource<TVShowsEntity>> getTvShowId(String id);

    LiveData<PagedList<MoviesEntity>> getFavoriteMovies();

    LiveData<PagedList<TVShowsEntity>> getFavoriteTvShows();

    void setFavoriteMovieStatus(MoviesEntity moviesEntity, boolean state);

    void setFavoriteTvShowStatus(TVShowsEntity tvShowsEntity, boolean state);
}
