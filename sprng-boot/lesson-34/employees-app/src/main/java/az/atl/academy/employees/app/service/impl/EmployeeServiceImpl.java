package az.atl.academy.employees.app.service.impl;

import az.atl.academy.employees.app.dto.DepartmentDto;
import az.atl.academy.employees.app.dto.EmployeeDto;
import az.atl.academy.employees.app.exception.EmployeeNotFoundException;
import az.atl.academy.employees.app.mapper.EmployeeMapper;
import az.atl.academy.employees.app.model.Employee;
import az.atl.academy.employees.app.model.constants.ExceptionConstants;
import az.atl.academy.employees.app.repository.EmployeeRepository;

import az.atl.academy.employees.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Path root = Paths.get("uploads");

    public void uploadEmployeePhoto(MultipartFile file) {
        try {
            log.info("EmployeeService.uploadEmployeePhoto.start");
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
            log.info("EmployeeService.uploadEmployeePhoto.end");
        } catch (Exception e) {
            log.error("EmployeeService.uploadEmployeePhoto.error", e);
            if (e instanceof FileAlreadyExistsException) {
                log.error("EmployeeService.uploadEmployeePhoto.error", e);
                throw new RuntimeException("already exists");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    public void insertEmployee(EmployeeDto employeeDto, MultipartFile file) {
        uploadEmployeePhoto(file);
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
            throw new EmployeeNotFoundException(String.format("Employee with id %s doesn't exist", employeeId));
        }
    }

    public void deleteEmployee(Long employeeId) {
        log.info("EmployeeService.deleteEmployee.start with id : {}", employeeId);
        int result = employeeRepository.deleteEmployee(employeeId);
        if (result == 0) {
            log.error("EmployeeService.deleteEmployee.error with id: {}", employeeId);
            throw new EmployeeNotFoundException(String.format("Employee with id %s doesn't exist", employeeId));
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
            throw new EmployeeNotFoundException(String.format(
                    ExceptionConstants.EMPLOYEE_NOT_FOUND_MESSAGE, employeeId));
        }
    }
}
