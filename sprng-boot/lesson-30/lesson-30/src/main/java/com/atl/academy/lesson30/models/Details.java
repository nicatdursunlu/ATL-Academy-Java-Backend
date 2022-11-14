package com.atl.academy.lesson30.models;

import java.util.ArrayList;

public class Details {

    public static ArrayList<Details> Data = new ArrayList<>();
    public int number;
    public String name;

    public Details(int number, String name) {
        this.number = number;
        this.name = name;
    }
}
