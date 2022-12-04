package az.academy.atl.tutorials.app.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorialRequest {
    @ApiModelProperty(value = "Tutorial's title", required = true)
    private String title;

    @ApiModelProperty(value = "Tutorial's description", required = true)
    private String description;

    @ApiModelProperty(value = "Is Tutorial published", required = true)
    private Boolean published;
}
