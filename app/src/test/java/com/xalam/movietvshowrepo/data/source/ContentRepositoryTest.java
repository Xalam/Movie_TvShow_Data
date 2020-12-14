package com.xalam.movietvshowrepo.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.data.source.remote.RemoteDataSources;
import com.xalam.movietvshowrepo.data.source.remote.response.MoviesResponse;
import com.xalam.movietvshowrepo.data.source.remote.response.TvShowsResponse;
import com.xalam.movietvshowrepo.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class ContentRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSources remoteDataSources = Mockito.mock(RemoteDataSources.class);
    private FakeContentRepository contentRepository = new FakeContentRepository(remoteDataSources);

    private List<MoviesResponse> moviesResponses = DataContent.generateRemoteMovies();
    private List<TvShowsResponse> tvShowsResponses = DataContent.generateRemoteTVShows();

    private String movieId = moviesResponses.get(0).getMovieId();
    private String tvShowId = tvShowsResponses.get(0).getTvId();

    @Test
    public void getAllMovies() {
        doAnswer(invocation -> {
            ((RemoteDataSources.LoadMoviesCallback) invocation.getArguments()[0]).onAllMoviesReceived(moviesResponses);
            return null;
        }).when(remoteDataSources).getAllMovies(any(RemoteDataSources.LoadMoviesCallback.class));
        List<MoviesEntity> moviesEntities = LiveDataTestUtil.getValue(contentRepository.getAllMovies());
        verify(remoteDataSources).getAllMovies(any(RemoteDataSources.LoadMoviesCallback.class));
        assertNotNull(moviesEntities);
        assertEquals(moviesResponses.size(), moviesEntities.size());
    }

    @Test
    public void getAllTvShows() {
        doAnswer(invocation -> {
            ((RemoteDataSources.LoadTvShowsCallback) invocation.getArguments()[0]).onAllTvShowsReceived(tvShowsResponses);
            return null;
        }).when(remoteDataSources).getAllTvShows(any(RemoteDataSources.LoadTvShowsCallback.class));
        List<TVShowsEntity> tvShowsEntities = LiveDataTestUtil.getValue(contentRepository.getAllTvShows());
        verify(remoteDataSources).getAllTvShows(any(RemoteDataSources.LoadTvShowsCallback.class));
        assertNotNull(tvShowsEntities);
        assertEquals(tvShowsResponses.size(), tvShowsEntities.size());
    }

    @Test
    public void getDetailMovie() {
        doAnswer(invocation -> {
            ((RemoteDataSources.LoadMoviesCallback) invocation.getArguments()[0]).onAllMoviesReceived(moviesResponses);
            return null;
        }).when(remoteDataSources).getAllMovies(any(RemoteDataSources.LoadMoviesCallback.class));

        MoviesEntity moviesEntity = LiveDataTestUtil.getValue(contentRepository.getDetailMovies(movieId));

        verify(remoteDataSources).getAllMovies(any(RemoteDataSources.LoadMoviesCallback.class));

        assertNotNull(moviesEntity);
        assertEquals(moviesResponses.get(0).getMovieId(), moviesEntity.getMovieId());
        assertEquals(moviesResponses.get(0).getDate(), moviesEntity.getDate());
        assertEquals(moviesResponses.get(0).getCategory(), moviesEntity.getCategory());
        assertEquals(moviesResponses.get(0).getDuration(), moviesEntity.getDuration());
        assertEquals(moviesResponses.get(0).getUserScore(), moviesEntity.getUserScore());
        assertEquals(moviesResponses.get(0).getImagePath(), moviesEntity.getImagePath());
        assertEquals(moviesResponses.get(0).getGenre(), moviesEntity.getGenre());
        assertEquals(moviesResponses.get(0).getTitle(), moviesEntity.getTitle());
        assertEquals(moviesResponses.get(0).getDescription(), moviesEntity.getDescription());
        assertEquals(moviesResponses.get(0).getYear(), moviesEntity.getYear());
    }

    @Test
    public void getDetailTvShow() {
        doAnswer(invocation -> {
            ((RemoteDataSources.LoadTvShowsCallback) invocation.getArguments()[0]).onAllTvShowsReceived(tvShowsResponses);
            return null;
        }).when(remoteDataSources).getAllTvShows(any(RemoteDataSources.LoadTvShowsCallback.class));

        TVShowsEntity tvShowsEntity = LiveDataTestUtil.getValue(contentRepository.getDetailTvShows(tvShowId));

        verify(remoteDataSources).getAllTvShows(any(RemoteDataSources.LoadTvShowsCallback.class));

        assertEquals(tvShowsResponses.get(0).getTvId(), tvShowsEntity.getTvId());
        assertEquals(tvShowsResponses.get(0).getDate(), tvShowsEntity.getDate());
        assertEquals(tvShowsResponses.get(0).getCategory(), tvShowsEntity.getCategory());
        assertEquals(tvShowsResponses.get(0).getDuration(), tvShowsEntity.getDuration());
        assertEquals(tvShowsResponses.get(0).getUserScore(), tvShowsEntity.getUserScore());
        assertEquals(tvShowsResponses.get(0).getImagePath(), tvShowsEntity.getImagePath());
        assertEquals(tvShowsResponses.get(0).getGenre(), tvShowsEntity.getGenre());
        assertEquals(tvShowsResponses.get(0).getTitle(), tvShowsEntity.getTitle());
        assertEquals(tvShowsResponses.get(0).getDescription(), tvShowsEntity.getDescription());
        assertEquals(tvShowsResponses.get(0).getYear(), tvShowsEntity.getYear());
    }
}