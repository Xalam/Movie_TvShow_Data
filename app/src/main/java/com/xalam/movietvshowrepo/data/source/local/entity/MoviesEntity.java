package com.xalam.movietvshowrepo.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movies_entity")
public class MoviesEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    private String movieId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "year")
    private String year;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "duration")
    private String duration;

    @ColumnInfo(name = "imagePath")
    private int imagePath;

    @ColumnInfo(name = "userScore")
    private String userScore;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "favorite")
    private boolean favorite = false;

    public MoviesEntity(String movieId, String title, String year, String date, String genre, String duration, int imagePath, String userScore, String description, String category, Boolean favorite) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.date = date;
        this.genre = genre;
        this.duration = duration;
        this.imagePath = imagePath;
        this.userScore = userScore;
        this.description = description;
        this.category = category;
        if (favorite != null) {
            this.favorite = favorite;
        }
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getDate() {
        return date;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public int getImagePath() {
        return imagePath;
    }

    public String getUserScore() {
        return userScore;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
