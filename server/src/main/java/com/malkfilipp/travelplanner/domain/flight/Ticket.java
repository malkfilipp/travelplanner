package com.malkfilipp.travelplanner.domain.flight;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('FIRST', 'BUSINESS', 'PREMIUM_ECONOMY', 'ECONOMY')")
    private TravelClass travelClass;
    @NotNull
    private Double amount;
    @NotNull
    private Integer quantity;

    public Ticket() {
    }

    public Ticket(Integer id, Schedule schedule, TravelClass travelClass,
                  Double amount, Integer quantity) {
        this.id = id;
        this.schedule = schedule;
        this.travelClass = travelClass;
        this.amount = amount;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", schedule=" + schedule +
                ", travelClass='" + travelClass + '\'' +
                ", amount=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}
