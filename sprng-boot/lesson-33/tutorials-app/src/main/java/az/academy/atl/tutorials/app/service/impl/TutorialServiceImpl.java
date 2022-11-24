package az.academy.atl.tutorials.app.service.impl;

import az.academy.atl.tutorials.app.dto.TutorialDto;
import az.academy.atl.tutorials.app.mapper.TutorialMapper;
import az.academy.atl.tutorials.app.model.Tutorial;
import az.academy.atl.tutorials.app.repository.TutorialRepository;
import az.academy.atl.tutorials.app.service.TutorialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void createTutorial(TutorialDto tutorial) {
        try {
            log.info("TutorialServiceImpl.createTutorial.start");
            tutorialRepository.save(TutorialMapper.mapDtoToEntity(tutorial));
            log.info("TutorialServiceImpl.createTutorial.end");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("TutorialServiceImpl.createTutorial.error with message: {}", e.getMessage());
        }
    }

    @Override
    public void updateTutorial(Long id, TutorialDto tutorial) {
        log.info("TutorialServiceImpl.updateTutorial.start with id: {}", id);
        Tutorial oldTutorial = tutorialRepository.findById(id);
        if (oldTutorial != null) {
            oldTutorial.setTitle(tutorial.getTitle());
            oldTutorial.setDescription(tutorial.getDescription());
            oldTutorial.setPublished(tutorial.getPublished());
            tutorialRepository.update(oldTutorial);
            log.info("TutorialServiceImpl.updateTutorial.end with id: {}", id);
        } else {
            log.error("TutorialServiceImpl.updateTutorial.error with id: {}", id);
            throw new RuntimeException("Tutorial not found with id " + id);
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
            throw new RuntimeException("Tutorial not found with id " + id);
        }
    }

    @Override
    public void deleteTutorial(Long id) {
        log.info("TutorialServiceImpl.deleteTutorial.start with id: {}", id);
        int result = tutorialRepository.deleteById(id);
        if (result == 0) {
            log.error("TutorialServiceImpl.deleteTutorial.error with id: {}", id);
            throw new RuntimeException("Tutorial not found with id " + id);
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
}
