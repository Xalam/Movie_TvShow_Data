package com.xalam.movietvshowrepo.di;

import android.content.Context;

import com.xalam.movietvshowrepo.data.source.ContentRepository;
import com.xalam.movietvshowrepo.data.source.remote.RemoteDataSources;
import com.xalam.movietvshowrepo.utils.JsonHelper;

public class Injection {
    public static ContentRepository provideRepository(Context context) {
        RemoteDataSources remoteDataSources = RemoteDataSources.getInstance(new JsonHelper(context));

        return ContentRepository.getInstance(remoteDataSources);
    }
}
