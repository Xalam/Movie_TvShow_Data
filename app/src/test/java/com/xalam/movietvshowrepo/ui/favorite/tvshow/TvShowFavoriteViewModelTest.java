package com.xalam.movietvshowrepo.ui.favorite.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;

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
public class TvShowFavoriteViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TvShowFavoriteViewModel tvShowFavoriteViewModel;
    @Mock
    private ContentRepository contentRepository;

    @Mock
    private Observer<PagedList<TVShowsEntity>> observer;

    @Mock
    private PagedList<TVShowsEntity> pagedList;

    @Before
    public void setUp() {
        tvShowFavoriteViewModel = new TvShowFavoriteViewModel(contentRepository);
    }

    @Test
    public void getFavoriteMovie() {
        PagedList<TVShowsEntity> dummyTvShows = pagedList;
        when(dummyTvShows.size()).thenReturn(11);
        MutableLiveData<PagedList<TVShowsEntity>> tvShow = new MutableLiveData<>();
        tvShow.setValue(dummyTvShows);

        when(contentRepository.getFavoriteTvShows()).thenReturn(tvShow);
        List<TVShowsEntity> tvShowsEntities = tvShowFavoriteViewModel.getTvShowFavorites().getValue();
        verify(contentRepository).getFavoriteTvShows();
        assertNotNull(tvShowsEntities);
        assertEquals(11, tvShowsEntities.size());

        tvShowFavoriteViewModel.getTvShowFavorites().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }
}