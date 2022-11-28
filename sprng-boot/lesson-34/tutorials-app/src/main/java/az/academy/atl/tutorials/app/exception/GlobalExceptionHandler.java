package az.academy.atl.tutorials.app.exception;

import az.academy.atl.tutorials.app.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception ex) {
        log.error("Exception ", ex);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    @ExceptionHandler(value = NoSuchTutorialExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(NoSuchTutorialExistsException ex) {
        log.error("NoSuchTutorialExistsException ", ex);
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getCode(), ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(NoSuchElementException ex) {
        log.error("NoSuchElementException ", ex);
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getCode(), ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(value = TutorialAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleException(TutorialAlreadyExistsException ex) {
        log.error("TutorialAlreadyExistsException ", ex);
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getCode(), ex.getMessage(), LocalDateTime.now());
    }
}
