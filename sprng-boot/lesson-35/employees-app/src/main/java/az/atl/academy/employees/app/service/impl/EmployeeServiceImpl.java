package az.atl.academy.employees.app.service.impl;

import az.atl.academy.employees.app.entity.Employee;
import az.atl.academy.employees.app.exception.EmployeeNotFoundException;
import az.atl.academy.employees.app.mapper.EmployeeMapper;
import az.atl.academy.employees.app.model.constants.ExceptionConstants;
import az.atl.academy.employees.app.model.dto.EmployeeDto;
import az.atl.academy.employees.app.model.request.EmployeeRequest;
import az.atl.academy.employees.app.repository.EmployeeRepository;
import az.atl.academy.employees.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeDto insertEmployee(EmployeeRequest employeeRequest) {
        try {
            log.info("EmployeeService.insertEmployee.start");
            Employee employee = employeeRepository.save(EmployeeMapper.mapRequestToEntity(employeeRequest));
            log.info("EmployeeService.insertEmployee.end");
            return EmployeeMapper.mapEntityToDto(employee);
        } catch (Exception e) {
            log.error("EmployeeService.insertEmployee.  error");
            throw new RuntimeException("Employee can not inserted!");
        }
    }

    public void updateEmployee(Long employeeId, EmployeeDto employee) {
        log.info("EmployeeService.updateEmployee.start with id : {}", employeeId);
        Employee oldEmployee = fetchEmployeeIfExists(employeeId);
        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
        oldEmployee.setEmail(employee.getEmail());
        oldEmployee.setPhoneNumber(employee.getPhoneNumber());
        oldEmployee.setHireDate(employee.getHireDate());
        oldEmployee.setSalary(employee.getSalary());
        oldEmployee.setJobId(employee.getJobId());
        oldEmployee.setManagerId(employee.getManagerId());
        oldEmployee.setDepartmentId(employee.getDepartmentId());
        employeeRepository.save(oldEmployee);
        log.info("EmployeeService.updateEmployee.end with id : {}", employeeId);
    }

    public void deleteEmployee(Long employeeId) {
        try {
            log.info("EmployeeService.deleteEmployee.start with id : {}", employeeId);
            employeeRepository.deleteById(employeeId);
            log.info("EmployeeService.deleteEmployee.end with id : {}", employeeId);
        } catch (Exception e) {
            log.error("EmployeeService.deleteEmployee.error with id: {}", employeeId);
            throw new EmployeeNotFoundException(String.format("Employee with id %s doesn't exist", employeeId));
        }
    }

    public List<EmployeeDto> getEmployees() {
        log.info("EmployeeService.getEmployees.start");
        List<EmployeeDto> employees = employeeRepository
                .findAll()
                .stream()
                .map(EmployeeMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("EmployeeService.getEmployees.end");
        return employees;
    }

    public EmployeeDto getEmployee(Long employeeId) {
        log.info("EmployeeService.getEmployee.start with id: {}", employeeId);
        var employee = fetchEmployeeIfExists(employeeId);
        var employeeDto = EmployeeMapper.mapEntityToDto(employee);
        log.info("EmployeeService.getEmployee.end with id: {}", employeeId);
        return employeeDto;
    }

    private Employee fetchEmployeeIfExists(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> {
            log.error("EmployeeService.fetchEmployeeIfExists.error with id: {}", id);
            throw new EmployeeNotFoundException(String.format(
                    ExceptionConstants.EMPLOYEE_NOT_FOUND_MESSAGE, id));
        });
    }
}