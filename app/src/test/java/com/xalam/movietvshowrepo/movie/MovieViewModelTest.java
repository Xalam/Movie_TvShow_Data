package com.xalam.movietvshowrepo.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.DataContent;
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
public class MovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private MovieViewModel movieViewModel;
    @Mock
    private ContentRepository contentRepository;

    @Mock
    private Observer<List<MoviesEntity>> observer;

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel(contentRepository);
    }

    @Test
    public void getMovies() {
        List<MoviesEntity> dummyMovies = DataContent.generateMovies();
        MutableLiveData<List<MoviesEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(contentRepository.getAllMovies()).thenReturn(movies);
        List<MoviesEntity> moviesEntities = movieViewModel.getMovies().getValue();
        verify(contentRepository).getAllMovies();
        assertNotNull(moviesEntities);
        assertEquals(11, moviesEntities.size());

        movieViewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

}