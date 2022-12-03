package az.atl.academy.employees.app.controller;

import az.atl.academy.employees.app.dto.EmployeeDto;
import az.atl.academy.employees.app.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
@Api(tags = "Employee Controller")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert Employee")
    public ResponseEntity<String> insertEmployee(@RequestBody EmployeeDto employee) {
        employeeService.insertEmployee(employee);
        return new ResponseEntity<>("Employee was added successfully!", HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Getting All Employees")
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Getting Employee by Id")
    public EmployeeDto getEmployee(
            @PathVariable("id")
            @ApiParam(name = "id", value = "Employee id", example = "100")
            Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Employee")
    public ResponseEntity<String> updateEmployee(
            @PathVariable("id")
            @ApiParam(name = "id", value = "Employee id", example = "100") Long employeeId,
            @RequestBody EmployeeDto employee) {
        employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>("Employee was updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Employee by Id")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable("id")
            @ApiParam(name = "id", value = "Employee id", example = "100") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee was deleted successfully!", HttpStatus.OK);
    }
}