package com.example.appinovatetask.network;

import com.example.appinovatetask.network.model.BaseResponse;
import com.example.appinovatetask.network.model.Continent;
import com.example.appinovatetask.network.model.Flag;
import com.example.appinovatetask.network.model.Images;
import com.example.appinovatetask.network.model.Info;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("get_continents_ids")
    Single<BaseResponse<List<Integer>>> getContinentsIds();

    @GET("get_continent_byId")
    Single<BaseResponse<Continent>> getCountries(@Query("continent_id") int continentId);

    @GET("get_flag")
    Single<BaseResponse<Flag>> getFlag(@Query("country_id") int countryId);

    @GET("get_info")
    Single<BaseResponse<Info>> getCountryInfo(@Query("country_id") int countryId);

    @GET("get_images")
    Single<BaseResponse<Images>> getCountryImages(@Query("country_id") int countryId);

}
