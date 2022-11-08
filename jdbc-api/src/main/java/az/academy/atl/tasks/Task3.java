package az.academy.atl.tasks;

import az.academy.atl.model.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task3 {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=123456";

    public static void main(String[] args) {
        System.out.println("LocationId: " + getLocationId("CA"));

        Department department1 =
                new Department(12L, "Artificial Intelligence", getLocationId("CA"));
        Department department2 =
                new Department(13L, "Software Development", getLocationId("CA"));
        insertNewDepartmentsBatch(department1, department2);
    }

    private static Long getLocationId(String countryId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String SQL = "select location_id from locations where country_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, countryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Result: " + resultSet.getLong("location_id"));
                return resultSet.getLong("location_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1L;
    }

    private static void insertNewDepartmentsBatch(Department department1, Department department2) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
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
}
