package az.atl.academy.employees.app.dto;

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
@ApiModel(value = "DepartmentModel", description = "Model who represents a department entity")
public class DepartmentDto {
    @ApiModelProperty(value = "Department's id", example = "100")
    private Long departmentId;

    @ApiModelProperty(value = "Department's name", example = "Software Development")
    private String departmentName;

    @ApiModelProperty(value = "Department's locationId", example = "1700")
    private Long locationId;

    @ApiModelProperty(value = "Department's streetAddress", example = "2004 Charade Rd")
    private String streetAddress;

    @ApiModelProperty(value = "Department's postalCode", example = "98199")
    private String postalCode;

    @ApiModelProperty(value = "Department's city", example = "Seattle")
    private String city;

    @ApiModelProperty(value = "Department's stateProvince", example = "Washington")
    private String stateProvince;

    @ApiModelProperty(value = "Department's countryId", example = "US")
    private String countryId;
}
