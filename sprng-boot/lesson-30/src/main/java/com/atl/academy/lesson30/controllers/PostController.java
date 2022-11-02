package com.atl.academy.lesson30.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PostController {
    ArrayList<Integer> list = new ArrayList<>();

    public PostController() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @GetMapping("/hello/{name}/{age}")
    public void insert(@PathVariable("name") String name,
                       @PathVariable("age") int age) {
        System.out.println(name);
        System.out.println(age);
    }

    @DeleteMapping("/hello/{id}")
    public void deleteById(@PathVariable("id") int id) {
        list.remove(Integer.valueOf(id));
        System.out.println(list);
    }
}
