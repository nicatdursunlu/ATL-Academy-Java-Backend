package az.atl.academy.lesson31.controllers;

import az.atl.academy.lesson31.services.MyService;
import az.atl.academy.lesson31.services.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SetterController {
    private MyService myService;
    private OtherService otherService;

    @Autowired
    public void setServices(MyService myService, OtherService otherService) {
        this.myService = myService;
        this.otherService = otherService;
    }

    public String saySomething() {
        return myService.getHello();
    }
}
