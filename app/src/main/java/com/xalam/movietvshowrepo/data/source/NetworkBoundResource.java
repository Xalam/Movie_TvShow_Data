package com.xalam.movietvshowrepo.data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.xalam.movietvshowrepo.data.source.remote.ApiResponse;
import com.xalam.movietvshowrepo.utils.AppExecutors;
import com.xalam.movietvshowrepo.vo.Resource;

public abstract class NetworkBoundResource<ResultType, RequestType> {

    private MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    private AppExecutors mExecutors;

    public NetworkBoundResource(AppExecutors appExecutors) {
        this.mExecutors = appExecutors;
        result.setValue(Resource.loading(null));

        LiveData<ResultType> databaseSource = loadFromDatabase();

        result.addSource(databaseSource, data -> {
            result.removeSource(databaseSource);
            if (shouldFetch(data)) {
                fetchFromNetwork(databaseSource);
            } else {
                result.addSource(databaseSource, newData -> result.setValue(Resource.success(newData)));
            }
        });
    }

    protected void onFetchFailed() {
    }

    protected abstract LiveData<ResultType> loadFromDatabase();

    protected abstract boolean shouldFetch(ResultType data);

    protected  abstract LiveData<ApiResponse<RequestType>> createCall();

    protected abstract void saveCallResult(RequestType data);

    private void fetchFromNetwork(LiveData<ResultType> databaseSource) {
        LiveData<ApiResponse<RequestType>> apiResponse = createCall();

        result.addSource(databaseSource, newData -> result.setValue(Resource.loading(newData)));

        result.addSource(apiResponse, response -> {
            result.removeSource(apiResponse);
            result.removeSource(databaseSource);

            switch (response.statusResponse) {
                case SUCCESS:
                    mExecutors.diskIO().execute(() -> {
                        saveCallResult(response.body);

                        mExecutors.mainThread().execute(() -> result.addSource(loadFromDatabase(), newData -> result.setValue(Resource.success(newData))));
                    });
                    break;
                case EMPTY:
                    mExecutors.mainThread().execute(() -> result.addSource(loadFromDatabase(), newData -> result.setValue(Resource.success(newData))));
                    break;
                case ERROR:
                    onFetchFailed();
                    result.addSource(databaseSource, newData -> result.setValue(Resource.error(response.message, newData)));
                    break;
            }
        });
    }

    public LiveData<Resource<ResultType>> asLiveData() {
        return result;
    }
}
