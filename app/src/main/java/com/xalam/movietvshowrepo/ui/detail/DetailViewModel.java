package com.xalam.movietvshowrepo.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;

public class DetailViewModel extends ViewModel {
    private String contentId;
    private ContentRepository contentRepository;

    public DetailViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public void setSelectedContent(String contentId) {
        this.contentId = contentId;
    }

    public LiveData<MoviesEntity> getMovie() {
        return contentRepository.getDetailMovies(contentId);
    }

    public LiveData<TVShowsEntity> getTvShow() {
        return contentRepository.getDetailTvShows(contentId);
    }
}
