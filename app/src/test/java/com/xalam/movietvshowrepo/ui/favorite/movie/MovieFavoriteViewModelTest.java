package com.xalam.movietvshowrepo.ui.favorite.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieFavoriteViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private MovieFavoriteViewModel movieFavoriteViewModel;
    @Mock
    private ContentRepository contentRepository;

    @Mock
    private Observer<PagedList<MoviesEntity>> observer;

    @Mock
    private PagedList<MoviesEntity> pagedList;

    @Before
    public void setUp() {
        movieFavoriteViewModel = new MovieFavoriteViewModel(contentRepository);
    }

    @Test
    public void getFavoriteMovie() {
        PagedList<MoviesEntity> dummyMovies = pagedList;
        when(dummyMovies.size()).thenReturn(11);
        MutableLiveData<PagedList<MoviesEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(contentRepository.getFavoriteMovies()).thenReturn(movies);
        List<MoviesEntity> moviesEntities = movieFavoriteViewModel.getMovieFavorites().getValue();
        verify(contentRepository).getFavoriteMovies();
        assertNotNull(moviesEntities);
        assertEquals(11, moviesEntities.size());

        movieFavoriteViewModel.getMovieFavorites().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }
}