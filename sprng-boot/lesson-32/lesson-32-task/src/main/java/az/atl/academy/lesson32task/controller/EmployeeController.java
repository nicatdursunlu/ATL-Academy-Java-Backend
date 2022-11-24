package az.atl.academy.lesson32task.controller;


import az.atl.academy.lesson32task.dto.DepartmentDto;
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
    public int insertEmployee(@RequestBody EmployeeDto employee) {
        return employeeService.insertEmployee(employee);
    }

//    @PostMapping("/departments")
//    public void insertNewDepartmentsBatch(@RequestBody DepartmentDto department1,
//                                          @RequestBody DepartmentDto department2) {
//        employeeService.insertNewDepartmentsBatch(department1, department2);
//    }

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employee) {
        employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}