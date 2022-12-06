package az.atl.academy.employees.app.mapper;

import az.atl.academy.employees.app.entity.Department;
import az.atl.academy.employees.app.model.dto.DepartmentDto;
import az.atl.academy.employees.app.model.request.DepartmentRequest;

public class DepartmentMapper {
    public static Department mapRequestToEntity(DepartmentRequest departmentRequest) {
        return Department.builder()
                .departmentName(departmentRequest.getDepartmentName())
                .locationId(departmentRequest.getLocationId())
                .build();
    }

    public static Department mapDtoToEntity(DepartmentDto department) {
        return Department.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .locationId(department.getLocationId())
                .build();
    }

    public static DepartmentDto mapEntityToDto(Department department) {
        return DepartmentDto.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .locationId(department.getLocationId())
                .build();
    }
}
