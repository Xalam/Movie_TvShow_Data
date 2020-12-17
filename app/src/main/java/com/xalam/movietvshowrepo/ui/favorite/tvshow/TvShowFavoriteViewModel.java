package com.xalam.movietvshowrepo.ui.favorite.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;

public class TvShowFavoriteViewModel extends ViewModel {
    private ContentRepository contentRepository;

    public TvShowFavoriteViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public LiveData<PagedList<TVShowsEntity>> getTvShowFavorites() {
        return contentRepository.getFavoriteTvShows();
    }

    void setTvShowFavorite(TVShowsEntity tvShowsEntity) {
        final boolean newState = !tvShowsEntity.isFavorite();
        contentRepository.setFavoriteTvShowStatus(tvShowsEntity, newState);
    }
}
