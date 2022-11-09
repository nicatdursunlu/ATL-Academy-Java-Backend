package az.academy.atl;

import az.academy.atl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class App1 {

    @Autowired
    @Qualifier("accountServiceImpl1")
    private AccountService accountService;

    public void printStatus() {
        accountService.printStatus();
    }
}
