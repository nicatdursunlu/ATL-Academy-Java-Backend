package az.academy.atl.tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task5 {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=123456";

    public static void main(String[] args) {
        deleteEmployee(207L);
    }

    private static void deleteEmployee(Long employeeId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from employees where employee_id = ? "
            );
            preparedStatement.setLong(1, employeeId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
