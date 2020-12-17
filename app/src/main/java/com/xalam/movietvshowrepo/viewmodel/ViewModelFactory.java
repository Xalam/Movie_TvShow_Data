package com.xalam.movietvshowrepo.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.ui.detail.DetailViewModel;
import com.xalam.movietvshowrepo.di.Injection;
import com.xalam.movietvshowrepo.ui.favorite.movie.MovieFavoriteViewModel;
import com.xalam.movietvshowrepo.ui.favorite.tvshow.TvShowFavoriteViewModel;
import com.xalam.movietvshowrepo.ui.movie.MovieViewModel;
import com.xalam.movietvshowrepo.ui.tvshow.TvShowViewModel;


public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final ContentRepository contentRepository;

    public ViewModelFactory(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(contentRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            return (T) new TvShowViewModel(contentRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(contentRepository);
        } else if (modelClass.isAssignableFrom(MovieFavoriteViewModel.class)) {
            return (T) new MovieFavoriteViewModel(contentRepository);
        } else if (modelClass.isAssignableFrom(TvShowFavoriteViewModel.class)) {
            return (T) new TvShowFavoriteViewModel(contentRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
