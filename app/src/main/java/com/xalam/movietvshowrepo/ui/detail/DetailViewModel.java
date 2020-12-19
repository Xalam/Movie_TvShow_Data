package com.xalam.movietvshowrepo.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.vo.Resource;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<String> contentId = new MutableLiveData<>();
    private ContentRepository contentRepository;
    public LiveData<Resource<MoviesEntity>> movie = Transformations.switchMap(contentId, mContentId -> contentRepository.getMovieId(getMovieId()));
    public LiveData<Resource<TVShowsEntity>> tvShow = Transformations.switchMap(contentId, mContentId -> contentRepository.getTvShowId(getTvShowId()));

    public DetailViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public void setSelectedContent(String contentId) {
        this.contentId.setValue(contentId);
    }

    public String getMovieId() {
        return this.contentId.getValue();
    }

    public String getTvShowId() {
        return this.contentId.getValue();
    }

    void setMovieFavorite() {
        if (movie.getValue() != null) {
            MoviesEntity moviesEntity = movie.getValue().data;
            final boolean newState = !moviesEntity.isFavorite();
            contentRepository.setFavoriteMovieStatus(moviesEntity, newState);
        }
    }

    void setTvShowFavorite() {
        if (tvShow.getValue() != null) {
            TVShowsEntity tvShowsEntity = tvShow.getValue().data;
            final boolean newState = !tvShowsEntity.isFavorite();
            contentRepository.setFavoriteTvShowStatus(tvShowsEntity, newState);
        }
    }
}
