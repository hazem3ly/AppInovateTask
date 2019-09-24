package com.example.appinovatetask.ui.main;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.example.appinovatetask.DI;
import com.example.appinovatetask.R;
import com.example.appinovatetask.app.BindingActivity;
import com.example.appinovatetask.databinding.ActivityMainBinding;

public class MainActivity extends BindingActivity<ActivityMainBinding> {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainScreenViewModelProvider viewModelProvider = new MainScreenViewModelProvider(DI.provideRepo());

        MainScreenViewModel vm = ViewModelProviders.of(this, viewModelProvider).get(MainScreenViewModel.class);

        getBinding().setVm(vm);
        getBinding().setLifecycleOwner(this);
    }

}
