package com.xalam.movietvshowrepo.ui.favorite.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;

import java.util.List;

public class TvShowFavoriteViewModel extends ViewModel {
    private ContentRepository contentRepository;

    public TvShowFavoriteViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public LiveData<List<TVShowsEntity>> getTvShowFavorites() {
        return contentRepository.getFavoriteTvShows();
    }
}
