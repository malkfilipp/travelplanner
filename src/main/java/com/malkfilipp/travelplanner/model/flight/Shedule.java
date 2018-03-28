package com.malkfilipp.travelplanner.model.flight;

import java.sql.Timestamp;

public class Shedule {
    private int id;
    private Flight flight;
    private Timestamp departureTime;
    private Timestamp arrivalTime;

    public Shedule() {
    }

    public Shedule(int id, Flight flight, Timestamp departureTime, Timestamp arrivalTime) {
        this.id = id;
        this.flight = flight;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
