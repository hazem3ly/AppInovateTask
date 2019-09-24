package com.example.appinovatetask.ui.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appinovatetask.R;
import com.example.appinovatetask.customView.CountryView;
import com.example.appinovatetask.network.model.Continent;
import com.example.appinovatetask.network.model.Country;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContinentsAdapter extends RecyclerView.Adapter<ContinentsViewHolder> {

    private List<Continent> items;
    private MainScreenViewModel vm;

    public ContinentsAdapter(List<Continent> items, MainScreenViewModel vm) {
        this.items = items;
        this.vm = vm;
    }

    @NonNull
    @Override
    public ContinentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ContinentsViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentsViewHolder holder, int position) {
        holder.binding.setVm(vm);
        holder.binding.setContinent(items.get(position));

        Continent continent = items.get(position);

        LinearLayout row = null;
        boolean firstRow = false;
        holder.binding.dataContainer.removeAllViews();
        for (int i = 0; i < continent.getCountries().size(); i++) {
            Country country = continent.getCountries().get(i);
            CountryView countryView = createView(holder.itemView.getContext(), country);
            if (!firstRow) {
                row = new LinearLayout(holder.itemView.getContext());
                row.setOrientation(LinearLayout.HORIZONTAL);
                firstRow = true;
            } else {
                firstRow = false;
            }

            row.addView(countryView);

            if (row.getParent() != null) {
                ((ViewGroup) row.getParent()).removeView(row); // <- fix
            }
            holder.binding.dataContainer.addView(row);
        }
        holder.binding.executePendingBindings();
    }

    private CountryView createView(Context context, Country country) {

        CountryView countryView = new CountryView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 10, 10);
        params.weight = 1;
        countryView.setOnClickListener(view -> {
            vm.countryItemClicked(view, country);
        });
        countryView.setLayoutParams(params);
        countryView.setText(country.getName());
        Picasso.get().load(country.getFlag()) .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.error).resize(0, 300).into(countryView.getImageView());

        return countryView;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Continent> items) {
        this.items = items;
    }


}
