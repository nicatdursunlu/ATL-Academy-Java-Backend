package az.academy.atl.tutorials.app.dto;

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
public class TutorialDto {
    private Long id;
    private String title;
    private String description;
    private Boolean published;
}
