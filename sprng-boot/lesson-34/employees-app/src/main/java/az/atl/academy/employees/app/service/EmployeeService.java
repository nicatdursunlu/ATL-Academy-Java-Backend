package az.atl.academy.employees.app.service;

import az.atl.academy.employees.app.dto.EmployeeDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    void uploadEmployeePhoto(MultipartFile file);

    void insertEmployee(EmployeeDto employeeDto, MultipartFile file);

//    public void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2) {
//        employeeRepository.insertNewDepartmentsBatch(department1, department2);
//    }

    void updateEmployee(Long employeeId, EmployeeDto employee);

    void deleteEmployee(Long employeeId);

    List<EmployeeDto> getEmployees();

    EmployeeDto getEmployee(Long employeeId);
}
