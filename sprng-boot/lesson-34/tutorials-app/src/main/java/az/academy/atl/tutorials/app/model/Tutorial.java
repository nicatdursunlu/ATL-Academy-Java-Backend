package az.academy.atl.tutorials.app.model;

import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
    private Long id;
    private String title;
    private String description;
    private Boolean published;
}
