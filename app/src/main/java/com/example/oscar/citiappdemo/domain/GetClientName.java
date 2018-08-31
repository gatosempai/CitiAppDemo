package com.example.oscar.citiappdemo.domain;

import com.example.oscar.citiappdemo.data.remote.models.GetClientNameRequest;
import com.example.oscar.citiappdemo.data.remote.models.GetClientNameResponse;
import com.example.oscar.citiappdemo.data.repository.GetClientNameDataRepository;
import com.example.oscar.citiappdemo.data.repository.GetClientNameRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link GetClientNameRequest}.
 */
public class GetClientName extends UseCase<String, String> {

    private final GetClientNameDataRepository getClientNameDataRepository;

    @Inject
    GetClientName(GetClientNameRepository getClientNameDataRepository,
                  ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.getClientNameDataRepository = getClientNameDataRepository;
    }

    /**
     * Builds an {@link Single} which will be used when executing the current {@link UseCase}.
     *
     * @param clientNumber a client number
     */
    @Override
    Single<String> buildUseCaseObservable(String clientNumber) {
        return getClientNameDataRepository.getClientName(new GetClientNameRequest(clientNumber))
                .flatMap((Function<GetClientNameResponse, SingleSource<String>>) getClientNameResponse -> {
                    if (!getClientNameResponse.getOpstatus().equals("0")) return Single.error(new Throwable("Valio"));
                    return Single.just(getClientNameResponse.getClientName());
                });
    }
}