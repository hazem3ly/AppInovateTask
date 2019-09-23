package com.example.appinovatetask.network.model;

import com.google.gson.annotations.SerializedName;

public class Flag {
    @SerializedName("flag_img")
    private String flag = "";

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
