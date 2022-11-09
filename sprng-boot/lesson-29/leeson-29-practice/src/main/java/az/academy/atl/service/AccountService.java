package az.academy.atl.service;

import az.academy.atl.repository.AccountRepository;

public interface AccountService {

    void printStatus();

    AccountRepository getAccountRepository();
}
