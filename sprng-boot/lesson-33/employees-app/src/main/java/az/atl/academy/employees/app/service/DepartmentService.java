package az.atl.academy.employees.app.service;

import az.atl.academy.employees.app.dto.DepartmentDto;
import az.atl.academy.employees.app.mapper.DepartmentMapper;
import az.atl.academy.employees.app.model.Department;
import az.atl.academy.employees.app.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> getDepartments() {
        log.info("DepartmentService.getDepartments.start");
        List<DepartmentDto> departments = departmentRepository
                .getDepartments()
                .stream()
                .map(DepartmentMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("DepartmentService.getDepartments.end");
        return departments;
    }

    public DepartmentDto getDepartment(Long departmentId) {
        log.info("DepartmentService.getDepartment.start with id: {}", departmentId);
        Department department = departmentRepository.getDepartment(departmentId);
        if (department != null) {
            DepartmentDto departmentDto = DepartmentMapper.mapEntityToDto(department);
            log.info("DepartmentService.getDepartment.end with id: {}", departmentId);
            return departmentDto;
        } else {
            log.error("DepartmentService.getDepartment.error with id: {}", departmentId);
            throw new RuntimeException("Department not found with id " + departmentId);
        }
    }

    public void insertDepartment(DepartmentDto department) {
        try {
            log.info("DepartmentService.insertDepartment.start");
            departmentRepository.insertDepartment(DepartmentMapper.mapDtoToEntity(department));
            log.info("DepartmentService.insertDepartment.end");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("DepartmentService.insertDepartment.error with message: {}", e.getMessage());
        }
    }

    public void updateDepartment(Long departmentId, DepartmentDto department) {
        log.info("DepartmentService.updateDepartment.start with id: {}", departmentId);
        Department oldDepartment = departmentRepository.getDepartment(departmentId);
        if (oldDepartment != null) {
            oldDepartment.setDepartmentName(department.getDepartmentName());
            oldDepartment.setLocationId(department.getLocationId());
            oldDepartment.setStreetAddress(department.getStreetAddress());
            oldDepartment.setPostalCode(department.getPostalCode());
            oldDepartment.setCity(department.getCity());
            oldDepartment.setStateProvince(department.getStateProvince());
            oldDepartment.setLocationId(department.getLocationId());
            departmentRepository.updateDepartment(departmentId, oldDepartment);
            log.info("DepartmentService.updateDepartment.end with id: {}", departmentId);
        } else {
            log.error("DepartmentService.updateDepartment.error with id: {}", department);
            throw new RuntimeException("Department not found with id " + department);
        }
    }

    public void deleteDepartment(Long departmentId) {
        log.info("DepartmentService.deleteDepartment.start with id: {}", departmentId);
        int result = departmentRepository.deleteDepartment(departmentId);
        if (result == 0) {
            log.error("DepartmentService.deleteDepartment.error with id: {}", departmentId);
            throw new RuntimeException("Department not found with id " + departmentId);
        } else
            log.info("DepartmentService.deleteDepartment.end with id: {}", departmentId);
    }
}
