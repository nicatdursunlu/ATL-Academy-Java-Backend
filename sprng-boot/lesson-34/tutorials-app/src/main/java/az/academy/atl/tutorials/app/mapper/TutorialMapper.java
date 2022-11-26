package az.academy.atl.tutorials.app.mapper;

import az.academy.atl.tutorials.app.dto.TutorialDto;
import az.academy.atl.tutorials.app.model.Tutorial;

public class TutorialMapper {

    public static Tutorial mapDtoToEntity(TutorialDto tutorial) {
        return Tutorial.builder()
                .id(tutorial.getId())
                .title(tutorial.getTitle())
                .description(tutorial.getDescription())
                .published(false)
                .build();
    }

    public static TutorialDto mapEntityToDto(Tutorial tutorial) {
        return TutorialDto.builder()
                .id(tutorial.getId())
                .title(tutorial.getTitle())
                .description(tutorial.getDescription())
                .published(tutorial.getPublished())
                .build();
    }
}
