package com.example.appinovatetask.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.appinovatetask.repo.Repository;

@SuppressWarnings("unchecked")
public class MainScreenViewModelProvider implements ViewModelProvider.Factory {

    private Repository repository;

    MainScreenViewModelProvider(Repository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainScreenViewModel(repository);
    }
}
