package az.atl.academy.employees.app.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/departments")
@Api(tags = "Department Controller")
public class DepartmentController {

//    private final DepartmentService departmentService;
//
//    @GetMapping
//    @ApiOperation(value = "Getting All Departments")
//    public ResponseEntity<List<DepartmentDto>> getDepartments() {
//        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    @ApiOperation(value = "Get Department by Id")
//    public ResponseEntity<DepartmentDto> getDepartment(
//            @PathVariable("id")
//            @ApiParam(name = "id", value = "Department id", example = "100") Long departmentId) {
//        return new ResponseEntity<>(departmentService.getDepartment(departmentId), HttpStatus.OK);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation(value = "Insert Department")
//    public ResponseEntity<String> insertDepartment(@RequestBody DepartmentDto department) {
//        departmentService.insertDepartment(department);
//        return new ResponseEntity<>("Department was created successfully!", HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    @ApiOperation(value = "Update Department")
//    public ResponseEntity<String> updateDepartment(
//            @PathVariable("id")
//            @ApiParam(name = "id", value = "Department id", example = "100") Long departmentId,
//            @RequestBody DepartmentDto department) {
//        departmentService.updateDepartment(departmentId, department);
//        return new ResponseEntity<>("Department was updated successfully!", HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    @ApiOperation(value = "Delete Department by Id")
//    public ResponseEntity<String> deleteDepartment(
//            @PathVariable("id")
//            @ApiParam(name = "id", value = "Department id", example = "100") Long departmentId) {
//        departmentService.deleteDepartment(departmentId);
//        return new ResponseEntity<>("Department was deleted successfully!", HttpStatus.OK);
//    }
}
