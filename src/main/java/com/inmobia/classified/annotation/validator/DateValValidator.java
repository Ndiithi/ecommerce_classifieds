/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.annotation.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Duncan
 */
public class DateValValidator implements ConstraintValidator<DateVal, String> {
    
    @Override
    public void initialize(DateVal constraintAnnotation) {
        
    }
    //checks id date is null or not
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        if(value==null || value.trim().length()==0){ 
            return true;
        }
        
        try {
           
            sdf.parse(value);
            return true;
        } catch (ParseException ex) {
            
            return false;
        }
        
    }
}
