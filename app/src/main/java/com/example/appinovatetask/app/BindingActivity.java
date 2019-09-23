package com.example.appinovatetask.app;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

abstract public class BindingActivity<T extends ViewDataBinding> extends AppCompatActivity {

    @LayoutRes
    protected abstract int getLayoutResId();

    private T binding;

    protected T getBinding() {
        return binding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutResId());
    }
}
