package com.atl.academy.lesson30.controllers;

import com.atl.academy.lesson30.models.Details;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailsController {

    @PostMapping("/details")
    String insert(@RequestBody Details object) {
        Details.Data.add(new Details(object.number, object.name));

        for (Details obj : Details.Data) {
            System.out.println(obj.name + " " + obj.number);
        }
        return "Data inserted successfully!";
    }
}
