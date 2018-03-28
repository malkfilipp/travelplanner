package com.malkfilipp.travelplanner.dao.jdbc;

import com.malkfilipp.travelplanner.dao.TicketDao;
import com.malkfilipp.travelplanner.model.flight.*;

import java.sql.*;
import java.util.ArrayList;

public class TicketDaoImpl implements TicketDao {
    @Override
    public void create(Ticket newInstance) {
        try (Connection conn = Database.getConnection()) {
            String sql = "insert into Ticket " +
                    "(sheduleId, class, amount, quantity) values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, newInstance.getShedule().getId());
            ps.setString(2, newInstance.getTravelClass());
            ps.setDouble(3, newInstance.getAmount());
            ps.setInt(4, newInstance.getQuantity());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ticket read(Integer id) {
        Ticket ticket = null;

        try (Connection conn = Database.getConnection()) {
            String sql = "select * from Ticket where id = " + id;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ticket = new Ticket();
                ticket.setId(rs.getInt("id"));

                //TODO: add other fields

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticket;
    }

    @Override
    public void update(Ticket transientObject) {

    }

    @Override
    public void delete(Ticket persistentObject) {

    }

    @Override
    public ArrayList<Ticket> getCheapest(String departureCity, String arrivalCity,
                                         Date firstPossible, Date lastPossible) {
        ArrayList<Ticket> tickets = new ArrayList<>();

        try (Connection conn = Database.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(Queries.CHEAPEST_TICKET);

            ps.setString(1, departureCity);
            ps.setString(2, arrivalCity);
            ps.setDate(3, firstPossible);
            ps.setDate(4, lastPossible);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ticket ticket = formTicketView(rs);

                tickets.add(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    private Ticket formTicketView(ResultSet rs) throws SQLException {
        Airline airline = new Airline();
        airline.setName(rs.getString("airline"));

        Aircraft aircraft = new Aircraft();
        aircraft.setType(rs.getString("aircraft"));

        Airport departureAirport = new Airport();
        departureAirport.setId(rs.getString("departureAirport"));

        Airport arrivalAirport = new Airport();
        arrivalAirport.setId(rs.getString("arrivalAirport"));

        Flight flight = new Flight();
        flight.setAirline(airline);
        flight.setAircraft(aircraft);
        flight.setNumber(rs.getString("flightNumber"));

        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);

        Shedule shedule = new Shedule();
        shedule.setFlight(flight);
        shedule.setDepartureTime(rs.getTimestamp("departureTime"));
        shedule.setArrivalTime(rs.getTimestamp("arrivalTime"));

        Ticket ticket = new Ticket();
        ticket.setId(rs.getInt("id"));
        ticket.setShedule(shedule);
        ticket.setTravelClass(rs.getString("travelClass"));
        ticket.setAmount(rs.getDouble("amount"));
        return ticket;
    }

    @Override
    public ArrayList<Ticket> getCheapest(String departureCity, String arrivalCity, Date date) {
        return getCheapest(departureCity, arrivalCity, date, date);
    }
}
