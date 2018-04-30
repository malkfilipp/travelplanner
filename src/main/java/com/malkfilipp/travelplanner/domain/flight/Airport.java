package com.malkfilipp.travelplanner.domain.flight;

import com.malkfilipp.travelplanner.domain.location.City;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Airport {
    @Id
    private String id;
    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cityId")
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

    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
