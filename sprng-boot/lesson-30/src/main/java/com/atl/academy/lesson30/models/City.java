package com.atl.academy.lesson30.models;

import java.util.ArrayList;
import java.util.List;

public class City {
    public static List<City> data = new ArrayList<>();
    public int id;
    public String name;
    public String code;

    public City(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

}
