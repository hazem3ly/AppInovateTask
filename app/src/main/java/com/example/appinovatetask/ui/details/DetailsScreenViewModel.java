package com.example.appinovatetask.ui.details;

import com.example.appinovatetask.app.BaseViewModel;
import com.example.appinovatetask.app.NotNullMutableLiveData;
import com.example.appinovatetask.network.model.BaseResponse;
import com.example.appinovatetask.network.model.Continent;
import com.example.appinovatetask.network.model.Flag;
import com.example.appinovatetask.network.model.Images;
import com.example.appinovatetask.network.model.Info;
import com.example.appinovatetask.repo.Repository;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;

public class DetailsScreenViewModel extends BaseViewModel {
    private Repository repository;

    DetailsScreenViewModel(Repository repository) {

        this.repository = repository;
    }

    private NotNullMutableLiveData<Info> _info = new NotNullMutableLiveData<>(new Info());
    private NotNullMutableLiveData<Flag> _flag = new NotNullMutableLiveData<>(new Flag());
    private NotNullMutableLiveData<Images> _images = new NotNullMutableLiveData<>(new Images());

    public NotNullMutableLiveData<Info> getInfo() {
        return _info;
    }
    public NotNullMutableLiveData<Flag> getFlag() {
        return _flag;
    }
    public NotNullMutableLiveData<Images> getimages() {
        return _images;
    }

    private Observable<BaseResponse<Info>> getCountryInfo(Integer integer) {
        return repository
                .getCountryInfo(integer)
                .toObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<BaseResponse<Flag>> getCountryFlag(Integer integer) {
        return repository
                .getFlag(integer)
                .toObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<BaseResponse<Images>> getCountryImages(Integer integer) {
        return repository
                .getCountryImages(integer)
                .toObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void loadCountryDetails(int id) {
        Disposable disposable = Observable.zip(
                getCountryInfo(id),
                getCountryFlag(id),
                getCountryImages(id),
                (infoBaseResponse, flagBaseResponse, imagesBaseResponse) -> {
                    _info.setValue(infoBaseResponse.getData());
                    _flag.setValue(flagBaseResponse.getData());
                    _images.setValue(imagesBaseResponse.getData());
                    return "Done";
                }).subscribe();
        addToDisposable(disposable);
    }

}
