package az.academy.atl.tutorials.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ErrorResponseHandleCustomerAlreadyExistsException {

//    @ExceptionHandler(value = CustomerAlreadyExistsException.class)
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public ErrorResponseHandleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
//        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
//    }
}
