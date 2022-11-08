package az.academy.atl.tasks;

import az.academy.atl.model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task2 {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=123456";

    public static void main(String[] args) {
        Employee employee = new Employee(
                207L, "Nijat", "Dursunlu", "nijat.dursunlu@gmail.com",
                "+994 51 361 30 25", new Date(20211001L), 9L,
                1500.00, 102L, 6L
        );
        System.out.println("Result: " + insertEmployee(employee));
    }

    private static Long insertEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
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
}
