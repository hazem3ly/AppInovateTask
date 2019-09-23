package com.example.appinovatetask.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Images {
    @SerializedName("images")
    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
