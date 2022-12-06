package az.atl.academy.employees.app.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "EmployeeModel", description = "Model who represents a employee entity")
public class EmployeeDto {
    @ApiModelProperty(value = "Employee's id", example = "100")
    private Long employeeId;

    @ApiModelProperty(value = "Employee's firstName", example = "Nijat")
    private String firstName;

    @ApiModelProperty(value = "Employee's lastName", example = "Dursunlu")
    private String lastName;

    @ApiModelProperty(value = "Employee's email", example = "nijat,dursunlu@gmail.com")
    private String email;

    @ApiModelProperty(value = "Employee's phoneNumber", example = "+994513613025")
    private String phoneNumber;

    @ApiModelProperty(value = "Employee's hireDate", example = "2021-10-01")
    private LocalDate hireDate;

    @ApiModelProperty(value = "Employee's jobId", example = "5")
    private Long jobId;

    @ApiModelProperty(value = "Employee's salary", example = "17000.00")
    private Double salary;

    @ApiModelProperty(value = "Employee's managerId", example = "100")
    private Long managerId;

    @ApiModelProperty(value = "Employee's departmentId", example = "9")
    private Long departmentId;
}