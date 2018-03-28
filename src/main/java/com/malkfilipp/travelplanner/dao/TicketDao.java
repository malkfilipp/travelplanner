package com.malkfilipp.travelplanner.dao;

import com.malkfilipp.travelplanner.model.flight.Ticket;

import java.sql.Date;
import java.util.ArrayList;

public interface TicketDao extends GenericDao<Ticket, Integer> {
    ArrayList<Ticket> getCheapest(String departureCity, String arrivalCity,
                                  Date date);

    ArrayList<Ticket> getCheapest(String departureCity, String arrivalCity,
                                  Date firstPossible, Date lastPossible);
}
