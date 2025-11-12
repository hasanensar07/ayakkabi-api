package com.bitirmeprojesi.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.*;

import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errorsMap = new HashMap<>();

        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) objError).getField();
            String defaultMessage = objError.getDefaultMessage();
            errorsMap.computeIfAbsent(fieldName, key -> new ArrayList<>()).add(defaultMessage);
        }

        ApiError apiError = new ApiError(UUID.randomUUID().toString(), LocalDateTime.now(), errorsMap);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
