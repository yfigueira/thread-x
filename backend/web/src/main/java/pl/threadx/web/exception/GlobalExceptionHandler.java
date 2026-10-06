package pl.threadx.web.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionMessage> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpServletRequest req) {
        log.error("[ {} ] Failed deserialization:\n{}", req.getRemoteAddr(), ex.getMessage());

        var response = ExceptionMessage.builder()
                .method(req.getMethod())
                .path(req.getRequestURI())
                .message("At least one of the provided values is not supported")
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.badRequest().body(response);
    }
}
