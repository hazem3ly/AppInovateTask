package com.example.appinovatetask.repo;

import com.example.appinovatetask.network.ApiService;
import com.example.appinovatetask.network.model.BaseResponse;
import com.example.appinovatetask.network.model.Continent;
import com.example.appinovatetask.network.model.Flag;
import com.example.appinovatetask.network.model.Images;
import com.example.appinovatetask.network.model.Info;

import java.util.List;

import io.reactivex.Single;

public class RepositoryImpl implements Repository {

    private ApiService apiService;

    public RepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<BaseResponse<List<Integer>>> getIds() {
        return apiService.getContinentsIds();
    }

    @Override
    public Single<BaseResponse<Continent>> getContinent(int continentId) {
        return apiService.getCountries(continentId);
    }

    @Override
    public Single<BaseResponse<Flag>> getFlag(int countryId) {
        return apiService.getFlag(countryId);
    }

    @Override
    public Single<BaseResponse<Info>> getCountryInfo(int countryId) {
        return apiService.getCountryInfo(countryId);
    }

    @Override
    public Single<BaseResponse<Images>> getCountryImages(int countryId) {
        return apiService.getCountryImages(countryId);
    }

}
