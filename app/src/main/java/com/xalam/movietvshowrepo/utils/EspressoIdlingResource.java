package com.xalam.movietvshowrepo.utils;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResource {
    private static final String RESOURCE = "GLOBAL";
    private static CountingIdlingResource countingIdlingResource = new CountingIdlingResource(RESOURCE);

    public static void idlingIncrement() {
        countingIdlingResource.increment();
    }

    public static void idlingDecrement() {
        countingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource() {
        return countingIdlingResource;
    }
}
