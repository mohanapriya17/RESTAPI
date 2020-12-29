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
        LocalDate userEnteredDate = null;
        Integer numberOfDaysNeedToBeAdded = null;
        LocalDate updatedDate = null;
        try{
            userEnteredDate = LocalDate.parse(userDate, dateTimeFormatter);
            numberOfDaysNeedToBeAdded = Integer.parseInt(userNumber);
        }catch(DateTimeParseException dtpe){
            logger.warn(dtpe.getMessage());
            throw new DateFormatMismatchException(dtpe.getMessage());
        }catch(NumberFormatException exception){
            throw new NumberFormatException(exception.getMessage());
        }

        if(userEnteredDate != null && numberOfDaysNeedToBeAdded != null){
            switch(numberOfDaysNeedToBeAdded){
                case 30:
                    updatedDate = userEnteredDate.plusDays(30);
                    logger.info("30 days added to the user entered date");
                    break;
                case 40:
                    updatedDate = userEnteredDate.plusDays(40);
                    logger.info("40 days added to the user entered date");
                    break;
                case 50:
                    updatedDate = userEnteredDate.plusDays(50);
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