package az.atl.academy.employees.app.repository;

import az.atl.academy.employees.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
//    List<Department> getDepartments();
//
//    Department getDepartment(Long departmentId);
//
//    void insertDepartment(Department department);
//
//    void updateDepartment(Long departmentId, Department department);
//
//    int deleteDepartment(Long departmentId);
}