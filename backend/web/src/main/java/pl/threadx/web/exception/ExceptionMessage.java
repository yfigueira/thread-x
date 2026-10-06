package pl.threadx.web.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ExceptionMessage(
        String method,
        String path,
        String message,
        LocalDateTime timestamp
) {
}
