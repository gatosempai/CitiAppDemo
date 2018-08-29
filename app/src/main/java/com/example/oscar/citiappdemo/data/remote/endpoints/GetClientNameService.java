package com.example.oscar.citiappdemo.data.remote.endpoints;

import com.example.oscar.citiappdemo.data.remote.models.GetClientNameResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GetClientNameService {

    //@POST("MWServlet")
    //Call<GetClientNameResponse> getClientName(@Body RequestBody body);

    @FormUrlEncoded
    @POST("MWServlet")
    Observable<GetClientNameResponse> getClientNameService(@FieldMap Map<String, String> getClientNameFields);
}