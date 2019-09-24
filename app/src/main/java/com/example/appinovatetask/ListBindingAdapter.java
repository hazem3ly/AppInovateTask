package com.example.appinovatetask;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appinovatetask.network.model.Continent;
import com.example.appinovatetask.network.model.Flag;
import com.example.appinovatetask.network.model.Images;
import com.example.appinovatetask.ui.main.ContinentsAdapter;
import com.example.appinovatetask.ui.main.MainScreenViewModel;
import com.squareup.picasso.Picasso;

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

    @BindingAdapter({"loadImage"})
    public static void loadImage(ImageView view, Flag imageUrl) {
        if (imageUrl.getFlag().equals("")) return;
        Picasso.get()
                .load(imageUrl.getFlag())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.error)
                .resize(0, 150)
                .into(view);

    }

    @BindingAdapter({"loadCountryImages"})
    public static void loadCountryImages(LinearLayout view, Images images) {
        if (images.getImages().isEmpty()) return;
        for (String image : images.getImages()) {
            ImageView imageView = new ImageView(view.getContext());
            RelativeLayout.LayoutParams layoutParams =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 10, 10, 10);
            imageView.setLayoutParams(layoutParams);
            Picasso.get().load(image).placeholder(R.drawable.ic_launcher_background).error(R.drawable.error).resize(300, 300).into(imageView);
            view.addView(imageView);
        }
    }
}
