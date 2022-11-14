package az.academy.atl.repository.impl;

import az.academy.atl.model.Department;
import az.academy.atl.model.Employee;
import az.academy.atl.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PWD = "123456";

    @Override
    public void getDepartments() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD);
             Statement statement = connection.createStatement()) {
            String SQL = "select * from departments d inner join locations l on d.location_id = l.location_id";
            ResultSet rs = statement.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(
                        "Department name: " + rs.getString("department_name") + " " +
                                "\tLocation id: " + rs.getInt("location_id") + " " +
                                "\tStreet address: " + rs.getString("street_address") + " " +
                                "\tCity: " + rs.getString("city") + " " +
                                "\tState province: " + rs.getString("state_province") + " " +
                                "\tCountry id: " + rs.getString("country_id")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long insertEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PWD)) {
            String SQL = "insert into employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SQL, Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setLong(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setDate(6, employee.getHireDate());
            preparedStatement.setLong(7, employee.getJobId());
            preparedStatement.setDouble(8, employee.getSalary());
            preparedStatement.setLong(9, employee.getManagerId());
            preparedStatement.setLong(10, employee.getDepartmentId());
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
    public void insertNewDepartmentsBatch(Department department1, Department department2) {
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
    public void updateEmployee(Long employeeId, Employee employee) {
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

}
