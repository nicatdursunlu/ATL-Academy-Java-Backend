package az.academy.atl.tutorials.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoSuchElementException extends RuntimeException {
    private String code;
    private String message;
}
