package com.malkfilipp.travelplanner.domain.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malkfilipp.travelplanner.domain.flight.Airline;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Country {
    @Id
    private String id;
    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<City> cities;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Airline> airlines;

    public Country() {
    }

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
