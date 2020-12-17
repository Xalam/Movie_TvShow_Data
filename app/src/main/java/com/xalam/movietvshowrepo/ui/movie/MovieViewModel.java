package com.xalam.movietvshowrepo.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.vo.Resource;

public class MovieViewModel extends ViewModel {
    private ContentRepository contentRepository;

    public MovieViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public LiveData<Resource<PagedList<MoviesEntity>>> getMovies() {
        return contentRepository.getAllMovies();
    }
}
