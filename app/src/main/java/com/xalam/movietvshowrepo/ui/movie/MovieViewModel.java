package com.xalam.movietvshowrepo.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private ContentRepository contentRepository;

    public MovieViewModel(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public LiveData<List<MoviesEntity>> getMovies() {
        return contentRepository.getAllMovies();
    }
}
