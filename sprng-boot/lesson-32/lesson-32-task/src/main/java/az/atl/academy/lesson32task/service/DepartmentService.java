package az.atl.academy.lesson32task.service;

import az.atl.academy.lesson32task.dto.DepartmentDto;
import az.atl.academy.lesson32task.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> getDepartments() {
        return departmentRepository.getDepartments();
    }

    public ResponseEntity<DepartmentDto> getDepartment(Long departmentId) {
        return departmentRepository.getDepartment(departmentId);
    }
}
