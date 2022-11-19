package az.atl.academy.lesson31task.controller;

import az.atl.academy.lesson31task.dto.DepartmentDto;
import az.atl.academy.lesson31task.dto.EmployeeDto;
import az.atl.academy.lesson31task.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/departments")
    public List<DepartmentDto> getDepartments() {
        return employeeService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long departmentId) {
        return employeeService.getDepartment(departmentId);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Long insertEmployee(@RequestBody EmployeeDto employee) {
        return employeeService.insertEmployee(employee);
    }

    @PostMapping("/departments")
    public void insertNewDepartmentsBatch(@RequestBody DepartmentDto department1,
                                          @RequestBody DepartmentDto department2) {
        employeeService.insertNewDepartmentsBatch(department1, department2);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employee) {
        employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}