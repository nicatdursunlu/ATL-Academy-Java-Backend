package az.academy.atl.tutorials.app.mapper;

import az.academy.atl.tutorials.app.model.dto.TutorialDto;
import az.academy.atl.tutorials.app.entity.Tutorial;
import az.academy.atl.tutorials.app.model.request.TutorialRequest;

public class TutorialMapper {

    public static Tutorial mapDtoToEntity(TutorialDto tutorial) {
        return Tutorial.builder()
                .id(tutorial.getId())
                .title(tutorial.getTitle())
                .description(tutorial.getDescription())
                .published(false)
                .build();
    }

    public static Tutorial mapRequestToEntity(TutorialRequest request) {
        return Tutorial.builder()
                .title(request.getTitle())
                .description(request.getDescription())
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
