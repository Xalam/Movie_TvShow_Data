package com.xalam.movietvshowrepo.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.xalam.movietvshowrepo.data.source.local.LocalDataSources;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.data.source.remote.RemoteDataSources;
import com.xalam.movietvshowrepo.data.source.remote.response.MoviesResponse;
import com.xalam.movietvshowrepo.data.source.remote.response.TvShowsResponse;
import com.xalam.movietvshowrepo.utils.AppExecutors;
import com.xalam.movietvshowrepo.utils.LiveDataTestUtil;
import com.xalam.movietvshowrepo.utils.PagedListUtil;
import com.xalam.movietvshowrepo.vo.Resource;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ContentRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSources remoteDataSources = Mockito.mock(RemoteDataSources.class);
    private LocalDataSources localDataSources = Mockito.mock(LocalDataSources.class);
    private AppExecutors appExecutors = Mockito.mock(AppExecutors.class);
    private FakeContentRepository contentRepository = new FakeContentRepository(remoteDataSources, localDataSources, appExecutors);

    private List<MoviesResponse> moviesResponses = DataContent.generateRemoteMovies();
    private List<TvShowsResponse> tvShowsResponses = DataContent.generateRemoteTVShows();

    private String movieId = moviesResponses.get(0).getMovieId();
    private String tvShowId = tvShowsResponses.get(0).getTvId();

    @Test
    public void getAllMovies() {
        DataSource.Factory<Integer, MoviesEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(localDataSources.getAllMovies()).thenReturn(dataSourceFactory);
        contentRepository.getAllMovies();

        Resource<PagedList<MoviesEntity>> moviesEntities = Resource.success(PagedListUtil.mockPagedList(DataContent.generateMovies()));
        verify(localDataSources).getAllMovies();
        assertNotNull(moviesEntities.data);
        assertEquals(moviesResponses.size(), moviesEntities.data.size());
    }

    @Test
    public void getAllTvShows() {
        DataSource.Factory<Integer, TVShowsEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(localDataSources.getAllTvShows()).thenReturn(dataSourceFactory);
        contentRepository.getAllTvShows();

        Resource<PagedList<TVShowsEntity>> tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataContent.generateTVShows()));
        verify(localDataSources).getAllTvShows();
        assertNotNull(tvShowEntities.data);
        assertEquals(tvShowsResponses.size(), tvShowEntities.data.size());
    }

    @Test
    public void getDetailMovie() {
        MutableLiveData<MoviesEntity> moviesEntity = new MutableLiveData<>();
        moviesEntity.setValue(DataContent.generateMovies().get(0));

        when(localDataSources.getMoviesId(movieId)).thenReturn(moviesEntity);
        Resource<MoviesEntity> moviesEntityResource = LiveDataTestUtil.getValue(contentRepository.getMovieId(movieId));
        verify(localDataSources).getMoviesId(movieId);

        MoviesResponse response = moviesResponses.get(0);
        MoviesEntity result = moviesEntityResource.data;

        assertNotNull(moviesEntity);
        assertEquals(response.getMovieId(), result.getMovieId());
        assertEquals(response.getDate(), result.getDate());
        assertEquals(response.getCategory(), result.getCategory());
        assertEquals(response.getDuration(), result.getDuration());
        assertEquals(response.getUserScore(), result.getUserScore());
        assertEquals(response.getImagePath(), result.getImagePath());
        assertEquals(response.getGenre(), result.getGenre());
        assertEquals(response.getTitle(), result.getTitle());
        assertEquals(response.getDescription(), result.getDescription());
        assertEquals(response.getYear(), result.getYear());
    }

    @Test
    public void getDetailTvShow() {
        MutableLiveData<TVShowsEntity> tvShowsEntity = new MutableLiveData<>();
        tvShowsEntity.setValue(DataContent.generateTVShows().get(0));

        when(localDataSources.getTvShowsId(tvShowId)).thenReturn(tvShowsEntity);
        Resource<TVShowsEntity> tvShowsEntityResource = LiveDataTestUtil.getValue(contentRepository.getTvShowId(tvShowId));
        verify(localDataSources).getTvShowsId(tvShowId);

        TvShowsResponse response = tvShowsResponses.get(0);
        TVShowsEntity result = tvShowsEntityResource.data;

        assertNotNull(tvShowsEntity);
        assertEquals(response.getTvId(), result.getTvId());
        assertEquals(response.getDate(), result.getDate());
        assertEquals(response.getCategory(), result.getCategory());
        assertEquals(response.getDuration(), result.getDuration());
        assertEquals(response.getUserScore(), result.getUserScore());
        assertEquals(response.getImagePath(), result.getImagePath());
        assertEquals(response.getGenre(), result.getGenre());
        assertEquals(response.getTitle(), result.getTitle());
        assertEquals(response.getDescription(), result.getDescription());
        assertEquals(response.getYear(), result.getYear());
    }

    @Test
    public void getFavoriteMovies() {
        DataSource.Factory<Integer, MoviesEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(localDataSources.getMoviesFavorite()).thenReturn(dataSourceFactory);
        contentRepository.getFavoriteMovies();

        Resource<PagedList<MoviesEntity>> moviesEntity = Resource.success(PagedListUtil.mockPagedList(DataContent.generateMovies()));
        verify(localDataSources).getMoviesFavorite();
        assertNotNull(moviesEntity);
        assertEquals(moviesResponses.size(), moviesEntity.data.size());
    }

    @Test
    public void getFavoriteTvShows() {
        DataSource.Factory<Integer, TVShowsEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(localDataSources.getTvShowsFavorite()).thenReturn(dataSourceFactory);
        contentRepository.getFavoriteTvShows();

        Resource<PagedList<TVShowsEntity>> tvShowsEntity = Resource.success(PagedListUtil.mockPagedList(DataContent.generateTVShows()));
        verify(localDataSources).getTvShowsFavorite();
        assertNotNull(tvShowsEntity);
        assertEquals(tvShowsResponses.size(), tvShowsEntity.data.size());
    }
}