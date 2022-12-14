package az.atl.academy.employees.app.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Department DTO", description = "Model who represents a department entity")
public class DepartmentDto {
    @ApiModelProperty(value = "Department's id", example = "100")
    private Long departmentId;

    @ApiModelProperty(value = "Department's name", example = "Software Development")
    private String departmentName;

    @ApiModelProperty(value = "Department's locationId", example = "1700")
    private Long locationId;
}
