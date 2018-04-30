package com.malkfilipp.travelplanner.repository.flight;

import com.malkfilipp.travelplanner.domain.flight.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, String> {

}
