package com.atl.academy.lesson30.models;

import java.util.ArrayList;

public class City {
    public static ArrayList<City> cities = new ArrayList<>();
    public int id;
    public String name;
    public String code;

    public City(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

}
