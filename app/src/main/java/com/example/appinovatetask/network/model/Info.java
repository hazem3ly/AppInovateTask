package com.example.appinovatetask.network.model;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("info")
    private String info = "";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
