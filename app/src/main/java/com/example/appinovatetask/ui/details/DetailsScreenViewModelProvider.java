package com.example.appinovatetask.ui.details;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.appinovatetask.repo.Repository;
import com.example.appinovatetask.ui.main.MainScreenViewModel;

@SuppressWarnings("unchecked")
public class DetailsScreenViewModelProvider implements ViewModelProvider.Factory {

    private Repository repository;

    DetailsScreenViewModelProvider(Repository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DetailsScreenViewModel(repository);
    }
}
