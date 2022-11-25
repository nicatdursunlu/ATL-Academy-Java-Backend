package az.atl.academy.employees.app.repository;

import az.atl.academy.employees.app.dto.DepartmentDto;
import az.atl.academy.employees.app.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    void insertEmployee(Employee employee);

    void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2);

    void updateEmployee(Long employeeId, Employee employee);

    int deleteEmployee(Long employeeId);

    Long getLocationId(String countryId);

    List<Employee> getEmployees();

    Employee getEmployee(Long employeeId);
}
