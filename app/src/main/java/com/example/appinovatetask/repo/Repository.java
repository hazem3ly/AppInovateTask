package com.example.appinovatetask.repo;

import com.example.appinovatetask.network.model.BaseResponse;
import com.example.appinovatetask.network.model.Continent;
import com.example.appinovatetask.network.model.Flag;
import com.example.appinovatetask.network.model.Images;
import com.example.appinovatetask.network.model.Info;

import java.util.List;

import io.reactivex.Single;

public interface Repository {

    Single<BaseResponse<List<Integer>>> getIds();

    Single<BaseResponse<Continent>> getContinent(int continentId);

    Single<BaseResponse<Flag>> getFlag(int countryId);

    Single<BaseResponse<Info>> getCountryInfo(int countryId);

    Single<BaseResponse<Images>> getCountryImages(int countryId);
}
