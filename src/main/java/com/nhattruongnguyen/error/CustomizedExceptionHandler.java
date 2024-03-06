package com.nhattruongnguyen.error;


import com.google.common.base.Throwables;
import com.nhattruongnguyen.exception.PageNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * General error handler for the application.
 */
@ControllerAdvice
class CustomizedExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger("ErrorLog");
    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = PageNotFoundException.class)
    public void pageNotFoundExceptionHandler(PageNotFoundException exception, WebRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
