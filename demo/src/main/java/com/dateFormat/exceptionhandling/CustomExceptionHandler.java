package com.dateFormat.exceptionhandling;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dateFormat.model.ErrorMessage;

import org.springframework.web.bind.annotation.ExceptionHandler;
@RestControllerAdvice(basePackages = {"com.dateformatchecker"})
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LogManager.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(DateFormatMismatchException.class)
    public ErrorMessage dateFormatError(DateFormatMismatchException dfme){
        logger.warn("Date format mismatch exception occurs");
        return new ErrorMessage("400 error Message");
    }

    @ExceptionHandler(NumberFormatException.class)
    public ErrorMessage numberFormatException(NumberFormatException nfe){
        logger.warn("Number of Format exception occurs");
        return new ErrorMessage("400 NumberFormatException");
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage handleError(RuntimeException runtimeException) {
       return new ErrorMessage("500 RuntimeException");
    }

   
  

}
