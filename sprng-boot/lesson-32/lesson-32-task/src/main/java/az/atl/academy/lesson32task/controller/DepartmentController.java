package az.atl.academy.lesson32task.controller;

import az.atl.academy.lesson32task.dto.DepartmentDto;
import az.atl.academy.lesson32task.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping
    public List<DepartmentDto> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }
}
