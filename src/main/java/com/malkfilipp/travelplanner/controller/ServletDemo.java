package com.malkfilipp.travelplanner.controller;

import com.malkfilipp.travelplanner.dao.TicketDao;
import com.malkfilipp.travelplanner.dao.jdbc.TicketDaoImpl;
import com.malkfilipp.travelplanner.model.flight.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
    private TicketDao ticketDaoImpl = new TicketDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Ticket> tickets = ticketDaoImpl.getCheapest(
                request.getParameter("departure"),
                request.getParameter("arrival"),
                Date.valueOf("2018-06-12")
        );

        request.setAttribute("tickets", tickets);

        request.getRequestDispatcher("/ticketsTable.jsp").forward(request, response);
    }
}
