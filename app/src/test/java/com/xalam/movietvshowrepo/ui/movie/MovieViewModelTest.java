package com.xalam.movietvshowrepo.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.vo.Resource;

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
    private Observer<Resource<PagedList<MoviesEntity>>> observer;

    @Mock
    private PagedList<MoviesEntity> pagedList;

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel(contentRepository);
    }

    @Test
    public void getMovies() {
        Resource<PagedList<MoviesEntity>> dummyMovies = Resource.success(pagedList);
        when(dummyMovies.data.size()).thenReturn(11);
        MutableLiveData<Resource<PagedList<MoviesEntity>>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(contentRepository.getAllMovies()).thenReturn(movies);
        List<MoviesEntity> moviesEntities = movieViewModel.getMovies().getValue().data;
        verify(contentRepository).getAllMovies();
        assertNotNull(moviesEntities);
        assertEquals(11, moviesEntities.size());

        movieViewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

}