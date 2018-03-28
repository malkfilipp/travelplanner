package com.malkfilipp.travelplanner.model.flight;

import com.malkfilipp.travelplanner.model.location.City;

public class Airport {
    private String id;
    private String name;
    private City city;

    public Airport() {
    }

    public Airport(String id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
