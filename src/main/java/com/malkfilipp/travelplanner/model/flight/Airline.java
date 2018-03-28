package com.malkfilipp.travelplanner.model.flight;

import com.malkfilipp.travelplanner.model.location.Country;

public class Airline {
    private int id;
    private String name;
    private Country country;

    public Airline() {
    }

    public Airline(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
