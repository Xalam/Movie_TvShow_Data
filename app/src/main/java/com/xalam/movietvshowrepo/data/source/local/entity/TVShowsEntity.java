package com.xalam.movietvshowrepo.data.source.local.entity;

public class TVShowsEntity {
    private String tvId;
    private String title;
    private String year;
    private String date;
    private String genre;
    private String duration;
    private int imagePath;
    private String userScore;
    private String description;
    private String category;

    public TVShowsEntity(String tvId, String title, String year, String date, String genre, String duration, int imagePath, String userScore, String description, String category) {
        this.tvId = tvId;
        this.title = title;
        this.year = year;
        this.date = date;
        this.genre = genre;
        this.duration = duration;
        this.imagePath = imagePath;
        this.userScore = userScore;
        this.description = description;
        this.category = category;
    }

    public String getTvId() {
        return tvId;
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
}
