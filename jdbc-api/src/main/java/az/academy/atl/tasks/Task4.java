package az.academy.atl.tasks;

import az.academy.atl.model.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task4 {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=123456";

    public static void main(String[] args) {
        Employee employee = new Employee(
                207L, "Nijat updated", "Dursunlu updated", "nijat.dursunlu.updated@gmail.com",
                "+994513613025", new Date(20211001L), 9L,
                2000.00, 102L, 6L
        );
        updateEmployee(employee.getEmployeeId(), employee);
    }

    private static void updateEmployee(Long employeeId, Employee employee) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
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
}
