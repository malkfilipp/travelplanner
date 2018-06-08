package com.malkfilipp.travelplanner.domain.flight;

public enum TravelClass {
    FIRST("First"),
    BUSINESS("Business"),
    PREMIUM_ECONOMY("Premium economy"),
    ECONOMY("Economy");

    private final String name;

    TravelClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
