package az.academy.atl.service;

import az.academy.atl.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("accountServiceImpl1")
public class AccountServiceImpl1 implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl1(AccountRepository accountRepository) {
        System.out.println("First Account Service initialized!");
        this.accountRepository = accountRepository;
    }

    public AccountServiceImpl1() {
        System.out.println("First Account Service initialized!");
    }

    @Override
    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    @Override
    public void printStatus() {
        System.out.println("First Account Service: OK!");
    }
}
