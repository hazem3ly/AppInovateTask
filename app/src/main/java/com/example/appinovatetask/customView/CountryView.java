package com.example.appinovatetask.customView;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class CountryView extends CardView {

    private ImageView imageView;
    private TextView textView;
    private LinearLayout linearLayout;


    public CountryView(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public CountryView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CountryView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);

    }

    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        imageView = new ImageView(context);

        FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, 100);

        imageView.setLayoutParams(imageParams);

        textView = new TextView(context);
        FrameLayout.LayoutParams textParams = new FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, 50);

        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20f);
        textView.setLayoutParams(textParams);

        linearLayout = new LinearLayout(context, attrs, defStyleAttr);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);

        this.addView(linearLayout, params);

        linearLayout.addView(imageView, params);
        linearLayout.addView(textView, params);

        setCardElevation(8f);

        setClickable(true);
        setFocusable(true);

    }

    public void setText(CharSequence text) {
        textView.setText(text);
    }


    public void setImageResource(int resId) {
        textView.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(resId);
    }

    public void setImageDrawable(Drawable drawable) {
        textView.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageDrawable(drawable);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }
}
