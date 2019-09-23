package com.example.appinovatetask.network.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {
    private int status;
    private String message;
    @SerializedName(value = "continents_ids",
            alternate = {"continent", "country_flag", "country_info", "country_images"})
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
