package com.xalam.movietvshowrepo.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;

public class MovieFavoriteViewModel extends ViewModel {
    private ContentRepository contentRepository;

    public MovieFavoriteViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public LiveData<PagedList<MoviesEntity>> getMovieFavorites() {
        return contentRepository.getFavoriteMovies();
    }

    void setMovieFavorite(MoviesEntity moviesEntity) {
        final boolean newState = !moviesEntity.isFavorite();
        contentRepository.setFavoriteMovieStatus(moviesEntity, newState);
    }
}
