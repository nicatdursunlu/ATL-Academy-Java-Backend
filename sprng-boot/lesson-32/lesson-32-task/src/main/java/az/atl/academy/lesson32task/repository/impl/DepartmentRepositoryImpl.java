package az.atl.academy.lesson32task.repository.impl;

import az.atl.academy.lesson32task.dto.DepartmentDto;
import az.atl.academy.lesson32task.repository.DepartmentRepository;
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
public class DepartmentRepositoryImpl implements DepartmentRepository {

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
}
