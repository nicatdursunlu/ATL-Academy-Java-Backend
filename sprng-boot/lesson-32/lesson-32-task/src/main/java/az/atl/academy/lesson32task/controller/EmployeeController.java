package az.atl.academy.lesson32task.controller;

import az.atl.academy.lesson32task.dto.EmployeeDto;
import az.atl.academy.lesson32task.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> insertEmployee(@RequestBody EmployeeDto employee) {
        employeeService.insertEmployee(employee);
        return new ResponseEntity<>("Employee was added successfully!", HttpStatus.CREATED);
    }

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employee) {
        employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>("Employee was updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee was deleted successfully!", HttpStatus.OK);
    }
}