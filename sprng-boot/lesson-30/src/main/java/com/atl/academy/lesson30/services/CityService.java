package com.atl.academy.lesson30.services;

import com.atl.academy.lesson30.models.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    public List<City> findAll() {
        City.cities.add(new City(1, "Baku", "BK"));
        City.cities.add(new City(2, "Ganja", "GJ"));
        City.cities.add(new City(3, "Sheki", "SH"));
        City.cities.add(new City(4, "Kharabag", "KB"));
        City.cities.add(new City(5, "Lerik", "LK"));

        return City.cities;
    }
}
