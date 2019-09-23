package com.example.appinovatetask.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.appinovatetask.R;
import com.example.appinovatetask.app.BindingViewHolder;
import com.example.appinovatetask.databinding.ContinentItemBinding;

class ContinentsViewHolder extends BindingViewHolder<ContinentItemBinding> {

   public ContinentItemBinding binding;

    private ContinentsViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = getBinding();
    }


    static ContinentsViewHolder create(ViewGroup parent) {
        return new ContinentsViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.continent_item,
                        parent,
                        false
                ));
    }

}