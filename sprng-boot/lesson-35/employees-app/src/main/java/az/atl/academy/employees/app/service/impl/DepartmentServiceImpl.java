package az.atl.academy.employees.app.service.impl;

import az.atl.academy.employees.app.entity.Department;
import az.atl.academy.employees.app.exception.DepartmentNotFoundException;
import az.atl.academy.employees.app.mapper.DepartmentMapper;
import az.atl.academy.employees.app.model.constants.ExceptionConstants;
import az.atl.academy.employees.app.model.dto.DepartmentDto;
import az.atl.academy.employees.app.model.request.DepartmentRequest;
import az.atl.academy.employees.app.repository.DepartmentRepository;
import az.atl.academy.employees.app.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> getDepartments() {
        log.info("DepartmentService.getDepartments.start");
        List<DepartmentDto> departments = departmentRepository
                .findAll()
                .stream()
                .map(DepartmentMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("DepartmentService.getDepartments.end");
        return departments;
    }

    public DepartmentDto getDepartment(Long departmentId) {
        log.info("DepartmentService.getDepartment.start with id: {}", departmentId);
        Department department = fetchDepartmentIfExists(departmentId);
        DepartmentDto departmentDto = DepartmentMapper.mapEntityToDto(department);
        log.info("DepartmentService.getDepartment.end with id: {}", departmentId);
        return departmentDto;
    }

    public DepartmentDto insertDepartment(DepartmentRequest departmentRequest) {
        try {
            log.info("DepartmentService.insertDepartment.start");
            Department department = departmentRepository.save(DepartmentMapper.mapRequestToEntity(departmentRequest));
            log.info("DepartmentService.insertDepartment.end");
            return DepartmentMapper.mapEntityToDto(department);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("DepartmentService.insertDepartment.error with message: {}", e.getMessage());
            throw new RuntimeException("Department can not inserted!");
        }
    }

    public void updateDepartment(Long departmentId, DepartmentRequest department) {
        log.info("DepartmentService.updateDepartment.start with id: {}", departmentId);
        Department oldDepartment = fetchDepartmentIfExists(departmentId);
        oldDepartment.setDepartmentName(department.getDepartmentName());
        oldDepartment.setLocationId(department.getLocationId());
        departmentRepository.save(oldDepartment);
        log.info("DepartmentService.updateDepartment.end with id: {}", departmentId);
    }

    public void deleteDepartment(Long departmentId) {
        try {
            log.info("DepartmentService.deleteDepartment.start with id: {}", departmentId);
            departmentRepository.deleteById(departmentId);
            log.info("DepartmentService.deleteDepartment.end with id: {}", departmentId);
        } catch (Exception e) {
            log.error("DepartmentService.deleteDepartment.error with id: {}", departmentId);
            throw new DepartmentNotFoundException(String.format("Department with id %s not found", departmentId));
        }
    }

    private Department fetchDepartmentIfExists(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> {
            log.error("DepartmentService.getDepartment.error with id: {}", id);
            throw new DepartmentNotFoundException(
                    String.format(ExceptionConstants.DEPARTMENT_NOT_FOUND_MESSAGE, id));
        });
    }
}
