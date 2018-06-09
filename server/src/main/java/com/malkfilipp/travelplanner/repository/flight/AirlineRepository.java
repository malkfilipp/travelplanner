package com.malkfilipp.travelplanner.repository.flight;

import com.malkfilipp.travelplanner.domain.flight.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Integer> {

}
