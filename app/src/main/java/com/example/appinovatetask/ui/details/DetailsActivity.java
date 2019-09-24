package com.example.appinovatetask.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.appinovatetask.DI;
import com.example.appinovatetask.R;
import com.example.appinovatetask.app.BindingActivity;
import com.example.appinovatetask.databinding.ActivityDetailsBinding;
import com.example.appinovatetask.databinding.ActivityMainBinding;
import com.example.appinovatetask.network.ApiClient;
import com.example.appinovatetask.network.ApiService;
import com.example.appinovatetask.network.model.Country;
import com.example.appinovatetask.repo.Repository;
import com.example.appinovatetask.repo.RepositoryImpl;
import com.example.appinovatetask.ui.main.MainScreenViewModel;
import com.example.appinovatetask.ui.main.MainScreenViewModelProvider;

import static com.example.appinovatetask.app.Const.COUNTRY_DATA;

public class DetailsActivity extends BindingActivity<ActivityDetailsBinding> {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_details;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DetailsScreenViewModelProvider viewModelProvider = new DetailsScreenViewModelProvider(DI.provideRepo());

        DetailsScreenViewModel vm = ViewModelProviders.of(this, viewModelProvider).get(DetailsScreenViewModel.class);

        getBinding().setVm(vm);
        getBinding().setLifecycleOwner(this);

        Country country = (Country) getIntent().getSerializableExtra(COUNTRY_DATA);
        getBinding().setCountry(country);

        vm.loadCountryDetails(country.getId());
        setTitle(country.getName());

    }
}
