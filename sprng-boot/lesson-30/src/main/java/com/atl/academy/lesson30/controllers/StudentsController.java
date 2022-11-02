package com.atl.academy.lesson30.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentsController {

    @RequestMapping("/students")
    @ResponseBody
    public String helloAtl() {
        return "Hello ATL Academy";
    }
}

