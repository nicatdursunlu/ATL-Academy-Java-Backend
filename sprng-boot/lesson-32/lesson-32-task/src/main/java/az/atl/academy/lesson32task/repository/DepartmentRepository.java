package az.atl.academy.lesson32task.repository;

import az.atl.academy.lesson32task.dto.DepartmentDto;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentRepository {
    List<DepartmentDto> getDepartments();

    ResponseEntity<DepartmentDto> getDepartment(Long departmentId);
}