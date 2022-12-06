package az.atl.academy.employees.app.repository.impl;

import az.atl.academy.employees.app.model.Department;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartmentRepositoryImpl  {

    private final JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.url:jdbc:postgresql://localhost:5432/postgres}")
    private String JDBC_URL;

    @Value("${spring.datasource.username:postgres}")
    private String USER;

    @Value("${spring.datasource.password:123456}")
    private String PWD;

    public List<Department> getDepartments() {
        String SQL = "select * from departments d inner join locations l on d.location_id = l.location_id";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Department.class));
    }

    public Department getDepartment(Long departmentId) {
        try {
            String SQL = "select * from departments d " +
                    "inner join locations l on d.location_id = l.location_id " +
                    "where d.department_id = ?";
            return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Department.class), departmentId);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void insertDepartment(Department department) {
        String SQL = "insert into departments(department_name, location_id) values(?, ?)";
        jdbcTemplate.update(SQL, department.getDepartmentName(), department.getLocationId());
    }

    public void updateDepartment(Long departmentId, Department department) {
        String SQL = "update departments set department_name = ?, location_id =  ? where department_id = ?";
        jdbcTemplate.update(SQL, department.getDepartmentName(), department.getLocationId(), departmentId);
    }

    public int deleteDepartment(Long departmentId) {
        String SQL = "delete from departments where department_id = ? ";
        return jdbcTemplate.update(SQL, departmentId);
    }
}
