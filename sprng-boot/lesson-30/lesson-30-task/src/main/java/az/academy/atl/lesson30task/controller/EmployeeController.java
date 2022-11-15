package az.academy.atl.lesson30task.controller;

import az.academy.atl.lesson30task.dto.DepartmentDto;
import az.academy.atl.lesson30task.dto.EmployeeDto;
import az.academy.atl.lesson30task.model.Department;
import az.academy.atl.lesson30task.model.Employee;
import az.academy.atl.lesson30task.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
