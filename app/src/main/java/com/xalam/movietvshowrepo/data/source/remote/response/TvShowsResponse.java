package com.xalam.movietvshowrepo.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowsResponse implements Parcelable {
    public static final Creator<TvShowsResponse> CREATOR = new Creator<TvShowsResponse>() {
        @Override
        public TvShowsResponse createFromParcel(Parcel in) {
            return new TvShowsResponse(in);
        }

        @Override
        public TvShowsResponse[] newArray(int size) {
            return new TvShowsResponse[size];
        }
    };
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

    public TvShowsResponse(String tvId, String title, String year, String date, String genre, String duration, int imagePath, String userScore, String description, String category) {
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

    protected TvShowsResponse(Parcel in) {
        tvId = in.readString();
        title = in.readString();
        year = in.readString();
        date = in.readString();
        genre = in.readString();
        duration = in.readString();
        imagePath = in.readInt();
        userScore = in.readString();
        description = in.readString();
        category = in.readString();
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String movieId) {
        this.tvId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tvId);
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(date);
        dest.writeString(genre);
        dest.writeString(duration);
        dest.writeInt(imagePath);
        dest.writeString(userScore);
        dest.writeString(description);
        dest.writeString(category);
    }
}
