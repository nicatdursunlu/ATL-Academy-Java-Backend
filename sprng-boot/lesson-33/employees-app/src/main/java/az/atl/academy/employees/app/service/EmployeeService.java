package az.atl.academy.employees.app.service;

import az.atl.academy.employees.app.dto.DepartmentDto;
import az.atl.academy.employees.app.dto.EmployeeDto;
import az.atl.academy.employees.app.mapper.EmployeeMapper;
import az.atl.academy.employees.app.model.Employee;
import az.atl.academy.employees.app.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void insertEmployee(EmployeeDto employeeDto) {
        try {
            log.info("EmployeeService.insertEmployee.start");
            employeeRepository.insertEmployee(EmployeeMapper.mapDtoToEntity(employeeDto));
            log.info("EmployeeService.insertEmployee.end");
        } catch (Exception e) {
            log.error("EmployeeService.insertEmployee.error");
            throw new RuntimeException("Employee can not inserted!");
        }
    }

    public void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2) {
        employeeRepository.insertNewDepartmentsBatch(department1, department2);
    }

    public void updateEmployee(Long employeeId, EmployeeDto employee) {
        log.info("EmployeeService.updateEmployee.start with id : {}", employeeId);
        Employee oldEmployee = employeeRepository.getEmployee(employeeId);
        if (oldEmployee != null) {
            oldEmployee.setFirstName(employee.getFirstName());
            oldEmployee.setLastName(employee.getLastName());
            oldEmployee.setEmail(employee.getEmail());
            oldEmployee.setPhoneNumber(employee.getPhoneNumber());
            oldEmployee.setHireDate(employee.getHireDate());
            oldEmployee.setSalary(employee.getSalary());
            oldEmployee.setJobId(employee.getJobId());
            oldEmployee.setManagerId(employee.getManagerId());
            oldEmployee.setDepartmentId(employee.getDepartmentId());
            employeeRepository.updateEmployee(employeeId, oldEmployee);
            log.info("EmployeeService.updateEmployee.end with id : {}", employeeId);
        } else {
            log.error("EmployeeService.updateEmployee.error with id : {}", employeeId);
            throw new RuntimeException("Employee not found with id " + employee);
        }
    }

    public void deleteEmployee(Long employeeId) {
        log.info("EmployeeService.deleteEmployee.start with id : {}", employeeId);
        int result = employeeRepository.deleteEmployee(employeeId);
        if (result == 0) {
            log.error("EmployeeService.deleteEmployee.error with id: {}", employeeId);
            throw new RuntimeException("Employee not found with id " + employeeId);
        } else
            log.info("EmployeeService.deleteEmployee.end with id : {}", employeeId);
    }

    public List<EmployeeDto> getEmployees() {
        log.info("EmployeeService.getEmployees.start");
        List<EmployeeDto> employees = employeeRepository
                .getEmployees()
                .stream()
                .map(EmployeeMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("EmployeeService.getEmployees.end");
        return employees;
    }

    public EmployeeDto getEmployee(Long employeeId) {
        log.info("EmployeeService.getEmployee.start with id: {}", employeeId);
        Employee employee = employeeRepository.getEmployee(employeeId);
        if (employee != null) {
            EmployeeDto employeeDto = EmployeeMapper.mapEntityToDto(employee);
            log.info("EmployeeService.getEmployee.end with id: {}", employeeId);
            return employeeDto;
        } else {
            log.error("EmployeeService.getEmployee.error with id: {}", employeeId);
            throw new RuntimeException("Employee not found with id " + employeeId);
        }
    }
}
