package com.nhattruongnguyen.error;


import com.nhattruongnguyen.exception.PageNotFoundException;
import com.nhattruongnguyen.exception.StorageFileNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * General error handler for the application.
 */
@RestControllerAdvice
class CustomizedExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger("ErrorLog");

    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = {PageNotFoundException.class, StorageFileNotFoundException.class})
    public void notFoundExceptionHandler(Exception exception, WebRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult()
//                .getAllErrors().stream()
//                .map(ObjectError::getDefaultMessage)
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
}
