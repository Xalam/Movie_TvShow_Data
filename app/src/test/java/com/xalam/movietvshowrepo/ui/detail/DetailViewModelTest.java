package com.xalam.movietvshowrepo.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.DataContent;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailViewModel detailViewModel;
    private MoviesEntity dummyMovie = DataContent.generateMovies().get(0);
    private TVShowsEntity dummyTvShow = DataContent.generateTVShows().get(0);
    private String movieId = dummyMovie.getMovieId();
    private String tvShowId = dummyTvShow.getTvId();

    @Mock
    private ContentRepository contentRepository;

    @Mock
    private Observer<Resource<TVShowsEntity>> tvShowsObserver;

    @Mock
    private Observer<Resource<MoviesEntity>> moviesObserver;

    @Before
    public void setUp() {
        detailViewModel = new DetailViewModel(contentRepository);
    }

    @Test
    public void getDetailMovie() {
        detailViewModel.setSelectedContent(movieId);
        Resource<MoviesEntity> moviesEntityResource = Resource.success(DataContent.generateMovies().get(0));
        MutableLiveData<Resource<MoviesEntity>> movieEntity = new MutableLiveData<>();
        movieEntity.setValue(moviesEntityResource);

        when(contentRepository.getMovieId(movieId)).thenReturn(movieEntity);

        detailViewModel.movie.observeForever(moviesObserver);
        verify(moviesObserver).onChanged(moviesEntityResource);
    }

    @Test
    public void getDetailTvShow() {
        detailViewModel.setSelectedContent(tvShowId);
        Resource<TVShowsEntity> tvShowsEntityResource = Resource.success(DataContent.generateTVShows().get(0));
        MutableLiveData<Resource<TVShowsEntity>> tvShowEntity = new MutableLiveData<>();
        tvShowEntity.setValue(tvShowsEntityResource);

        when(contentRepository.getTvShowId(tvShowId)).thenReturn(tvShowEntity);

        detailViewModel.tvShow.observeForever(tvShowsObserver);
        verify(tvShowsObserver).onChanged(tvShowsEntityResource);
    }
}