package az.academy.atl.service;

import az.academy.atl.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component("accountServiceImpl2")
public class AccountServiceImpl2 implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl2(AccountRepository accountRepository) {
        System.out.println("Second Account Service initialized!");
        this.accountRepository = accountRepository;
    }

    public AccountServiceImpl2() {
        System.out.println("Second Account Service initialized!");
    }

    @Override
    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    @Override
    public void printStatus() {
        System.out.println("Second Account Service: OK!");
    }
}
