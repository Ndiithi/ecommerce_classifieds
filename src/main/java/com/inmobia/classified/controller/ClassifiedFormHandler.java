/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.controller;


//import com.fasterxml.jackson.core.JsonProcessingException;
import com.inmobia.classified.dao.Content;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Duncan
 */
@Controller
public class ClassifiedFormHandler {
    
    final static Logger logger = Logger.getLogger(ClassifiedFormHandler.class.getName());
    
    @ResponseBody  
    @RequestMapping(value ="/process-content", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveContent(@Valid @RequestBody Content content,BindingResult result){
        
        if(result.hasErrors()){
            logger.error("Validation failed for submitted content");
             List<ErrorMessage> errorMessages=new ArrayList();
              ErrorMessage errMsg=null;
             
            for(FieldError fieldError : result.getFieldErrors()){
                logger.error(fieldError.getDefaultMessage());
                 errMsg=new ErrorMessage();
                errMsg.setId(fieldError.getField());
                errMsg.setMessage(fieldError.getDefaultMessage());
                
                errorMessages.add(errMsg);
                
            }
           
            return new ResponseEntity<List>(errorMessages ,HttpStatus.BAD_REQUEST);
        }
        
        Timestamp date=new Timestamp(content.getExpiryDate().getTime());
        date.toString();
        logger.info("success: "+content.getEmail() +" "+content.getLocation()+" "+date.toString());
        return new ResponseEntity<String>("Submitted successfully" ,HttpStatus.OK);
    }
    
    
   
}
