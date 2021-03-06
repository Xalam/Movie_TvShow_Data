package com.xalam.movietvshowrepo.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
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
public class TvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TvShowViewModel tvShowViewModel;

    @Mock
    private ContentRepository contentRepository;

    @Mock
    private Observer<Resource<PagedList<TVShowsEntity>>> observer;

    @Mock
    private PagedList<TVShowsEntity> pagedList;

    @Before
    public void setUp() {
        tvShowViewModel = new TvShowViewModel(contentRepository);
    }

    @Test
    public void getTvShows() {
        Resource<PagedList<TVShowsEntity>> dummyTvShows = Resource.success(pagedList);
        when(dummyTvShows.data.size()).thenReturn(11);
        MutableLiveData<Resource<PagedList<TVShowsEntity>>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTvShows);

        when(contentRepository.getAllTvShows()).thenReturn(tvShows);
        List<TVShowsEntity> tvShowsEntities = tvShowViewModel.getTvShows().getValue().data;
        verify(contentRepository).getAllTvShows();
        assertNotNull(tvShowsEntities);
        assertEquals(11, tvShowsEntities.size());

        tvShowViewModel.getTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }
}