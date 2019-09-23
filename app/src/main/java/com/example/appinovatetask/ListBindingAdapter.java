package com.example.appinovatetask;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appinovatetask.network.model.Continent;
import com.example.appinovatetask.ui.main.ContinentsAdapter;
import com.example.appinovatetask.ui.main.MainScreenViewModel;

import java.util.List;

public class ListBindingAdapter {
    @BindingAdapter(value = {"list", "viewModel"})
    public static void setList(RecyclerView view, List<Continent> items, MainScreenViewModel vm) {
        if (view.getAdapter() != null) {
            if (view.getAdapter() instanceof ContinentsAdapter) {
                ContinentsAdapter adapter = (ContinentsAdapter) view.getAdapter();
                adapter.setItems(items);
                adapter.notifyDataSetChanged();
            }
        } else {
            ContinentsAdapter adapter = new ContinentsAdapter(items, vm);
            view.setAdapter(adapter);
        }
    }

//    @BindingAdapter({"loadImage"})
//    public static void loadImage(ImageView view, String imageUrl) {
//         Picasso.with(view.getContext()).load(imageUrl).placeholder(R.drawable.placeholder).into(view);
//    }
}