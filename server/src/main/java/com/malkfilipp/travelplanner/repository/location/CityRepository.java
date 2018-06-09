package com.malkfilipp.travelplanner.repository.location;

import com.malkfilipp.travelplanner.domain.location.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
