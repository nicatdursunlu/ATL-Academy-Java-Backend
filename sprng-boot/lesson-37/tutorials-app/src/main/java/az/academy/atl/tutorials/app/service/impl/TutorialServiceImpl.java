package az.academy.atl.tutorials.app.service.impl;

import az.academy.atl.tutorials.app.exception.TutorialAlreadyExistsException;
import az.academy.atl.tutorials.app.mapper.TutorialMapper;
import az.academy.atl.tutorials.app.model.dto.TutorialDto;
import az.academy.atl.tutorials.app.entity.Tutorial;
import az.academy.atl.tutorials.app.exception.NoSuchTutorialExistsException;
import az.academy.atl.tutorials.app.model.request.TutorialRequest;
import az.academy.atl.tutorials.app.repository.TutorialRepository;
import az.academy.atl.tutorials.app.service.TutorialService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static az.academy.atl.tutorials.app.model.constants.ExceptionConstants.TUTORIAL_NOT_FOUND_CODE;
import static az.academy.atl.tutorials.app.model.constants.ExceptionConstants.TUTORIAL_NOT_FOUND_MESSAGE;
import static az.academy.atl.tutorials.app.model.constants.ExceptionConstants.TUTORIAL_ALREADY_EXISTS_CODE;
import static az.academy.atl.tutorials.app.model.constants.ExceptionConstants.TUTORIAL_ALREADY_EXISTS_MESSAGE;

@Slf4j
@Service
@RequiredArgsConstructor
public class TutorialServiceImpl implements TutorialService {

    private final TutorialRepository tutorialRepository;

    private final TutorialMapper tutorialMapper;

    @Override
    public List<TutorialDto> getAllTutorialsPageable(int page, int size) {
        log.info("TutorialServiceImpl.getAllTutorialsPageable.start with page: {} and size: {}", page, size);
        var tutorials = tutorialRepository
                .findAll(PageRequest.of(page, size))
                .stream()
                .map(tutorialMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("TutorialServiceImpl.getAllTutorialsPageable.end with page: {} and size: {}", page, size);
        return tutorials;
    }

    @Override
    public List<TutorialDto> getAllTutorialsByPublishedPageable(boolean published, int page, int size) {
        log.info("TutorialServiceImpl.getAllTutorialsByPublishedPageable.start with page: " +
                "{} and size: {} by published: {} ", page, size, published);
        var tutorials = tutorialRepository
                .findTutorialsByPublished(published, PageRequest.of(page, size))
                .stream()
                .map(tutorialMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("TutorialServiceImpl.getAllTutorialsByPublishedPageable.end with page: " +
                "{} and size: {} by published: {} ", page, size, published);
        return tutorials;
    }

    @Override
    public List<TutorialDto> getAllTutorials(String title) {
        log.info("TutorialServiceImpl.getAllTutorials.start with title: {}", title);
        List<Tutorial> tutorials = new ArrayList<>();
        if (title == null)
            tutorials.addAll(tutorialRepository.findAll());
        else
            tutorials.addAll(tutorialRepository.findTutorialsByTitleContainingIgnoreCase(title));

        List<TutorialDto> tutorialDtos = tutorials
                .stream()
                .map(tutorialMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("TutorialServiceImpl.getAllTutorials.end with title: {}", title);
        return tutorialDtos;
    }

    @Override
    public List<TutorialDto> findTutorialsByPublished(boolean published) {
        log.info("TutorialServiceImpl.findByPublished.start by published: {}", published);

        List<Tutorial> tutorials = tutorialRepository.findTutorialsByPublished(published);
        List<TutorialDto> tutorialDtos = tutorials
                .stream()
                .map(tutorialMapper::mapEntityToDto)
                .collect(Collectors.toList());

        log.info("TutorialServiceImpl.findByPublished.end by published: {}", published);
        return tutorialDtos;
    }

    @Override
    public void createTutorial(TutorialRequest tutorialRequest) {
        log.info("TutorialServiceImpl.createTutorial.start");
        if (isTutorialExists(tutorialRequest)) {
            log.error("TutorialServiceImpl.createTutorial.error");
            throw new TutorialAlreadyExistsException(TUTORIAL_ALREADY_EXISTS_CODE,
                    String.format(TUTORIAL_ALREADY_EXISTS_MESSAGE, tutorialRequest.getTitle()));
        } else {
            tutorialRepository.save(tutorialMapper.mapRequestToEntity(tutorialRequest));
            log.info("TutorialServiceImpl.createTutorial.end");
        }
    }

    @Override
    public void updateTutorial(Long id, TutorialRequest tutorialRequest) {
        log.info("TutorialServiceImpl.updateTutorial.start with id: {}", id);
        if (isTutorialExists(tutorialRequest)) {
            log.error("TutorialServiceImpl.createTutorial.error");
            throw new TutorialAlreadyExistsException(TUTORIAL_ALREADY_EXISTS_CODE,
                    String.format(TUTORIAL_ALREADY_EXISTS_MESSAGE, tutorialRequest.getTitle()));
        } else {
            var tutorial = fetchTutorialIfExists(id);
            tutorial.setTitle(tutorialRequest.getTitle());
            tutorial.setDescription(tutorialRequest.getDescription());
            tutorial.setPublished(tutorialRequest.getPublished());
            tutorialRepository.save(tutorial);
            log.info("TutorialServiceImpl.updateTutorial.end with id: {}", id);
        }
    }

    @Override
    public TutorialDto findById(Long id) {
        log.info("TutorialServiceImpl.findById.start with id: {}", id);
        var tutorial = fetchTutorialIfExists(id);
        log.info("TutorialServiceImpl.findById.end with id: {}", id);
        return tutorialMapper.mapEntityToDto(tutorial);
    }

    @Override
    public void deleteTutorial(Long id) {
        try {
            log.info("TutorialServiceImpl.deleteTutorial.start with id: {}", id);
            tutorialRepository.deleteById(id);
            log.info("TutorialServiceImpl.deleteTutorial.end with id: {}", id);
        } catch (Exception e) {
            log.error("TutorialServiceImpl.deleteTutorial.error with id: {}", id);
            throw new NoSuchTutorialExistsException(
                    TUTORIAL_NOT_FOUND_CODE, String.format(TUTORIAL_NOT_FOUND_MESSAGE, id));
        }
    }

    @Override
    public void deleteAllTutorials() {
        log.info("TutorialServiceImpl.deleteAll.start");
        tutorialRepository.deleteAll();
        log.info("TutorialServiceImpl.deleteAll.end");
    }

    private boolean isTutorialExists(TutorialRequest tutorialRequest) {
        return tutorialRepository
                .findAll()
                .stream()
                .anyMatch(tutorial -> Objects.equals(tutorial.getTitle(), tutorialRequest.getTitle()));
    }

    private Tutorial fetchTutorialIfExists(Long id) {
        return tutorialRepository.findById(id).orElseThrow(() -> {
            log.error("TutorialServiceImpl.fetchTutorialIfExists.error with id: {}", id);
            throw new NoSuchTutorialExistsException(
                    TUTORIAL_NOT_FOUND_CODE, String.format(TUTORIAL_NOT_FOUND_MESSAGE, id));
        });
    }
}
