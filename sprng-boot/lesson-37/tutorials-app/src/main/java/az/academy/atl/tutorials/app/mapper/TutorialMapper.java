package az.academy.atl.tutorials.app.mapper;

import az.academy.atl.tutorials.app.entity.Tutorial;
import az.academy.atl.tutorials.app.model.dto.TutorialDto;
import az.academy.atl.tutorials.app.model.request.TutorialRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

//@Mapper(componentModel = "az.academy.atl.tutorials.app")
//@Mapper(componentModel = "spring")
@Mapper(componentModel = "spring", uses = {Tutorial.class, TutorialDto.class, TutorialRequest.class})
public interface TutorialMapper {
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "published", source = "published")
    })
    Tutorial mapDtoToEntity(TutorialDto tutorial);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "published", source = "published")
    })
    TutorialDto mapEntityToDto(Tutorial tutorial);

    @Mappings({
            @Mapping(target = "title", source = "title"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "published", source = "published")
    })
    Tutorial mapRequestToEntity(TutorialRequest request);
}
