package com.malkfilipp.travelplanner.service;

import com.malkfilipp.travelplanner.domain.flight.Ticket;
import com.malkfilipp.travelplanner.repository.flight.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Iterable<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Iterable<Ticket> getTickets(String departureCity, String arrivalCity, Date date) {
        var startTime = new Timestamp(date.getTime());
        var endDate = Calendar.getInstance();

        endDate.setTime(date);
        endDate.add(Calendar.HOUR, 23);
        endDate.add(Calendar.MINUTE, 59);
        endDate.add(Calendar.SECOND, 59);

        var endTime = new Timestamp(endDate.getTimeInMillis());

        return ticketRepository.findTickets(departureCity, arrivalCity, startTime, endTime);
    }
}
