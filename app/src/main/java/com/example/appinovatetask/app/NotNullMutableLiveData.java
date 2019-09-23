package com.example.appinovatetask.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

public class NotNullMutableLiveData<T> extends MutableLiveData<T> {
    public NotNullMutableLiveData(T defaultValue) {
        setValue(defaultValue);
    }

    @Nullable
    @Override
    public T getValue() {
        return super.getValue();
    }
}
