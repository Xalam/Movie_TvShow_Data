package com.xalam.movietvshowrepo.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.DataContent;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    private Observer<TVShowsEntity> tvShowsObserver;

    @Mock
    private Observer<MoviesEntity> moviesObserver;

    @Before
    public void setUp() {
        detailViewModel = new DetailViewModel(contentRepository);
    }

    @Test
    public void getMovie() {
        detailViewModel.setSelectedContent(movieId);
        MutableLiveData<MoviesEntity> movie = new MutableLiveData<>();
        movie.setValue(dummyMovie);
        when(contentRepository.getDetailMovies(movieId)).thenReturn(movie);
        MoviesEntity moviesEntity = detailViewModel.getMovie().getValue();
        verify(contentRepository).getDetailMovies(movieId);
        assertNotNull(moviesEntity);
        assertEquals(dummyMovie.getMovieId(), moviesEntity.getMovieId());
        assertEquals(dummyMovie.getDate(), moviesEntity.getDate());
        assertEquals(dummyMovie.getCategory(), moviesEntity.getCategory());
        assertEquals(dummyMovie.getDuration(), moviesEntity.getDuration());
        assertEquals(dummyMovie.getUserScore(), moviesEntity.getUserScore());
        assertEquals(dummyMovie.getImagePath(), moviesEntity.getImagePath());
        assertEquals(dummyMovie.getGenre(), moviesEntity.getGenre());
        assertEquals(dummyMovie.getTitle(), moviesEntity.getTitle());
        assertEquals(dummyMovie.getDescription(), moviesEntity.getDescription());
        assertEquals(dummyMovie.getYear(), moviesEntity.getYear());

        detailViewModel.getMovie().observeForever(moviesObserver);
        verify(moviesObserver).onChanged(dummyMovie);
    }

    @Test
    public void getTvShows() {
        detailViewModel.setSelectedContent(tvShowId);
        MutableLiveData<TVShowsEntity> tvShow = new MutableLiveData<>();
        tvShow.setValue(dummyTvShow);
        when(contentRepository.getDetailTvShows(tvShowId)).thenReturn(tvShow);
        TVShowsEntity tvShowsEntity = detailViewModel.getTvShow().getValue();
        verify(contentRepository).getDetailTvShows(tvShowId);
        assertNotNull(tvShowsEntity);
        assertEquals(dummyTvShow.getTvId(), tvShowsEntity.getTvId());
        assertEquals(dummyTvShow.getDate(), tvShowsEntity.getDate());
        assertEquals(dummyTvShow.getCategory(), tvShowsEntity.getCategory());
        assertEquals(dummyTvShow.getDuration(), tvShowsEntity.getDuration());
        assertEquals(dummyTvShow.getUserScore(), tvShowsEntity.getUserScore());
        assertEquals(dummyTvShow.getImagePath(), tvShowsEntity.getImagePath());
        assertEquals(dummyTvShow.getGenre(), tvShowsEntity.getGenre());
        assertEquals(dummyTvShow.getTitle(), tvShowsEntity.getTitle());
        assertEquals(dummyTvShow.getDescription(), tvShowsEntity.getDescription());
        assertEquals(dummyTvShow.getYear(), tvShowsEntity.getYear());

        detailViewModel.getTvShow().observeForever(tvShowsObserver);
        verify(tvShowsObserver).onChanged(dummyTvShow);
    }
}