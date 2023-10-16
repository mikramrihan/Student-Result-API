package com.exampleResult.Studentresult.exceptions;

import com.exampleResult.Studentresult.exceptions.mycustomexception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Exception handler method for your custom exception
    @ExceptionHandler(mycustomexception.class)
    public String handleCustomException(HttpServletRequest request, Exception ex) {
        // Redirect to the error page
        return "error.html";
    }

    // Exception handler method for all other exceptions
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        // Redirect to the error page
        return "error.html";
    }
}