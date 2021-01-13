package com.dateFormat.exceptionhandling;

import org.springframework.stereotype.Component;

@Component
public class DateFormatMismatchException extends RuntimeException{
    public DateFormatMismatchException() {
        super();
    }

    public DateFormatMismatchException(String message){
        super(message);
    }
}
