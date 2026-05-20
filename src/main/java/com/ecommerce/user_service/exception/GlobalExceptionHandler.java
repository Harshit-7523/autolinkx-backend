 package com.ecommerce.user_service.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle Runtime Exceptions (Bad Request type errors)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(Map.of(
                        "status", "error",
                        "message", ex.getMessage()
                ));
    }

    // Handle All Other Exceptions (Server Error)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "status", "error",
                        "message", "Something went wrong"
                ));
    }
}