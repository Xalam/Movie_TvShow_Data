package com.xalam.movietvshowrepo.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;

@Database(entities = {MoviesEntity.class, TVShowsEntity.class},
        version = 1,
        exportSchema = false)
public abstract class ContentDatabase extends RoomDatabase {
    public abstract ContentDao contentDao();

    private static volatile ContentDatabase INSTANCE;

    public static ContentDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ContentDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ContentDatabase.class, "MoviesTvShows.db")
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
