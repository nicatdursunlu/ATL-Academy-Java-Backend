package az.academy.atl.repository;

import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    public AccountRepositoryImpl() {
        System.out.println("Account Repository initialized!");
    }

    @Override
    public void printStatus() {
        System.out.println("Account Repository: OK!");
    }
}
