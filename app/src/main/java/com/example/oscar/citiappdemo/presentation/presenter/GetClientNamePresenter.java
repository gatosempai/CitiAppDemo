package com.example.oscar.citiappdemo.presentation.presenter;

import android.support.annotation.NonNull;

import com.example.oscar.citiappdemo.domain.DefaultObserver;
import com.example.oscar.citiappdemo.domain.GetClientName;
import com.example.oscar.citiappdemo.presentation.view.MainActivityView;

import javax.inject.Inject;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
//@PerActivity
public class GetClientNamePresenter implements Presenter {

    private MainActivityView mainActivityView;

    private final GetClientName getClientNameUseCase;

    @Inject
    public GetClientNamePresenter(GetClientName getClientNameUseCase) {
        this.getClientNameUseCase = getClientNameUseCase;
    }

    public void setView(@NonNull MainActivityView view) {
        this.mainActivityView = view;
    }

    @Override public void resume() {}

    @Override public void pause() {}

    @Override public void destroy() {
        this.getClientNameUseCase.dispose();
        this.mainActivityView = null;
    }


    public void getClientName() {
        this.getClientNameUseCase.execute(new GetClientNameObserver(), null);
    }

    private final class GetClientNameObserver extends DefaultObserver<String> {

        @Override public void onComplete() {
            mainActivityView.hideProgress();
        }

        @Override public void onError(Throwable e) {
            mainActivityView.showProgress();
        }

        @Override public void onNext(String initials) {
            mainActivityView.setClientName(initials);
        }
    }
}