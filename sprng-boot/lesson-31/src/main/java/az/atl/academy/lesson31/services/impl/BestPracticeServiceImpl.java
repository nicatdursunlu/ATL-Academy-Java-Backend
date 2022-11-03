package az.atl.academy.lesson31.services.impl;

import az.atl.academy.lesson31.services.BestPracticeService;
import org.springframework.stereotype.Service;

@Service
public class BestPracticeServiceImpl implements BestPracticeService {

    @Override
    public String getHello() {
        return "The Best Hello!";
    }
}
