package az.academy.atl.tutorials.app.controller;

import az.academy.atl.tutorials.app.model.dto.TutorialDto;
import az.academy.atl.tutorials.app.model.request.TutorialRequest;
import az.academy.atl.tutorials.app.service.TutorialService;

import static az.academy.atl.tutorials.app.model.constants.RestConstants.PAGE;
import static az.academy.atl.tutorials.app.model.constants.RestConstants.SIZE;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/${version}/tutorials")
@Api(tags = "Tutorial Controller")
public class TutorialController {

    private final TutorialService tutorialService;

    @GetMapping("/pageable")
    @ApiOperation(value = "Getting All Tutorials Pageable")
    public ResponseEntity<List<TutorialDto>> getAllTutorialsPageable(
            @RequestParam(value = "page", defaultValue = PAGE) int page,
            @RequestParam(value = "size", defaultValue = SIZE) int size) {
        return ResponseEntity.ok(tutorialService.getAllTutorialsPageable(page, size));
    }

    @GetMapping("/published/{published}/pageable")
    @ApiOperation(value = "Get All Tutorials by Published Pageable")
    public ResponseEntity<List<TutorialDto>> getAllTutorialsByPublishedPageable(
            @PathVariable @ApiParam(name = "published", value = "Is tutorial published", example = "true")
            boolean published,
            @RequestParam(value = "page", defaultValue = PAGE) int page,
            @RequestParam(value = "size", defaultValue = SIZE) int size) {
        return ResponseEntity.ok(tutorialService.getAllTutorialsByPublishedPageable(published, page, size));
    }

    @GetMapping
    @ApiOperation(value = "Getting All Tutorials")
    public ResponseEntity<List<TutorialDto>> getAllTutorials(
            @RequestParam(required = false)
            @ApiParam(name = "title", value = "Tutorial title", example = "Lorem ipsum")
            String title) {
        return new ResponseEntity<>(tutorialService.getAllTutorials(title), HttpStatus.OK);
    }

    @GetMapping("/published/{published}")
    @ApiOperation(value = "Get All Tutorials by Published")
    public ResponseEntity<List<TutorialDto>> findByPublished(
            @PathVariable @ApiParam(name = "published", value = "Is tutorial published", example = "true")
            boolean published) {
        return new ResponseEntity<>(tutorialService.findTutorialsByPublished(published), HttpStatus.OK);
    }


    @PostMapping
    @ApiOperation(value = "Create Tutorial")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Tutorial created"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })
    public ResponseEntity<String> createTutorial(@RequestBody TutorialRequest tutorial) {
        tutorialService.createTutorial(tutorial);
        return new ResponseEntity<>("Tutorial was created successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Tutorial")
    public ResponseEntity<String> updateTutorial(
            @PathVariable @ApiParam(name = "id", value = "Tutorial id", example = "100") Long id,
            @RequestBody TutorialRequest tutorial) {
        tutorialService.updateTutorial(id, tutorial);
        return new ResponseEntity<>("Tutorial was updated successfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Tutorial by Id")
    public ResponseEntity<TutorialDto> getTutorialById(
            @PathVariable @ApiParam(name = "id", value = "Tutorial id", example = "100") Long id) {
        return new ResponseEntity<>(tutorialService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Tutorial by Id")
    public ResponseEntity<String> deleteTutorial(
            @PathVariable @ApiParam(name = "id", value = "Tutorial id", example = "100") Long id) {
        tutorialService.deleteTutorial(id);
        return new ResponseEntity<>("Tutorial was deleted successfully!", HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete All Tutorials")
    public ResponseEntity<String> deleteAllTutorials() {
        tutorialService.deleteAllTutorials();
        return new ResponseEntity<>("All Tutorials deleted successfully!", HttpStatus.OK);
    }
}
