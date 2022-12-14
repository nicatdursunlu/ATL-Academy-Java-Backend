package az.academy.atl.tutorials.app.service.impl;

import az.academy.atl.tutorials.app.dto.TutorialDto;
import az.academy.atl.tutorials.app.exception.NoSuchTutorialExistsException;
import az.academy.atl.tutorials.app.exception.TutorialAlreadyExistsException;
import az.academy.atl.tutorials.app.mapper.TutorialMapper;
import az.academy.atl.tutorials.app.model.Tutorial;
import az.academy.atl.tutorials.app.repository.TutorialRepository;
import az.academy.atl.tutorials.app.service.TutorialService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static az.academy.atl.tutorials.app.model.constants.ExceptionConstants.TUTORIAL_ALREADY_EXISTS_CODE;
import static az.academy.atl.tutorials.app.model.constants.ExceptionConstants.TUTORIAL_ALREADY_EXISTS_MESSAGE;
import static az.academy.atl.tutorials.app.model.constants.ExceptionConstants.TUTORIAL_NOT_FOUND_CODE;
import static az.academy.atl.tutorials.app.model.constants.ExceptionConstants.TUTORIAL_NOT_FOUND_MESSAGE;

@Slf4j
@Service
@RequiredArgsConstructor
public class TutorialServiceImpl implements TutorialService {

    private final TutorialRepository tutorialRepository;

    @Override
    public List<TutorialDto> getAllTutorials(String title) {
        log.info("TutorialServiceImpl.getAllTutorials.start with title: {}", title);
        List<Tutorial> tutorials = new ArrayList<>();
        if (title == null)
            tutorials.addAll(tutorialRepository.findAll());
        else
            tutorials.addAll(tutorialRepository.findByTitleContaining(title));

        List<TutorialDto> tutorialDtos = tutorials
                .stream()
                .map(TutorialMapper::mapEntityToDto)
                .collect(Collectors.toList());
        log.info("TutorialServiceImpl.getAllTutorials.end with title: {}", title);
        return tutorialDtos;
    }

    @Override
    public List<TutorialDto> findByPublished(boolean published) {
        log.info("TutorialServiceImpl.findByPublished.start with published: {}", published);

        List<Tutorial> tutorials = tutorialRepository.findByPublished(published);
        List<TutorialDto> tutorialDtos = tutorials
                .stream()
                .map(TutorialMapper::mapEntityToDto)
                .collect(Collectors.toList());

        log.info("TutorialServiceImpl.findByPublished.end with published: {}", published);
        return tutorialDtos;
    }

    @Override
    public void createTutorial(TutorialDto tutorialDto) {
        log.info("TutorialServiceImpl.createTutorial.start");
        if (isTutorialExists(tutorialDto)) {
            log.error("TutorialServiceImpl.createTutorial.error");
            throw new TutorialAlreadyExistsException(TUTORIAL_ALREADY_EXISTS_CODE,
                    String.format(TUTORIAL_ALREADY_EXISTS_MESSAGE, tutorialDto.getTitle()));
        } else {
            tutorialRepository.save(TutorialMapper.mapDtoToEntity(tutorialDto));
            log.info("TutorialServiceImpl.createTutorial.end");
        }
    }

    @Override
    public void updateTutorial(Long id, TutorialDto tutorialDto) {
        log.info("TutorialServiceImpl.updateTutorial.start with id: {}", id);
        Tutorial oldTutorial = tutorialRepository.findById(id);

        if (oldTutorial == null) {
            log.error("TutorialServiceImpl.updateTutorial.error with id: {}", id);
            throw new NoSuchTutorialExistsException(TUTORIAL_NOT_FOUND_CODE, String.format(TUTORIAL_NOT_FOUND_MESSAGE, id));
        }
        if (isTutorialExists(tutorialDto)) {
            log.error("TutorialServiceImpl.updateTutorial.error with id: {}", id);
            throw new TutorialAlreadyExistsException(TUTORIAL_ALREADY_EXISTS_CODE,
                    String.format(TUTORIAL_ALREADY_EXISTS_MESSAGE, tutorialDto.getTitle()));
        } else {
            oldTutorial.setTitle(tutorialDto.getTitle());
            oldTutorial.setDescription(tutorialDto.getDescription());
            oldTutorial.setPublished(tutorialDto.getPublished());
            tutorialRepository.update(oldTutorial);
            log.info("TutorialServiceImpl.updateTutorial.end with id: {}", id);
        }
    }

    @Override
    public TutorialDto findById(Long id) {
        log.info("TutorialServiceImpl.findById.start with id: {}", id);
        Tutorial tutorial = tutorialRepository.findById(id);
        if (tutorial != null) {
            TutorialDto tutorialDto = TutorialMapper.mapEntityToDto(tutorial);
            log.info("TutorialServiceImpl.findById.end with id: {}", id);
            return tutorialDto;
        } else {
            log.error("TutorialServiceImpl.findById.error with id: {}", id);
            throw new NoSuchTutorialExistsException(TUTORIAL_NOT_FOUND_CODE, String.format(TUTORIAL_NOT_FOUND_MESSAGE, id));
        }
    }

    @Override
    public void deleteTutorial(Long id) {
        log.info("TutorialServiceImpl.deleteTutorial.start with id: {}", id);
        int result = tutorialRepository.deleteById(id);
        if (result == 0) {
            log.error("TutorialServiceImpl.deleteTutorial.error with id: {}", id);
            throw new NoSuchTutorialExistsException(TUTORIAL_NOT_FOUND_CODE, String.format(TUTORIAL_NOT_FOUND_MESSAGE, id));
        } else
            log.info("TutorialServiceImpl.deleteTutorial.end with id: {}", id);
    }

    @Override
    public void deleteAll() {
        log.info("TutorialServiceImpl.deleteAll.start");
        int numRows = tutorialRepository.deleteALl();
        if (numRows > 0)
            log.info("TutorialServiceImpl.deleteAll.end");
        else
            log.error("TutorialServiceImpl.deleteAll.error");
    }

    private boolean isTutorialExists(TutorialDto tutorialDto) {
        return tutorialRepository
                .findAll()
                .stream()
                .anyMatch(tutorial -> Objects.equals(tutorial.getTitle(), tutorialDto.getTitle()));
    }
}
