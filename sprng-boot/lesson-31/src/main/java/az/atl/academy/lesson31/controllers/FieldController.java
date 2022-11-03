package az.atl.academy.lesson31.controllers;

import az.atl.academy.lesson31.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FieldController {

    @Autowired
    MyService myService;

    public String saySomething() {
        return myService.getHello();
    }
}
