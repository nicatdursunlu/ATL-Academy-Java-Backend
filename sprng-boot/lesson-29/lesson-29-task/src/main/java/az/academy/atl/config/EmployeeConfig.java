package az.academy.atl.config;

import az.academy.atl.repository.EmployeeRepository;
import az.academy.atl.repository.impl.EmployeeRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public EmployeeRepository employeeRepository() {
        return new EmployeeRepositoryImpl();
    }
}
