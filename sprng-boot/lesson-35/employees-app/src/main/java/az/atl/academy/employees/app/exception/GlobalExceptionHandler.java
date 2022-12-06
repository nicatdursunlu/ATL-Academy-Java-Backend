package az.atl.academy.employees.app.exception;

import az.atl.academy.employees.app.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(DepartmentNotFoundException e) {
        log.error("DepartmentNotFoundException ", e);
        return new ResponseEntity<>(
                new ErrorResponse(e.getStatus(), e.getStatus().value(), e.getMessage(), LocalDateTime.now()),
                e.getStatus());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException e) {
        log.error("EmployeeNotFoundException ", e);
        return new ResponseEntity<>(
                new ErrorResponse(e.getStatus(), e.getStatus().value(), e.getMessage(), LocalDateTime.now()),
                e.getStatus());
    }
}
