package com.dateFormat.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dateFormat.exceptionhandling.DateFormatMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class DateFormatChecker {
    private final Logger logger = LogManager.getLogger(DateFormatChecker.class);

     private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public boolean checkDateFormat(String enterDate) {
        LocalDate userEnteredDate;
        try {
            userEnteredDate = LocalDate.parse(enterDate, dateTimeFormatter);
            logger.info(userEnteredDate);
        } catch (DateTimeParseException dateTimeException) {
            throw new DateFormatMismatchException(dateTimeException.getMessage());
        }
        if(userEnteredDate != null)
            return true;
        else
            return false;
    }

    public String addDays(String userDate,String userNumber){
        LocalDate newDate = null;
        Integer noOfDays = null;
        LocalDate updatedDate = null;
        try{
            newDate = LocalDate.parse(userDate, dateTimeFormatter);
            noOfDays = Integer.parseInt(userNumber);
        }catch(DateTimeParseException dateTimeParseException){
            logger.warn(dateTimeParseException.getMessage());
            throw new DateFormatMismatchException(dateTimeParseException.getMessage());
        }catch(NumberFormatException exception){
            throw new NumberFormatException(exception.getMessage());
        }

        if(newDate != null && noOfDays != null){
            switch(noOfDays){
                case 30:
                    updatedDate = newDate.plusDays(30);
                    logger.info("30 days added to the user entered date");
                    break;
                case 40:
                    updatedDate = newDate.plusDays(40);
                    logger.info("40 days added to the user entered date");
                    break;
                case 50:
                    updatedDate = newDate.plusDays(50);
                    logger.info("50 days added to the user entered date");
                    break;
                default:
                    logger.warn("Not a proper choice");
                    break;
            }
        }

        if(updatedDate != null){
            return updatedDate.format(dateTimeFormatter).toString();
        }else{
            return "Date Cannot be added";
        }

    }
}