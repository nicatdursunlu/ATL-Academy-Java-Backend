package az.academy.atl.repository;

import az.academy.atl.model.Department;
import az.academy.atl.model.Employee;

public interface EmployeeRepository {

    void getDepartments();

    Long insertEmployee(Employee employee);

    void insertNewDepartmentsBatch(Department department1, Department department2);

    void updateEmployee(Long employeeId, Employee employee);

    void deleteEmployee(Long employeeId);

    Long getLocationId(String countryId);
}
