package az.atl.academy.employees.app.repository;

import az.atl.academy.employees.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findAllByIsDeletedFalse();
}