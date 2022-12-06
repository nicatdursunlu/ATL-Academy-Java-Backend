package az.atl.academy.employees.app.mapper;

import az.atl.academy.employees.app.model.dto.DepartmentDto;
import az.atl.academy.employees.app.model.Department;

public class DepartmentMapper {
    public static Department mapDtoToEntity(DepartmentDto department) {
        return Department.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .locationId(department.getLocationId())
                .streetAddress(department.getStreetAddress())
                .postalCode(department.getPostalCode())
                .city(department.getCity())
                .stateProvince(department.getStateProvince())
                .countryId(department.getCountryId())
                .build();
    }

    public static DepartmentDto mapEntityToDto(Department department) {
        return DepartmentDto.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .locationId(department.getLocationId())
                .streetAddress(department.getStreetAddress())
                .postalCode(department.getPostalCode())
                .city(department.getCity())
                .stateProvince(department.getStateProvince())
                .countryId(department.getCountryId())
                .build();
    }
}
