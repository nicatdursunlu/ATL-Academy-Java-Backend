package az.atl.academy.employees.app.controller;


import az.atl.academy.employees.app.dto.DepartmentDto;
import az.atl.academy.employees.app.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long departmentId) {
        return new ResponseEntity<>(departmentService.getDepartment(departmentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> insertDepartment(@RequestBody DepartmentDto department) {
        departmentService.insertDepartment(department);
        return new ResponseEntity<>("Department was created successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto department) {
        departmentService.updateDepartment(departmentId, department);
        return new ResponseEntity<>("Department was updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Department was deleted successfully!", HttpStatus.OK);
    }
}
