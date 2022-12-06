package az.atl.academy.employees.app.service;

import az.atl.academy.employees.app.model.dto.DepartmentDto;
import az.atl.academy.employees.app.model.request.DepartmentRequest;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getDepartments();

    DepartmentDto getDepartment(Long departmentId);

    DepartmentDto insertDepartment(DepartmentRequest department);

    void updateDepartment(Long departmentId, DepartmentRequest department);

    void deleteDepartment(Long departmentId);
}
