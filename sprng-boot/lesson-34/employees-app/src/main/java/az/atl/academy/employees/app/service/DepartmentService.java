package az.atl.academy.employees.app.service;

import az.atl.academy.employees.app.dto.DepartmentDto;

import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getDepartments();

    DepartmentDto getDepartment(Long departmentId);

    void insertDepartment(DepartmentDto department);

    void updateDepartment(Long departmentId, DepartmentDto department);

    void deleteDepartment(Long departmentId);
}
