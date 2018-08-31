package com.example.oscar.citiappdemo.presentation.injection.modules;

import android.content.Context;

import com.example.oscar.citiappdemo.AndroidApplication;
import com.example.oscar.citiappdemo.UIThread;
import com.example.oscar.citiappdemo.domain.JobExecutor;
import com.example.oscar.citiappdemo.domain.PostExecutionThread;
import com.example.oscar.citiappdemo.domain.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}