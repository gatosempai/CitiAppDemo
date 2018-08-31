package com.example.oscar.citiappdemo.data.repository;

import com.example.oscar.citiappdemo.data.remote.models.GetClientNameRequest;
import com.example.oscar.citiappdemo.data.remote.models.GetClientNameResponse;

import io.reactivex.Single;

/**
 * Interface that represents a Repository for getting {@link GetClientNameRequest} related data.
 */
public interface GetClientNameDataRepository {
  /**
   * Get an {@link Single} which will emit a single object of {@link GetClientNameRequest}.
   */
  Single<GetClientNameResponse> getClientName(GetClientNameRequest request);

}