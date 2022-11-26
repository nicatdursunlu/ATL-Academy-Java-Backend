package az.academy.atl.tutorials.app.service;

import az.academy.atl.tutorials.app.dto.TutorialDto;

import java.util.List;

public interface TutorialService {

    List<TutorialDto> getAllTutorials(String title);

    List<TutorialDto> findByPublished(boolean published);

    void createTutorial(TutorialDto tutorial);

    void updateTutorial(Long id, TutorialDto tutorial);

    TutorialDto findById(Long id);

    void deleteTutorial(Long id);

    void deleteAll();
}
