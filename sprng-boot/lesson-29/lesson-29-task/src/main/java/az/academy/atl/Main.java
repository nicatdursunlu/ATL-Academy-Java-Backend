package az.academy.atl;

import az.academy.atl.config.EmployeeConfig;
import az.academy.atl.model.Department;
import az.academy.atl.model.Employee;
import az.academy.atl.repository.EmployeeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmployeeConfig.class);
        EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);

        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeRepository employeeRepository2 = xmlApplicationContext.getBean(EmployeeRepository.class);
        employeeRepository2.getDepartments();

        ApplicationContext xmlApplicationContext2 = new ClassPathXmlApplicationContext("beans.xml");
        App app = xmlApplicationContext2.getBean(App.class);
        app.getDepartments();

        Employee employee = new Employee(
                207L, "Nijat", "Dursunlu", "nijat.dursunlu@gmail.com",
                "+994 51 361 30 25", new Date(20211001L), 9L,
                1500.00, 102L, 6L
        );
        System.out.println("Result: " + employeeRepository.insertEmployee(employee));


        Long locationId = employeeRepository.getLocationId("CA");
        System.out.println("LocationId: " + locationId);

        Department department1 = new Department();
        department1.setDepartmentId(12L);
        department1.setDepartmentName("Artificial Intelligence");
        department1.setLocationId(locationId);

        Department department2 = new Department();
        department2.setDepartmentId(13L);
        department2.setDepartmentName("Software Development");
        department2.setLocationId(locationId);

        employeeRepository.insertNewDepartmentsBatch(department1, department2);

        Employee employeeUpdated = new Employee(
                207L, "Nijat updated", "Dursunlu updated",
                "nijat.dursunlu.updated@gmail.com", "+994513613025",
                new Date(20211001L), 9L, 2000.00, 102L, 6L
        );
        employeeRepository.updateEmployee(employee.getEmployeeId(), employeeUpdated);

        employeeRepository.deleteEmployee(207L);
    }
}
