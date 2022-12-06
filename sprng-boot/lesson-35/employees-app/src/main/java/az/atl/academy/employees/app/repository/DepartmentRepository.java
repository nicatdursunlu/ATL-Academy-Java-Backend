package az.atl.academy.employees.app.repository;

import az.atl.academy.employees.app.model.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> getDepartments();

    Department getDepartment(Long departmentId);

    void insertDepartment(Department department);

    void updateDepartment(Long departmentId, Department department);

    int deleteDepartment(Long departmentId);
}