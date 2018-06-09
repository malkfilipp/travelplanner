package com.malkfilipp.travelplanner.repository.flight;

import com.malkfilipp.travelplanner.domain.flight.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

}
