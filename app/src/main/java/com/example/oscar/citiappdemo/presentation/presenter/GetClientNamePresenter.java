package com.example.oscar.citiappdemo.presentation.presenter;

import android.support.annotation.NonNull;

import com.example.oscar.citiappdemo.domain.GetClientName;
import com.example.oscar.citiappdemo.presentation.view.MainActivityView;

import io.reactivex.observers.DefaultObserver;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
//@PerActivity
public class GetClientNamePresenter implements Presenter {

  private MainActivityView mainActivityView;

  private final GetClientName getUserListUseCase;


  public void setView(@NonNull MainActivityView view) {
    this.mainActivityView = view;
  }

  @Override public void resume() {}

  @Override public void pause() {}

  @Override public void destroy() {
    this.getUserListUseCase.dispose();
    this.mainActivityView = null;
  }


  public void getClientName() {
    this.getUserListUseCase.execute(new GetClientNameObserver(), null);
  }

  private final class GetClientNameObserver extends DefaultObserver<String> {

    @Override public void onComplete() {

    }

    @Override public void onError(Throwable e) {

    }

    @Override public void onNext(String initials) {

    }
  }
}