package az.academy.atl.practice;

import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JdbcDemo {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        getEmployees();
        System.out.println("Salary: " + getEmployeeSalaryById(101L));
        System.out.println("Insert job: " + insertNewJob());
        insertNewJobBatch();
        deleteJobById(21L);
        updateJobById();
    }

    private static void getEmployees() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("employee_id"));
                System.out.print("\tFirst name: " + resultSet.getString("first_name"));
                System.out.print("\tLast name: " + resultSet.getString("last_name"));
                System.out.println("\tSalary: " + resultSet.getDouble("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static BigDecimal getEmployeeSalaryById(Long employeeId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("create or replace function getsalaryofemployee(employeeid integer) returns NUMERIC\n" +
                    "   language plpgsql\n" +
                    "as\n" +
                    "$$\n" +
                    "Declare\n" +
                    "   salary NUMERIC(8, 2);\n" +
                    "begin\n" +
                    "   select e.salary\n" +
                    "   into salary\n" +
                    "   from employees e\n" +
                    "   where e.employee_id = employeeId;\n" +
                    "   return salary;\n" +
                    "end;\n" +
                    "$$;"
            );
            statement.close();

            connection.setAutoCommit(false);

            CallableStatement callableStatement = connection.prepareCall("{ ? = call getsalaryofemployee(?) }");
            callableStatement.registerOutParameter(1, Types.NUMERIC);
            callableStatement.setObject(2, employeeId, Types.OTHER);
            callableStatement.execute();
            return callableStatement.getBigDecimal(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Long insertNewJob() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into jobs(job_id, job_title, min_salary, max_salary) values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, 20L);
            preparedStatement.setString(2, "Senior Software Developer");
            preparedStatement.setDouble(3, 5000.00);
            preparedStatement.setDouble(4, 10000.00);
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

    private static void insertNewJobBatch() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into jobs(job_id, job_title, min_salary, max_salary) values (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, 21L);
            preparedStatement.setString(2, "Junior Front-End Developer");
            preparedStatement.setDouble(3, 1200.00);
            preparedStatement.setDouble(4, 1400.00);
            preparedStatement.addBatch();

            preparedStatement.setLong(1, 22L);
            preparedStatement.setString(2, "Junior Back-End Developer");
            preparedStatement.setDouble(3, 1400.00);
            preparedStatement.setDouble(4, 1700.00);
            preparedStatement.addBatch();

            preparedStatement.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteJobById(Long jobId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from jobs where job_id = ?",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setLong(1, jobId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateJobById() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update jobs set job_title = ?, min_salary = ?, max_salary = ? where job_id = ?",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, "Back-End Developer");
            preparedStatement.setDouble(2, 2000.00);
            preparedStatement.setDouble(3, 4000.00);
            preparedStatement.setLong(4, 22L);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
