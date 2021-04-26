package com.example.shoppingo;

import android.app.Application;
import android.util.Log;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import dagger.hilt.android.HiltAndroidApp;


@HiltAndroidApp
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
