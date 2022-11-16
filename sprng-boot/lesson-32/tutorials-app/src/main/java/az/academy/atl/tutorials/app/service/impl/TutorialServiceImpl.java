package az.academy.atl.tutorials.app.service.impl;

import az.academy.atl.tutorials.app.dto.TutorialDto;
import az.academy.atl.tutorials.app.mapper.TutorialMapper;
import az.academy.atl.tutorials.app.model.Tutorial;
import az.academy.atl.tutorials.app.repository.TutorialRepository;
import az.academy.atl.tutorials.app.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorialServiceImpl implements TutorialService {

    private final TutorialRepository tutorialRepository;

    @Override
    public ResponseEntity<List<TutorialDto>> getAllTutorials(String title) {
        try {
            List<Tutorial> tutorials = new ArrayList<>();
            if (title == null)
                tutorials.addAll(tutorialRepository.findAll());
            else
                tutorials.addAll(tutorialRepository.findByTitleContaining(title));

            List<TutorialDto> tutorialDtos = tutorials
                    .stream()
                    .map(TutorialMapper::mapEntityToDto)
                    .collect(Collectors.toList());

            if (tutorialDtos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorialDtos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<TutorialDto>> findByPublished(boolean published) {
        try {
            List<Tutorial> tutorials = tutorialRepository.findByPublished(published);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            List<TutorialDto> tutorialDtos = tutorials.stream()
                    .map(TutorialMapper::mapEntityToDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(tutorialDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> save(TutorialDto tutorial) {
        try {
            tutorialRepository.save(TutorialMapper.mapDtoToEntity(tutorial));
            return new ResponseEntity<>("Tutorial was created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> updateTutorial(Long id, TutorialDto tutorial) {
        Tutorial oldTutorial = tutorialRepository.findById(id);
        if (oldTutorial != null) {
            oldTutorial.setTitle(tutorial.getTitle());
            oldTutorial.setDescription(tutorial.getDescription());
            oldTutorial.setPublished(tutorial.getPublished());
            tutorialRepository.update(oldTutorial);
            return new ResponseEntity<>("Tutorial was updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Can not find Tutorial with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<TutorialDto> findById(Long id) {
        Tutorial tutorial = tutorialRepository.findById(id);
        if (tutorial != null) {
            return new ResponseEntity<>(TutorialMapper.mapEntityToDto(tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteTutorial(Long id) {
        try {
            int result = tutorialRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Can not find Tutotial with id = " + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Tutorial was deleted successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Can not delete tutorial", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> deleteAll() {
        try {
            int numRows = tutorialRepository.deleteALl();
            return new ResponseEntity<>("Deleted " + numRows + " Tutorial(s) successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Can not delete tutorials", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
