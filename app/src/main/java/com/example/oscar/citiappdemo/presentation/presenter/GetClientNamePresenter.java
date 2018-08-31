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
public class GetClientNamePresenter implements Presenter {

    private MainActivityView mainActivityView;
    private final GetClientName getClientNameUseCase;

    @Inject
    GetClientNamePresenter(GetClientName getClientNameUseCase) {
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
        mainActivityView.showProgress();
        getClientNameUseCase.execute(new GetClientNameObserver(), "111492822");
    }

    private final class GetClientNameObserver extends DefaultObserver<String> {

        @Override
        public void onSuccess(String initials) {
            mainActivityView.setClientName(initials);
            mainActivityView.hideProgress();
        }


        @Override
        public void onError(Throwable e) {
            mainActivityView.hideProgress();
            mainActivityView.showError(e.getMessage());
        }
    }
}