/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Duncan
 */
public class IntegerValValidator implements ConstraintValidator<IntegerVal, String> {
    
    @Override
    public void initialize(IntegerVal constraintAnnotation) {
        
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try{
            Long valueToParse=Long.parseLong(value);
            return true;
           }catch(NumberFormatException e){
               return false;
           }
    }
}
