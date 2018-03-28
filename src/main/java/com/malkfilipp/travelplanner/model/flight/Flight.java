package com.malkfilipp.travelplanner.model.flight;

import com.malkfilipp.travelplanner.model.flight.Aircraft;
import com.malkfilipp.travelplanner.model.flight.Airline;
import com.malkfilipp.travelplanner.model.flight.Airport;

public class Flight {
    private int id;
    private Airline airline;
    private String number;
    private Aircraft aircraft;
    private Airport departureAirport;
    private Airport arrivalAirport;

    public Flight() {
    }

    public Flight(int id, Airline airline, String number, Aircraft aircraft,
                  Airport departureAirport, Airport arrivalAirport) {
        this.id = id;
        this.airline = airline;
        this.number = number;
        this.aircraft = aircraft;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
