package az.atl.academy.lesson32task.repository;

import az.atl.academy.lesson32task.dto.DepartmentDto;
import az.atl.academy.lesson32task.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeRepository {

    void insertEmployee(EmployeeDto employee);

    void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2);

    void updateEmployee(Long employeeId, EmployeeDto employee);

    void deleteEmployee(Long employeeId);

    Long getLocationId(String countryId);

    List<EmployeeDto> getEmployees();

    EmployeeDto getEmployee(Long employeeId);
}
