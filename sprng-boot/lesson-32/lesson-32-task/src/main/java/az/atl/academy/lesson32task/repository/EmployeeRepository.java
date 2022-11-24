package az.atl.academy.lesson32task.repository;

import az.atl.academy.lesson32task.dto.DepartmentDto;
import az.atl.academy.lesson32task.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeRepository {
    List<DepartmentDto> getDepartments();

    ResponseEntity<DepartmentDto> getDepartment(Long departmentId);

    int insertEmployee(EmployeeDto employee);

    void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2);

    int updateEmployee(Long employeeId, EmployeeDto employee);

    int deleteEmployee(Long employeeId);

    Long getLocationId(String countryId);

    List<EmployeeDto> getEmployees();

    ResponseEntity<EmployeeDto> getEmployee(Long employeeId);
}
