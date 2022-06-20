package ch.bbw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorModel {

    private final HttpStatus httpStatus;

    private final LocalDateTime timestamp;

    private final String message;

    private final String details;
}