package com.atl.academy.lesson30.controllers;

import com.atl.academy.lesson30.models.City;
import com.atl.academy.lesson30.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping(path = "/cities", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<City> findCities(@RequestHeader("accept_language") String lang) {
        var cities = (List<City>) cityService.findAll();
        return cities;
    }
}