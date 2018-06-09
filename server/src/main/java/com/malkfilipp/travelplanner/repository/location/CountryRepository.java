package com.malkfilipp.travelplanner.repository.location;

import com.malkfilipp.travelplanner.domain.location.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

}
