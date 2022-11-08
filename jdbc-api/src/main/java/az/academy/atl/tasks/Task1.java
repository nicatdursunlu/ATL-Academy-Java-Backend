package az.academy.atl.tasks;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Task1 {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=123456";

    public static void main(String[] args) {
        getDepartments();
    }

    private static void getDepartments() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement()) {
            String SQL = "select * from departments d inner join locations l on d.location_id = l.location_id";
            ResultSet rs = statement.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(
                        rs.getString("department_name") + " " +
                                rs.getInt("location_id") + " " +
                                rs.getString("street_address") + " " +
                                rs.getString("city") + " " +
                                rs.getString("state_province") + " " +
                                rs.getString("country_id")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
