package com.dateFormat.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value="date check ")
@RestController
@CrossOrigin({"http://localhost:3000"})
public class DateCheckController {
    private final Logger logger = LogManager.getLogger(DateCheckController.class);
    @Autowired
    private DateFormatChecker dateFormatChecker;
   @ApiOperation(value = "to welcome Users",nickname = "DateChecker")
   @ApiResponses(value = { @ApiResponse(code = 404, message = "Not File Found"),@ApiResponse(code = 200, message = "Operation successfull") })
    @GetMapping("/")
    public String welcome(){
         String welcome = new String("Welcome to Date Checker");
         return welcome;
    }

 
  
   @ApiOperation(value = "to welcome Users",nickname = "DateFormat")
   @ApiResponses(value = { @ApiResponse(code = 404, message = "Not File Found"),@ApiResponse(code = 200, message = "Operation successfull") })
    @PostMapping("/dateCheck")
    public ResultDate checkDate(@RequestBody(required = false)Date date){
        if(date == null){
            throw new DateFormatMismatchException("Please enter the date and slo");
        }
       
        String newDay;

        if(date.getDate()== null && date.getSlo() == null){
            throw new DateFormatMismatchException("Date and SLO Should not be empty.");
        }

        if(dateFormatChecker.checkDateFormat(date.getDate())){
               newDay = dateFormatChecker.addDays(date.getDate(),date.getSlo());
                return new ResultDate(newDay);
        }else{
             throw new RuntimeException("Days cannot added");
        }

    }


}