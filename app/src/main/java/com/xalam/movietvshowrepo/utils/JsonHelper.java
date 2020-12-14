package com.xalam.movietvshowrepo.utils;

import android.content.Context;
import android.content.res.Resources;

import com.xalam.movietvshowrepo.data.source.remote.response.MoviesResponse;
import com.xalam.movietvshowrepo.data.source.remote.response.TvShowsResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Context context;

    public JsonHelper(Context context) {
        this.context = context;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private String parsingFileToString(String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<MoviesResponse> loadMovies() {
        ArrayList<MoviesResponse> listMovies = new ArrayList<>();
        try {
            String json = parsingFileToString("MoviesResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("movies");
                Resources resources = context.getResources();
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject movies = listArray.getJSONObject(i);

                    String movieId = movies.getString("id");
                    String title = movies.getString("title");
                    String year = movies.getString("year");
                    String date = movies.getString("date");
                    String genre = movies.getString("genre");
                    String duration = movies.getString("duration");
                    String imagePath = movies.getString("imagePath");
                    int resourceImage = resources.getIdentifier(imagePath, "drawable", context.getPackageName());
                    String userScore = movies.getString("userScore");
                    String description = movies.getString("description");
                    String category = movies.getString("category");

                    MoviesResponse moviesResponse = new MoviesResponse(movieId, title, year, date, genre, duration, resourceImage, userScore, description, category);
                    listMovies.add(moviesResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listMovies;
    }

    public List<TvShowsResponse> loadTvShows() {
        ArrayList<TvShowsResponse> listTvShows = new ArrayList<>();
        try {
            String json = parsingFileToString("TvShowsResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("tv_shows");
                Resources resources = context.getResources();
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject tvShows = listArray.getJSONObject(i);

                    String tvId = tvShows.getString("id");
                    String title = tvShows.getString("title");
                    String year = tvShows.getString("year");
                    String date = tvShows.getString("date");
                    String genre = tvShows.getString("genre");
                    String duration = tvShows.getString("duration");
                    String imagePath = tvShows.getString("imagePath");
                    int resourceImage = resources.getIdentifier(imagePath, "drawable", context.getPackageName());
                    String userScore = tvShows.getString("userScore");
                    String description = tvShows.getString("description");
                    String category = tvShows.getString("category");

                    TvShowsResponse tvShowsResponse = new TvShowsResponse(tvId, title, year, date, genre, duration, resourceImage, userScore, description, category);
                    listTvShows.add(tvShowsResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listTvShows;
    }
}
