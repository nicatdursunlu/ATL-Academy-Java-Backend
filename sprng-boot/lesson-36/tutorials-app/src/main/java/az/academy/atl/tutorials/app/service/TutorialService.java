package az.academy.atl.tutorials.app.service;

import az.academy.atl.tutorials.app.model.dto.TutorialDto;
import az.academy.atl.tutorials.app.model.request.TutorialRequest;

import java.util.List;

public interface TutorialService {

    List<TutorialDto> getAllTutorials(String title);

    List<TutorialDto> findTutorialsByPublished(boolean published);

    void createTutorial(TutorialRequest tutorialRequest);

    void updateTutorial(Long id, TutorialRequest tutorialRequest);

    TutorialDto findById(Long id);

    void deleteTutorial(Long id);

    void deleteAllTutorials();
}
