package com.example.appinovatetask;

import com.example.appinovatetask.network.ApiClient;
import com.example.appinovatetask.network.ApiService;
import com.example.appinovatetask.repo.Repository;
import com.example.appinovatetask.repo.RepositoryImpl;

public class DI {
    private static ApiService apiService;
    private static Repository repository;

     public static Repository provideRepo() {
        if (repository == null)
            repository = new RepositoryImpl(provideApiService());
        return repository;
    }

     public static ApiService provideApiService() {
        if (apiService == null)
            apiService = ApiClient.getClient().create(ApiService.class);
        return apiService;
    }
}
