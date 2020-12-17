package com.xalam.movietvshowrepo.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;

import java.util.List;

public class MovieFavoriteViewModel extends ViewModel {
    private ContentRepository contentRepository;

    public MovieFavoriteViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public LiveData<List<MoviesEntity>> getMovieFavorites() {
        return contentRepository.getFavoriteMovies();
    }
}
