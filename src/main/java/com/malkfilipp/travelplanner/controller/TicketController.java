package com.malkfilipp.travelplanner.controller;

import com.malkfilipp.travelplanner.domain.flight.Ticket;
import com.malkfilipp.travelplanner.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public Iterable<Ticket> getTickets(@RequestParam("arrival") String arrival,
                                       @RequestParam("departure") String departure,
                                       @RequestParam("date")
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return ticketService.getTickets(arrival, departure, date);
        // TODO: check the input parameters here or on the client
    }
}
