package az.atl.academy.employees.app.mapper;

import az.atl.academy.employees.app.dto.EmployeeDto;
import az.atl.academy.employees.app.model.Employee;

public class EmployeeMapper {
    public static Employee mapDtoToEntity(EmployeeDto employee) {
        return Employee.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .hireDate(employee.getHireDate())
                .jobId(employee.getJobId())
                .salary(employee.getSalary())
                .departmentId(employee.getDepartmentId())
                .managerId(employee.getManagerId())
                .build();
    }

    public static EmployeeDto mapEntityToDto(Employee employee) {
        return EmployeeDto.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .hireDate(employee.getHireDate())
                .jobId(employee.getJobId())
                .salary(employee.getSalary())
                .departmentId(employee.getDepartmentId())
                .managerId(employee.getManagerId())
                .build();
    }
}
