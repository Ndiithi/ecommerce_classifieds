/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.annotation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Duncan
 */
public class EMailValValidator implements ConstraintValidator<EMailVal, String> {

    @Override
    public void initialize(EMailVal constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       
        if (value==null || value.trim().length() == 0) {
            return true;
        }

        Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$");
        Matcher m = p.matcher(value);
        boolean b = m.matches();
        return b;

    }
}
