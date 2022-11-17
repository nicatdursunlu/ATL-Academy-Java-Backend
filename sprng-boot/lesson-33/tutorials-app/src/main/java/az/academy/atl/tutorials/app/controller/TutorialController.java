package az.academy.atl.tutorials.app.controller;

import az.academy.atl.tutorials.app.dto.TutorialDto;
import az.academy.atl.tutorials.app.service.TutorialService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "Tutorial Controller")
public class TutorialController {

    private final TutorialService tutorialService;

    @GetMapping
    @ApiOperation(value = "Getting All Tutorials")
    public ResponseEntity<List<TutorialDto>> getAllTutorials(@RequestParam(required = false) String title) {
        return tutorialService.getAllTutorials(title);
    }

    @GetMapping("/published/{published}")
    @ApiOperation(value = "Get All Tutorials by Published")
    public ResponseEntity<List<TutorialDto>> findByPublished(@PathVariable boolean published) {
        return tutorialService.findByPublished(published);
    }

    @PostMapping
    @ApiOperation(value = "Add Tutorial")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Tutorial added"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })
    public ResponseEntity<String> save(@RequestBody TutorialDto tutorial) {
        return tutorialService.save(tutorial);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Tutorial")
    public ResponseEntity<String> updateTutorial(@PathVariable Long id, @RequestBody TutorialDto tutorial) {
        return tutorialService.updateTutorial(id, tutorial);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Tutorial by Id")
    public ResponseEntity<TutorialDto> getTutorialById(@PathVariable Long id) {
        return tutorialService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Tutorial by Id")
    public ResponseEntity<String> deleteTutorial(@PathVariable Long id) {
        return tutorialService.deleteTutorial(id);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete All Tutorials")
    public ResponseEntity<String> deleteAllTutorials() {
        return tutorialService.deleteAll();
    }
}
