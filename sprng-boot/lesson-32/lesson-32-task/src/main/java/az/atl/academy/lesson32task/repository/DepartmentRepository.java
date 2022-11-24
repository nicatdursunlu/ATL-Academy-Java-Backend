package az.atl.academy.lesson32task.repository;

import az.atl.academy.lesson32task.dto.DepartmentDto;

import java.util.List;

public interface DepartmentRepository {
    List<DepartmentDto> getDepartments();

    DepartmentDto getDepartment(Long departmentId);

    void insertDepartment(DepartmentDto department);

    void updateDepartment(Long departmentId, DepartmentDto department);

    void deleteDepartment(Long departmentId);
}