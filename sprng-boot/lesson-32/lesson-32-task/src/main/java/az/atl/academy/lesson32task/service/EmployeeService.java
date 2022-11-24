package az.atl.academy.lesson32task.service;

import az.atl.academy.lesson32task.dto.DepartmentDto;
import az.atl.academy.lesson32task.dto.EmployeeDto;
import az.atl.academy.lesson32task.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void insertEmployee(EmployeeDto employee) {
        employeeRepository.insertEmployee(employee);
    }

    public void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2) {
        employeeRepository.insertNewDepartmentsBatch(department1, department2);
    }

    public void updateEmployee(Long employeeId, EmployeeDto employee) {
        employeeRepository.updateEmployee(employeeId, employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteEmployee(employeeId);
    }

    public List<EmployeeDto> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public EmployeeDto getEmployee(Long employeeId) {
        return employeeRepository.getEmployee(employeeId);
    }
}
