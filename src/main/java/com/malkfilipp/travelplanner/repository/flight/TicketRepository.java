package com.malkfilipp.travelplanner.repository.flight;

import com.malkfilipp.travelplanner.domain.flight.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    @Query("select t from #{#entityName} t " +
            "where t.schedule.flight.arrivalAirport.city.name = :arrival " +
            "and t.schedule.flight.departureAirport.city.name = :departure " +
            "and t.schedule.arrivalTime between :startTime and :endTime " +
            "order by t.amount")
    Iterable<Ticket> findTickets(@Param("arrival") String arrival,
                                 @Param("departure") String departure,
                                 @Param("startTime") Timestamp startTime,
                                 @Param("endTime") Timestamp endTime);
}
