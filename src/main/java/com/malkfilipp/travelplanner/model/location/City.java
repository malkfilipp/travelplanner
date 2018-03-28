package com.malkfilipp.travelplanner.model.location;

import java.sql.Time;

public class City {
    private int id;
    private String name;
    private Country country;
    private Time timezone;
    private boolean summerShift;

    public City() {
    }

    public City(int id, String name, Country country,
                Time timezone, boolean summerShift) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.timezone = timezone;
        this.summerShift = summerShift;
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

    public Time getTimezone() {
        return timezone;
    }

    public void setTimezone(Time timezone) {
        this.timezone = timezone;
    }

    public boolean isSummerShift() {
        return summerShift;
    }

    public void setSummerShift(boolean summerShift) {
        this.summerShift = summerShift;
    }
}
