package com.xalam.movietvshowrepo.di;

import android.content.Context;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.local.LocalDataSources;
import com.xalam.movietvshowrepo.data.source.local.room.ContentDatabase;
import com.xalam.movietvshowrepo.data.source.remote.RemoteDataSources;
import com.xalam.movietvshowrepo.utils.AppExecutors;
import com.xalam.movietvshowrepo.utils.JsonHelper;

public class Injection {
    public static ContentRepository provideRepository(Context context) {

        ContentDatabase contentDatabase = ContentDatabase.getInstance(context);

        RemoteDataSources remoteDataSources = RemoteDataSources.getInstance(new JsonHelper(context));
        LocalDataSources localDataSources = LocalDataSources.getInstance(contentDatabase.contentDao());
        AppExecutors appExecutors = new AppExecutors();

        return ContentRepository.getInstance(remoteDataSources, localDataSources, appExecutors);
    }
}
