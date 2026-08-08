
package com.example.moviebooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Centralized exception handler for REST controllers.
 *
 * Converts application and validation exceptions into consistent
 * HTTP responses with a structured JSON error body.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles requests for resources that do not exist.
     *
     * @param ex resource-not-found exception
     * @return HTTP 404 response containing the error details
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /**
     * Handles validation failures caused by invalid request bodies.
     *
     * @param ex validation exception containing field-level errors
     * @return HTTP 400 response containing the validation errors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidation(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error ->
                        error.getField() + ": " + error.getDefaultMessage())
                .reduce((first, second) -> first + "; " + second)
                .orElse("Validation failed");

        return buildResponse(HttpStatus.BAD_REQUEST, message);
    }

    /**
     * Handles unexpected application exceptions.
     *
     * @param ex unexpected exception
     * @return HTTP 500 response containing the error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneric(Exception ex) {
        return buildResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage()
        );
    }

    /**
     * Handles attempts to create an actor that already exists.
     *
     * @param ex duplicate actor exception
     * @return HTTP 409 response indicating a resource conflict
     */
    @ExceptionHandler(ActorAlreadyExistsException.class)
    public ResponseEntity<Object> handleDuplicate(
            ActorAlreadyExistsException ex) {

        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    /**
     * Builds a standardized error response.
     *
     * @param status HTTP status to return
     * @param message descriptive error message
     * @return structured HTTP error response
     */
    private ResponseEntity<Object> buildResponse(
            HttpStatus status,
            String message) {

        Map<String, Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);

        return new ResponseEntity<>(body, status);
    }
}

