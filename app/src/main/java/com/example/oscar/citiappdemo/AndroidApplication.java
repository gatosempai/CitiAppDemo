package com.example.oscar.citiappdemo;

import android.app.Application;

import com.example.oscar.citiappdemo.presentation.injection.components.ApplicationComponent;
import com.example.oscar.citiappdemo.presentation.injection.components.DaggerApplicationComponent;
import com.example.oscar.citiappdemo.presentation.injection.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        //this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    /*private void initializeLeakDetection() {
    if (BuildConfig.DEBUG) {
      LeakCanary.install(this);
    }
  }*/
}