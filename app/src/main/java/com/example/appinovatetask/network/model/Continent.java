package com.example.appinovatetask.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Continent {
    private int id;
    @SerializedName("continent_name")
    private String continentName;
    private List<Country> countries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
