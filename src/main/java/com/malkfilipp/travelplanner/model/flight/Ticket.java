package com.malkfilipp.travelplanner.model.flight;

public class Ticket {
    private int id;
    private Shedule shedule;
    private String travelClass;
    private double amount;
    private int quantity;

    public Ticket() {
    }

    public Ticket(int id, Shedule shedule, String travelClass,
                  double amount, int quantity) {
        this.id = id;
        this.shedule = shedule;
        this.travelClass = travelClass;
        this.amount = amount;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shedule getShedule() {
        return shedule;
    }

    public void setShedule(Shedule shedule) {
        this.shedule = shedule;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "!";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
