package az.academy.atl.lesson30task.repository;

import az.academy.atl.lesson30task.dto.DepartmentDto;
import az.academy.atl.lesson30task.dto.EmployeeDto;
import az.academy.atl.lesson30task.model.Department;
import az.academy.atl.lesson30task.model.Employee;
import org.springframework.http.ResponseEntity;

import java.sql.ResultSet;
import java.util.List;

public interface EmployeeRepository {
    List<DepartmentDto> getDepartments();

    Long insertEmployee(EmployeeDto employee);

    void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2);

    void updateEmployee(Long employeeId, EmployeeDto employee);

    void deleteEmployee(Long employeeId);

    Long getLocationId(String countryId);

    List<EmployeeDto> getEmployees();

    ResponseEntity<EmployeeDto> getEmployee(Long employeeId);
}
