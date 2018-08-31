package com.example.oscar.citiappdemo.presentation.injection.components;

import android.content.Context;

import com.example.oscar.citiappdemo.domain.PostExecutionThread;
import com.example.oscar.citiappdemo.domain.ThreadExecutor;
import com.example.oscar.citiappdemo.presentation.injection.modules.ApplicationModule;
import com.example.oscar.citiappdemo.presentation.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
}