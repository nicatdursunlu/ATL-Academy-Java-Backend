package az.academy.atl;

import az.academy.atl.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {

    private final EmployeeRepository employeeRepository;

    public App(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void getDepartments() {
        employeeRepository.getDepartments();
    }
}
