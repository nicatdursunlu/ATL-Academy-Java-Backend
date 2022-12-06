package az.atl.academy.employees.app.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {
    @ApiModelProperty(value = "Department's name", example = "Software Development")
    private String departmentName;

    @ApiModelProperty(value = "Department's locationId", example = "1700")
    private Long locationId;
}
