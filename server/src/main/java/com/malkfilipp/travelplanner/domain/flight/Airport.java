package com.malkfilipp.travelplanner.domain.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.malkfilipp.travelplanner.domain.location.City;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy="departureAirport")
    private List<Flight> departureFlights;

    @JsonIgnore
    @OneToMany(mappedBy="arrivalAirport")
    private List<Flight> arrivalFlights;

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

    public List<Flight> getDepartureFlights() {
        return departureFlights;
    }

    public void setDepartureFlights(List<Flight> departureFlights) {
        this.departureFlights = departureFlights;
    }

    public List<Flight> getArrivalFlights() {
        return arrivalFlights;
    }

    public void setArrivalFlights(List<Flight> arrivalFlights) {
        this.arrivalFlights = arrivalFlights;
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
