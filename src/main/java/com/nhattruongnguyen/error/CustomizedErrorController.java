package com.nhattruongnguyen.error;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomizedErrorController implements ErrorController {

    public static final String ERROR_MESSAGE = "message";

    @GetMapping("/error")
    public String errorPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        int statusCode = response.getStatus();

        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            return "web/error/404";
        }
        else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            model.addAttribute(ERROR_MESSAGE, "Internal Server Error");
        } else if (statusCode == HttpStatus.GATEWAY_TIMEOUT.value()) {
            model.addAttribute(ERROR_MESSAGE, "Connect Timeout");
        } else if (statusCode == HttpStatus.BAD_GATEWAY.value()) {
            model.addAttribute(ERROR_MESSAGE, "Bad Grateway");
        } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
            model.addAttribute(ERROR_MESSAGE, "Bad Request");
        }

        return "web/error/general-errors";
    }
}
