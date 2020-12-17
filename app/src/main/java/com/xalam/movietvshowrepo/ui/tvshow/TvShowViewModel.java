package com.xalam.movietvshowrepo.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.vo.Resource;

public class TvShowViewModel extends ViewModel {
    private ContentRepository contentRepository;

    public TvShowViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public LiveData<Resource<PagedList<TVShowsEntity>>> getTvShows() {
        return contentRepository.getAllTvShows();
    }
}
