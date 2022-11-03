package com.atl.academy.lesson30.services;

import com.atl.academy.lesson30.models.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    public List<City> cities = new ArrayList<>();

    public List<City> findAll() {
        City.data.add(new City(1, "Baku", "BK"));
        City.data.add(new City(2, "Ganja", "GJ"));
        City.data.add(new City(3, "Sheki", "SH"));
        City.data.add(new City(4, "Kharabag", "KB"));
        City.data.add(new City(5, "Lerik", "LK"));

        return City.data;
    }
}
