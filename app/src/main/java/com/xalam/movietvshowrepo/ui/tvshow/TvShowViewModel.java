package com.xalam.movietvshowrepo.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private ContentRepository contentRepository;

    public TvShowViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public LiveData<List<TVShowsEntity>> getTvShows() {
        return contentRepository.getAllTvShows();
    }
}
