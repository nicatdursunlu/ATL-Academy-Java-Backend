package az.atl.academy.employees.app.repository;

import az.atl.academy.employees.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2);
//
//    Long getLocationId(String countryId);
}
