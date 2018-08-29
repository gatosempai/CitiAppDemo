package com.example.oscar.citiappdemo.domain;

import com.example.oscar.citiappdemo.data.remote.models.GetClientNameRequest;
import com.example.oscar.citiappdemo.data.remote.models.GetClientNameResponse;
import com.example.oscar.citiappdemo.data.repository.GetClientNameRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link GetClientNameRequest}.
 */
public class GetClientName extends UseCase<String, Void> {

    private final GetClientNameRepository getClientNameRepository;

    @Inject
    public GetClientName(GetClientNameRepository getClientNameRepository,
                         ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.getClientNameRepository = getClientNameRepository;
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     *
     * @param aVoid
     */
    @Override
    Observable<String> buildUseCaseObservable(Void aVoid) {
        return getClientNameRepository.getClientName(new GetClientNameRequest())
                .flatMap((Function<GetClientNameResponse, ObservableSource<String>>)
                        getClientNameResponse -> Observable.just(getClientNameResponse.getClientName()));
    }
}