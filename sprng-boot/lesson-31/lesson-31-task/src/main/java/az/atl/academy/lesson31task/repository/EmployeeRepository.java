package az.atl.academy.lesson31task.repository;

import az.atl.academy.lesson31task.dto.DepartmentDto;
import az.atl.academy.lesson31task.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeRepository {
    List<DepartmentDto> getDepartments();

    ResponseEntity<DepartmentDto> getDepartment(Long departmentId);

    Long insertEmployee(EmployeeDto employee);

    void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2);

    void updateEmployee(Long employeeId, EmployeeDto employee);

    void deleteEmployee(Long employeeId);

    Long getLocationId(String countryId);

    List<EmployeeDto> getEmployees();

    ResponseEntity<EmployeeDto> getEmployee(Long employeeId);
}
