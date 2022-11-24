package az.atl.academy.lesson32task.repository.impl;

import az.atl.academy.lesson32task.dto.DepartmentDto;
import az.atl.academy.lesson32task.dto.EmployeeDto;
import az.atl.academy.lesson32task.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
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
    public List<DepartmentDto> getDepartments() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD);
             Statement statement = connection.createStatement()) {
            String SQL = "select * from departments d inner join locations l on d.location_id = l.location_id";
            ResultSet rs = statement.executeQuery(SQL);

            List<DepartmentDto> departments = new ArrayList<>();
            while (rs.next()) {
                DepartmentDto department = new DepartmentDto();
                department.setDepartmentId(rs.getLong("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setLocationId(rs.getLong("location_id"));
                department.setStreetAddress(rs.getString("street_address"));
                department.setPostalCode(rs.getString("postal_code"));
                department.setCity(rs.getString("city"));
                department.setStateProvince(rs.getString("state_province"));
                department.setCountryId(rs.getString("country_id"));

                departments.add(department);
            }
            return departments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<DepartmentDto> getDepartment(Long departmentId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD)) {
            String SQL = "select * from departments d " +
                    "inner join locations l on d.location_id = l.location_id " +
                    "where d.department_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, departmentId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DepartmentDto department = new DepartmentDto();
                department.setDepartmentId(resultSet.getLong("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setLocationId(resultSet.getLong("location_id"));
                department.setStreetAddress(resultSet.getString("street_address"));
                department.setPostalCode(resultSet.getString("postal_code"));
                department.setCity(resultSet.getString("city"));
                department.setStateProvince(resultSet.getString("state_province"));
                department.setCity(resultSet.getString("city"));
                department.setCountryId(resultSet.getString("country_id"));
                return new ResponseEntity<>(department, HttpStatus.OK);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public int insertEmployee(EmployeeDto employee) {
        String SQL = "insert into employees" +
                "(first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
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
    public int updateEmployee(Long employeeId, EmployeeDto employee) {
        String SQL = "update employees " +
                "set first_name = ?, last_name =  ?, email = ?, " +
                "phone_number = ?, hire_date = ?, job_id = ?, " +
                "salary = ?, manager_id = ?, department_id = ? " +
                "where employee_id = ?";
        return jdbcTemplate.update(
                SQL, employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getPhoneNumber(), employee.getHireDate(), employee.getJobId(),
                employee.getSalary(), employee.getManagerId(),
                employee.getDepartmentId(), employeeId
        );
    }

    @Override
    public int deleteEmployee(Long employeeId) {
        String SQL = "delete from employees where employee_id = ? ";
        return jdbcTemplate.update(SQL, employeeId);
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
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD);
             Statement statement = connection.createStatement()) {
            String SQL = "select * from employees";
            ResultSet rs = statement.executeQuery(SQL);

            List<EmployeeDto> employees = new ArrayList<>();
            while (rs.next()) {
                EmployeeDto employee = new EmployeeDto();
                employee.setEmployeeId(rs.getLong("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phone_number"));
                employee.setHireDate(rs.getDate("hire_date"));
                employee.setJobId(rs.getLong("job_id"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setManagerId(rs.getLong("manager_id"));
                employee.setDepartmentId(rs.getLong("department_id"));

                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployee(Long employeeId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD)) {
            String SQL = "select * from employees where employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                EmployeeDto employee = new EmployeeDto();
                employee.setEmployeeId(resultSet.getLong("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setHireDate(resultSet.getDate("hire_date"));
                employee.setJobId(resultSet.getLong("job_id"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setManagerId(resultSet.getLong("manager_id"));
                employee.setDepartmentId(resultSet.getLong("department_id"));

                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
