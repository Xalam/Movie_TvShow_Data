package com.xalam.movietvshowrepo.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.xalam.movietvshowrepo.data.source.local.LocalDataSources;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.data.source.remote.ApiResponse;
import com.xalam.movietvshowrepo.data.source.remote.RemoteDataSources;
import com.xalam.movietvshowrepo.data.source.remote.response.MoviesResponse;
import com.xalam.movietvshowrepo.data.source.remote.response.TvShowsResponse;
import com.xalam.movietvshowrepo.utils.AppExecutors;
import com.xalam.movietvshowrepo.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class ContentRepository implements ContentDataSource {
    private volatile static ContentRepository INSTANCE = null;
    private final RemoteDataSources remoteDataSource;
    private final LocalDataSources localDataSources;
    private final AppExecutors appExecutors;

    private ContentRepository(@NonNull RemoteDataSources remoteDataSource, @NonNull LocalDataSources localDataSources, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSources = localDataSources;
        this.appExecutors = appExecutors;
    }

    public static ContentRepository getInstance(RemoteDataSources remoteData, LocalDataSources localDataSources, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (ContentRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ContentRepository(remoteData, localDataSources, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<MoviesEntity>>> getAllMovies() {
        return new NetworkBoundResource<List<MoviesEntity>, List<MoviesResponse>>(appExecutors) {

            @Override
            protected LiveData<List<MoviesEntity>> loadFromDatabase() {
                return localDataSources.getAllMovies();
            }

            @Override
            protected boolean shouldFetch(List<MoviesEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MoviesResponse>>> createCall() {
                return remoteDataSource.getAllMovies();
            }

            @Override
            protected void saveCallResult(List<MoviesResponse> data) {
                List<MoviesEntity> moviesEntityList = new ArrayList<>();
                for (MoviesResponse response : data) {
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

                    moviesEntityList.add(moviesEntity);
                }
                localDataSources.insertMovies(moviesEntityList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TVShowsEntity>>> getAllTvShows() {
        return new NetworkBoundResource<List<TVShowsEntity>, List<TvShowsResponse>>(appExecutors) {

            @Override
            protected LiveData<List<TVShowsEntity>> loadFromDatabase() {
                return localDataSources.getAllTvShows();
            }

            @Override
            protected boolean shouldFetch(List<TVShowsEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowsResponse>>> createCall() {
                return remoteDataSource.getAllTvShows();
            }

            @Override
            protected void saveCallResult(List<TvShowsResponse> data) {
                List<TVShowsEntity> tvShowList = new ArrayList<>();
                for (TvShowsResponse response : data) {
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
                localDataSources.insertTvShows(tvShowList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<MoviesEntity>> getMovieId(final String movieId) {
        return new NetworkBoundResource<MoviesEntity, MoviesResponse>(appExecutors) {

            @Override
            protected LiveData<MoviesEntity> loadFromDatabase() {
                return localDataSources.getMoviesId(movieId);
            }

            @Override
            protected boolean shouldFetch(MoviesEntity data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<MoviesResponse>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(MoviesResponse data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TVShowsEntity>> getTvShowId(final String tvId) {
        return new NetworkBoundResource<TVShowsEntity, TvShowsResponse>(appExecutors) {

            @Override
            protected LiveData<TVShowsEntity> loadFromDatabase() {
                return localDataSources.getTvShowsId(tvId);
            }

            @Override
            protected boolean shouldFetch(TVShowsEntity data) {
                return data == null;
            }

            @Override
            protected LiveData<ApiResponse<TvShowsResponse>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(TvShowsResponse data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<List<MoviesEntity>> getFavoriteMovies() {
        return localDataSources.getMoviesFavorite();
    }

    @Override
    public LiveData<List<TVShowsEntity>> getFavoriteTvShows() {
        return localDataSources.getTvShowsFavorite();
    }

    @Override
    public void setFavoriteMovieStatus(MoviesEntity moviesEntity, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSources.setFavoriteMovie(moviesEntity, state));
    }

    @Override
    public void setFavoriteTvShowStatus(TVShowsEntity tvShowsEntity, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSources.setFavoriteTvShow(tvShowsEntity, state));
    }
}

