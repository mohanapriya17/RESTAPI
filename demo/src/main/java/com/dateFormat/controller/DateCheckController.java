package com.dateFormat.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dateFormat.exceptionhandling.DateFormatMismatchException;
import com.dateFormat.model.ResultDate;
import com.dateFormat.model.Date;
import com.dateFormat.service.DateFormatChecker;

@RestController
public class DateCheckController {
    private final Logger logger = LogManager.getLogger(DateCheckController.class);
    @Autowired
    private DateFormatChecker dateFormatChecker;
   
    @GetMapping("/")
    public String welcome(){
         String welcome = new String("Welcome to Date Checker");
         return welcome;
    }



    @PostMapping("/dateCheck")
    public ResultDate checkDate(@RequestBody(required = false)Date date){
        if(date == null){
            throw new DateFormatMismatchException("Please enter the date and slo");
        }
       
        String updatedDay;

        if(date.getDate()== null && date.getSlo() == null){
            throw new DateFormatMismatchException("Date and SLO Should not be empty.");
        }

        if(dateFormatChecker.checkDateFormat(date.getDate())){
               updatedDay = dateFormatChecker.addDays(date.getDate(),date.getSlo());
                return new ResultDate(updatedDay);
        }else{
             throw new RuntimeException("Days cannot added");
        }

    }


}