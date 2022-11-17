package az.academy.atl.tutorials.app.service;

import az.academy.atl.tutorials.app.dto.TutorialDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TutorialService {

    ResponseEntity<List<TutorialDto>> getAllTutorials(String title);

    ResponseEntity<List<TutorialDto>> findByPublished(boolean published);

    ResponseEntity<String> save(TutorialDto tutorial);

    ResponseEntity<String> updateTutorial(Long id, TutorialDto tutorial);

    ResponseEntity<TutorialDto> findById(Long id);

    ResponseEntity<String> deleteTutorial(Long id);

    ResponseEntity<String> deleteAll();
}
