package az.atl.academy.lesson32task.repository.impl;

import az.atl.academy.lesson32task.dto.DepartmentDto;
import az.atl.academy.lesson32task.dto.EmployeeDto;
import az.atl.academy.lesson32task.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.url:jdbc:postgresql://localhost:5432/postgres}")
    private String JDBC_URL;

    @Value("${spring.datasource.username:postgres}")
    private String USER;

    @Value("${spring.datasource.password:123456}")
    private String PWD;

    @Override
    public void insertEmployee(EmployeeDto employee) {
        String SQL = "insert into employees" +
                "(first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                SQL, employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhoneNumber(),
                employee.getHireDate(), employee.getJobId(), employee.getSalary(), employee.getManagerId(),
                employee.getDepartmentId()
        );
    }

    @Override
    public void insertNewDepartmentsBatch(DepartmentDto department1, DepartmentDto department2) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD)) {
            String SQL = "insert into departments values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, department1.getDepartmentId());
            preparedStatement.setString(2, department1.getDepartmentName());
            preparedStatement.setLong(3, department1.getLocationId());
            preparedStatement.addBatch();

            preparedStatement.setLong(1, department2.getDepartmentId());
            preparedStatement.setString(2, department2.getDepartmentName());
            preparedStatement.setLong(3, department2.getLocationId());
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(Long employeeId, EmployeeDto employee) {
        String SQL = "update employees " +
                "set first_name = ?, last_name =  ?, email = ?, " +
                "phone_number = ?, hire_date = ?, job_id = ?, " +
                "salary = ?, manager_id = ?, department_id = ? " +
                "where employee_id = ?";
        jdbcTemplate.update(
                SQL, employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getPhoneNumber(), employee.getHireDate(), employee.getJobId(),
                employee.getSalary(), employee.getManagerId(),
                employee.getDepartmentId(), employeeId
        );
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        String SQL = "delete from employees where employee_id = ? ";
        jdbcTemplate.update(SQL, employeeId);
    }

    @Override
    public Long getLocationId(String countryId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD)) {
            String SQL = "select location_id from locations where country_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, countryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("location_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1L;
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        String SQL = "select * from employees";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(EmployeeDto.class));
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        try {
            String SQL = "select * from employees where employee_id = ?";
            return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(EmployeeDto.class), employeeId);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
