package com.malkfilipp.travelplanner.domain.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airlineId")
    private Airline airline;

    @NotNull
    private String number;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aircraftId")
    private Aircraft aircraft;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "departureAirportId")
    private Airport departureAirport;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "arrivalAirportId")
    private Airport arrivalAirport;

    @JsonIgnore
    @OneToMany(mappedBy = "flight")
    private List<Schedule> schedules;

    public Flight() {
    }

    public Flight(Integer id, Airline airline, String number, Aircraft aircraft,
                  Airport departureAirport, Airport arrivalAirport) {
        this.id = id;
        this.airline = airline;
        this.number = number;
        this.aircraft = aircraft;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airline=" + airline +
                ", number='" + number + '\'' +
                ", aircraft=" + aircraft +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                '}';
    }
}
