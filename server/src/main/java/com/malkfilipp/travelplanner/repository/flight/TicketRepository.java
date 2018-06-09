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
            "where t.schedule.flight.departureAirport.city.name = :departureCity " +
            "and t.schedule.flight.arrivalAirport.city.name = :arrivalCity " +
            "and t.schedule.departureTime between :startTime and :endTime " +
            "order by t.schedule.departureTime")
    Iterable<Ticket> findTickets(@Param("departureCity") String departureCity,
                                 @Param("arrivalCity") String arrivalCity,
                                 @Param("startTime") Timestamp startTime,
                                 @Param("endTime") Timestamp endTime);
}
