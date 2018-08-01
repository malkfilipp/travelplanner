package com.malkfilipp.travelplanner.controller;

import com.malkfilipp.travelplanner.domain.location.City;
import com.malkfilipp.travelplanner.repository.location.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    private final CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/cities")
    public Iterable<City> getCities() {
        return cityRepository.findAll();
    }
}
