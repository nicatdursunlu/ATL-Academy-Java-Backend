package az.atl.academy.lesson31.controllers;

import az.atl.academy.lesson31.services.BestPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BestPracticeController {
    private final BestPracticeService bestPracticeService;

    @Autowired
    public BestPracticeController(BestPracticeService bestPracticeService) {
        this.bestPracticeService = bestPracticeService;
    }

    public String saySomething() {
        return bestPracticeService.getHello();
    }
}
