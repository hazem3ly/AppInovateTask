package com.example.appinovatetask.ui.main;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.example.appinovatetask.ui.main.MainScreenViewModel;
import com.example.appinovatetask.ui.main.MainScreenViewModelProvider;
import com.example.appinovatetask.R;
import com.example.appinovatetask.app.BindingActivity;
import com.example.appinovatetask.databinding.ActivityMainBinding;
import com.example.appinovatetask.network.ApiClient;
import com.example.appinovatetask.network.ApiService;
import com.example.appinovatetask.repo.Repository;
import com.example.appinovatetask.repo.RepositoryImpl;

public class MainActivity extends BindingActivity<ActivityMainBinding> {

    private ApiService apiService;
    private Repository repository;
    private MainScreenViewModelProvider viewModelProvider;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        apiService = ApiClient.getClient().create(ApiService.class);

        apiService.getContinentsIds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<BaseResponse<List<Integer>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("result of countries = ", "started");
                    }

                    @Override
                    public void onSuccess(BaseResponse<List<Integer>> listBaseResponse) {
                        Log.e("result of countries = ", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("result of countries = ", e.getMessage());
                    }
                });

        apiService.getCountries(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<BaseResponse<Continent>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("result of getCountrs= ", "started");
                    }

                    @Override
                    public void onSuccess(BaseResponse<Continent> listBaseResponse) {
                        Log.e("result of getCountrs= ", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("result of getCountrs= ", e.getMessage());
                    }
                });

        apiService.getFlag(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<BaseResponse<Flag>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("result of getFlag= ", "started");
                    }

                    @Override
                    public void onSuccess(BaseResponse<Flag> listBaseResponse) {
                        Log.e("result of getFlag= ", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("result of getFlag= ", e.getMessage());
                    }
                });

        apiService.getCountryInfo(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<BaseResponse<Info>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("result of getCoInfo= ", "started");
                    }

                    @Override
                    public void onSuccess(BaseResponse<Info> listBaseResponse) {
                        Log.e("result of getCoInfo= ", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("result of getCoInfo= ", e.getMessage());
                    }
                });

        apiService.getCountryImages(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<BaseResponse<Images>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("result of getImages= ", "started");
                    }

                    @Override
                    public void onSuccess(BaseResponse<Images> listBaseResponse) {
                        Log.e("result of getImages= ", "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("result of getImages= ", e.getMessage());
                    }
                });

    }
*/

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiService = ApiClient.getClient().create(ApiService.class);
        repository = new RepositoryImpl(apiService);
        viewModelProvider = new MainScreenViewModelProvider(repository);

        MainScreenViewModel vm = ViewModelProviders.of(this, viewModelProvider).get(MainScreenViewModel.class);

        getBinding().setVm(vm);
        getBinding().setLifecycleOwner(this);
    }

}
