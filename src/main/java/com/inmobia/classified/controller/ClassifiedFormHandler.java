/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.controller;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.inmobia.classified.ErrorMessage;
import com.inmobia.classified.IMessage;
import com.inmobia.classified.Message;
import com.inmobia.classified.dao.ContentDao;
import com.inmobia.classified.dto.Content;
import com.inmobia.classified.security.WebDataSanitizer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

    @Autowired
    WebDataSanitizer webSanitizer;
    ContentDao contentDao;
    final static Logger logger = Logger.getLogger(ClassifiedFormHandler.class.getName());

    @ResponseBody
    @RequestMapping(value = "/process-content", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveContent(@Valid @RequestBody Content content, BindingResult result) {

        if (result.hasErrors()) {

            logger.error("Validation failed for submitted content");
            List<ErrorMessage> errorMessages = new ArrayList();
            ErrorMessage errMsg = null;

            for (FieldError fieldError : result.getFieldErrors()) {
                logger.error(fieldError.getDefaultMessage());
                errMsg = new ErrorMessage();
                errMsg.setId(fieldError.getField());
                errMsg.setMessage(fieldError.getDefaultMessage());

                errorMessages.add(errMsg);

            }

            return new ResponseEntity<List>(errorMessages, HttpStatus.BAD_REQUEST);
        }

        Content sanitize = (Content) webSanitizer.sanitize(content);

        
        try {
            contentDao.saveContent(sanitize);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        Timestamp date = null;

        logger.info("worked right");
        IMessage message = new Message();
        message.setMessage("Submitted successfully");

        return new ResponseEntity<IMessage>(message, HttpStatus.OK);
    }

}
