/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.annotation.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Duncan
 */
public class FutureDateValidator implements ConstraintValidator<FutureDate, String> {
    Logger logger=Logger.getLogger(FutureDateValidator.class.getName());
    @Override
    public void initialize(FutureDate constraintAnnotation) {
        
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        if(value==null || value.trim().length()==0){ 
            return true;
        }
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date today=new Date();
        try {
            Date enteredDate=sdf.parse(value);
            Calendar cal=Calendar.getInstance();
            logger.info("submitted date: "+ enteredDate);
            logger.info("todays date "+ today.toString());
            cal.setTime(enteredDate);
            Calendar todays=Calendar.getInstance();
            Calendar entered=Calendar.getInstance();
            
            entered.set(Calendar.YEAR, cal.get(Calendar.YEAR));
            entered.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR));
            todays.setTime(today);
            
            if((entered.get(Calendar.YEAR))>todays.get(Calendar.YEAR))return true;
            else if((entered.get(Calendar.YEAR))==todays.get(Calendar.YEAR)){
                if((entered.get(Calendar.DAY_OF_YEAR))>todays.get(Calendar.DAY_OF_YEAR)) return true;
                return false;
            }return false;
            
        } catch (ParseException ex) {
            logger.info("Could not parse date "+ex.getMessage());
            return false;
        }
        
    }
}
