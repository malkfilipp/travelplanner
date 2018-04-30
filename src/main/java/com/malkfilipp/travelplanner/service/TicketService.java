package com.malkfilipp.travelplanner.service;

import com.malkfilipp.travelplanner.domain.flight.Ticket;

import java.util.Date;

public interface TicketService {
    Iterable<Ticket> getAll();

    Iterable<Ticket> getTickets(String arrivalAirport, String departureAirport, Date date);
}
