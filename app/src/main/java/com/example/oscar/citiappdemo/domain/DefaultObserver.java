package com.example.oscar.citiappdemo.domain;

import io.reactivex.Single;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Default {@link DisposableObserver} base class to be used whenever you want default error handling.
 */
public class DefaultObserver<T> extends DisposableSingleObserver<T> {

    /**
     * Notifies the SingleObserver with a single item and that the {@link Single} has finished sending
     * push-based notifications.
     * <p>
     * The {@link Single} will not call this method if it calls {@link #onError}.
     *
     * @param t the item emitted by the Single
     */
    @Override
    public void onSuccess(T t) {

    }

    /**
     * Notifies the SingleObserver that the {@link Single} has experienced an error condition.
     * <p>
     * If the {@link Single} calls this method, it will not thereafter call {@link #onSuccess}.
     *
     * @param e the exception encountered by the Single
     */
    @Override
    public void onError(Throwable e) {

    }
}