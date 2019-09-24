package com.example.appinovatetask.ui.main;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.appinovatetask.app.BaseViewModel;
import com.example.appinovatetask.network.model.BaseResponse;
import com.example.appinovatetask.network.model.Continent;
import com.example.appinovatetask.network.model.Country;
import com.example.appinovatetask.repo.Repository;
import com.example.appinovatetask.ui.details.DetailsActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static com.example.appinovatetask.app.Const.COUNTRY_DATA;

public class MainScreenViewModel extends BaseViewModel {
    private Repository repository;

    private MutableLiveData<ArrayList<Continent>> _items = new MutableLiveData<>(new ArrayList<>());

    public MutableLiveData<ArrayList<Continent>> getItems() {
        return _items;
    }

    MainScreenViewModel(Repository repository) {
        this.repository = repository;
        getIds();
    }

    private void getIds() {
        Disposable disposable = repository.getIds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::bindList, this::handleError);
        addToDisposable(disposable);
    }

    private void handleError(Throwable throwable) {
        Log.e("result of countries = ", "");
    }

    private Observable<BaseResponse<Continent>> getCountryObservable(Integer integer) {
        return repository
                .getContinent(integer)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private void bindList(@NotNull BaseResponse<List<Integer>> listBaseResponse) {

        Disposable disposable = Observable.just(listBaseResponse.getData())
                // (2) convert our List emission into a stream of its constituent values
                .flatMap((Function<List<Integer>, ObservableSource<Integer>>) Observable::fromIterable)
                // (3) subsequently convert each individual value emission into an Observable of some
                //     newly calculated type
                .flatMap((Function<Integer, ObservableSource<BaseResponse<Continent>>>) this::getCountryObservable)
                // (4) collect all the final emissions into a list
                .subscribeWith(new DisposableObserver<BaseResponse<Continent>>() {

                    @Override
                    public void onNext(BaseResponse<Continent> ticket) {
                        ArrayList<Continent> items = _items.getValue();
                        if (items != null) {
                            items.add(ticket.getData());
                            _items.setValue(items);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                });
        addToDisposable(disposable);
    }

    public void openCountryDetails(View view, Continent continent) {
        Toast.makeText(view.getContext(), continent.getContinentName(), Toast.LENGTH_SHORT).show();
    }

    public void countryItemClicked(View view, Country country) {
        Intent intent = new Intent(view.getContext(), DetailsActivity.class);
        intent.putExtra(COUNTRY_DATA, country);
        view.getContext().startActivity(intent);
    }
}
