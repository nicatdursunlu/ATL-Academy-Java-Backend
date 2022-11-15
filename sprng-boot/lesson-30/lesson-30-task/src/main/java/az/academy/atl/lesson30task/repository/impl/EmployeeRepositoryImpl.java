package az.academy.atl.lesson30task.repository.impl;

import az.academy.atl.lesson30task.dto.DepartmentDto;
import az.academy.atl.lesson30task.dto.EmployeeDto;
import az.academy.atl.lesson30task.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PWD = "123456";

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
    public Long insertEmployee(EmployeeDto employee) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD)) {
            String SQL = "insert into employees" +
                    "(first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id)" +
                    " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQL, Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, employee.getHireDate());
            preparedStatement.setLong(6, employee.getJobId());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setLong(8, employee.getManagerId());
            preparedStatement.setLong(9, employee.getDepartmentId());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1L;
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
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD)) {
            String SQL = "update employees " +
                    "set first_name = ?, last_name =  ?, email = ?, " +
                    "phone_number = ?, hire_date = ?, job_id = ?, " +
                    "salary = ?, manager_id = ?, department_id = ? " +
                    "where employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, employee.getHireDate());
            preparedStatement.setLong(6, employee.getJobId());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setLong(8, employee.getManagerId());
            preparedStatement.setLong(9, employee.getDepartmentId());
            preparedStatement.setLong(10, employeeId);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD)) {
            String SQL = "delete from employees where employee_id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, employeeId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
