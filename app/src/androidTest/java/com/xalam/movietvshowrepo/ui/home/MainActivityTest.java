package com.xalam.movietvshowrepo.ui.home;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.data.source.DataContent;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    private List<MoviesEntity> dummyMovie = DataContent.generateMovies();
    private List<TVShowsEntity> dummyTvShow = DataContent.generateTVShows();

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadTvShow() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(0));
        onView(withId(R.id.menu_tv_show)).perform(click());
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition(dummyTvShow.size()));
    }

    @Test
    public void loadDetailMovies() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(withText(String.format("%s (%s)", dummyMovie.get(0).getTitle(), dummyMovie.get(0).getYear()))));
        onView(withId(R.id.tv_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date_detail)).check(matches(withText(dummyMovie.get(0).getDate())));
        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyMovie.get(0).getGenre())));
        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyMovie.get(0).getDuration())));
        onView(withId(R.id.tv_score_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_score_detail)).check(matches(withText(dummyMovie.get(0).getUserScore())));
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyMovie.get(0).getDescription())));
    }

    @Test
    public void loadDetailTvShows() {
        onView(withId(R.id.menu_tv_show)).perform(click());
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title_detail)).check(matches(withText(String.format("%s (%s)", dummyTvShow.get(0).getTitle(), dummyTvShow.get(0).getYear()))));
        onView(withId(R.id.tv_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date_detail)).check(matches(withText(dummyTvShow.get(0).getDate())));
        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyTvShow.get(0).getGenre())));
        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyTvShow.get(0).getDuration())));
        onView(withId(R.id.tv_score_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_score_detail)).check(matches(withText(dummyTvShow.get(0).getUserScore())));
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyTvShow.get(0).getDescription())));
    }

    @Test
    public void loadFavoriteMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.btn_fav_detail)).perform(click());
        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.menu_favorite)).perform(click());
        onView(withId(R.id.rv_movie_favorite)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title_detail)).check(matches(withText(String.format("%s (%s)", dummyMovie.get(0).getTitle(), dummyMovie.get(0).getYear()))));
        onView(withId(R.id.tv_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date_detail)).check(matches(withText(dummyMovie.get(0).getDate())));
        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyMovie.get(0).getGenre())));
        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyMovie.get(0).getDuration())));
        onView(withId(R.id.tv_score_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_score_detail)).check(matches(withText(dummyMovie.get(0).getUserScore())));
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyMovie.get(0).getDescription())));
        onView(withId(R.id.btn_fav_detail)).perform(click());
        onView(isRoot()).perform(pressBack());
    }

    @Test
    public void loadFavoriteTvShow() {
        onView(withId(R.id.menu_tv_show)).perform(click());
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.btn_fav_detail)).perform(click());
        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.menu_favorite)).perform(click());
        onView(withText("TV SHOWS")).perform(click());
        onView(withId(R.id.rv_tv_show_favorite)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_show_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title_detail)).check(matches(withText(String.format("%s (%s)", dummyTvShow.get(0).getTitle(), dummyTvShow.get(0).getYear()))));
        onView(withId(R.id.tv_date_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date_detail)).check(matches(withText(dummyTvShow.get(0).getDate())));
        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyTvShow.get(0).getGenre())));
        onView(withId(R.id.tv_duration_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_duration_detail)).check(matches(withText(dummyTvShow.get(0).getDuration())));
        onView(withId(R.id.tv_score_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_score_detail)).check(matches(withText(dummyTvShow.get(0).getUserScore())));
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyTvShow.get(0).getDescription())));
        onView(withId(R.id.btn_fav_detail)).perform(click());
        onView(isRoot()).perform(pressBack());
    }
}