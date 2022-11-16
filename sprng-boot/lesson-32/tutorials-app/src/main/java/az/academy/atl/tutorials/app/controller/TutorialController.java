package az.academy.atl.tutorials.app.controller;

import az.academy.atl.tutorials.app.dto.TutorialDto;
import az.academy.atl.tutorials.app.service.TutorialService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tutorials")
public class TutorialController {

    private final TutorialService tutorialService;

    @GetMapping
    public ResponseEntity<List<TutorialDto>> getAllTutorials(@RequestParam(required = false) String title) {
        return tutorialService.getAllTutorials(title);
    }

    @GetMapping("/published/{published}")
    public ResponseEntity<List<TutorialDto>> findByPublished(@PathVariable boolean published) {
        return tutorialService.findByPublished(published);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TutorialDto tutorial) {
        return tutorialService.save(tutorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTutorial(@PathVariable Long id, @RequestBody TutorialDto tutorial) {
        return tutorialService.updateTutorial(id, tutorial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialDto> getTutorialById(@PathVariable Long id) {
        return tutorialService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable Long id) {
        return tutorialService.deleteTutorial(id);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllTutorials() {
        return tutorialService.deleteAll();
    }
}
