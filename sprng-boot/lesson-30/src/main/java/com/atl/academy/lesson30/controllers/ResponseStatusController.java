package com.atl.academy.lesson30.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseStatusController {

    @RequestMapping(value = "/orders/{id}")
    public String getOrder(@PathVariable("id") long id) throws Exception {
        if (id < 0 || id > 500) {
            throw new Exception("Invalid id");
        }
        return String.format("Returning order %d", id);
    }
}
