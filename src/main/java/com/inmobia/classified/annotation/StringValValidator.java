/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.annotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Duncan
 */
public class StringValValidator implements ConstraintValidator<StringVal, String> {
    final static Logger logger = Logger.getLogger(StringValValidator.class.getName());
    @Override
    public void initialize(StringVal constraintAnnotation) {
        
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       try{
           value=value.trim();
           if(value==null || value.length()==0) {
               
               
               return false;
           }
           else return true;
       }catch(Exception ex){
           logger.error(ex.getMessage());
           return false;
       } 
    }
}
