package az.academy.atl.tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task3 {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=123456";

    public static void main(String[] args) {
        System.out.println("LocationId: " + getLocationId("CA"));
        insertNewDepartmentsBatch(getLocationId("CA"));
    }

    private static Long getLocationId(String countryId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from locations where country_id = ?"
            );
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

    private static void insertNewDepartmentsBatch(Long locationId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into departments values (?, ?, ?)"
            );
            preparedStatement.setLong(1, 12);
            preparedStatement.setString(2, "Artificial Intelligence");
            preparedStatement.setLong(3, locationId);
            preparedStatement.addBatch();

            preparedStatement.setLong(1, 13);
            preparedStatement.setString(2, "Software Development");
            preparedStatement.setLong(3, locationId);
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
