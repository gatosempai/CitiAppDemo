package com.example.oscar.citiappdemo.data.repository;

import com.example.oscar.citiappdemo.data.remote.models.GetClientNameRequest;
import com.example.oscar.citiappdemo.data.remote.models.GetClientNameResponse;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting {@link GetClientNameRequest} related data.
 */
public interface GetClientNameDataRepository {
  /**
   * Get an {@link Observable} which will emit a List of {@link GetClientNameRequest}.
   */
  Observable<GetClientNameResponse> getClientName(GetClientNameRequest request);

}