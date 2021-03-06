package com.inmobia.classified.controller;

import com.inmobia.classified.ErrorMessage;
import com.inmobia.classified.IMessage;
import com.inmobia.classified.Message;
import com.inmobia.classified.dao.ContentCategorySubtypeDao;
import com.inmobia.classified.dao.ContentDao;
import com.inmobia.classified.dto.Content;
import com.inmobia.classified.dto.ContentCategorySubtype;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Duncan
 */
@Controller
public class ContentManagerController {
    
    @Autowired
    WebDataSanitizer webSanitizer;
    @Autowired
    ContentCategorySubtypeDao contentCategorySubtypeDao;
    @Autowired
    ContentDao contentDao;
    Logger logger = Logger.getLogger(ContentManagerController.class.getName());

    @ResponseBody
    @RequestMapping(value = "/getAllContentByMsisdn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllContentByMsisdn(@RequestParam String msisdn) {
        msisdn=webSanitizer.sanitize(msisdn);
        List<Content> contentList = contentDao.getAllContentByMsisdn(msisdn);
        if (contentList.isEmpty()) {
            return new ResponseEntity<String>("No Content found for this number", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List>(contentList, HttpStatus.OK);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateContentById", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateContentById(
            @Valid @RequestBody Content content,
            BindingResult result,
            @RequestParam String contentId) {

        if (result.hasErrors()) {

            logger.error("Validation failed for submitted content to update");
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

        int contentIdd = Integer.parseInt(contentId);
        contentDao.setSubmitUpdateToRemote(1);
        boolean execStatus = contentDao.updateContentById(contentIdd, content);
        if (execStatus == true) {
            IMessage msg = new Message();
            msg.setMessage("Update Succesfull");
            return new ResponseEntity<IMessage>(msg, HttpStatus.OK);
        } else {
            IMessage msg = new Message();
            msg.setMessage("Request Failed");
            return new ResponseEntity<IMessage>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/deleteContentById", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IMessage> deleteContentById(@RequestParam int contentId) {
        boolean successStatus = contentDao.deleteContentById(contentId);
        IMessage message = new Message();
        message.setMessage("successfully deleted");
        if (successStatus) {
            return new ResponseEntity<IMessage>(message, HttpStatus.OK);
        } else {
            message.setMessage("Failed to delete content");
            return new ResponseEntity<IMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
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
    
     @ResponseBody
    @RequestMapping(value = "/getAllContentCategorySubType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getAllContentCategorySubType() {
        
            List<ContentCategorySubtype> ContentCategorySubTypeList=contentCategorySubtypeDao.getAllContentCategorySubtype();
            return new ResponseEntity<List>(ContentCategorySubTypeList, HttpStatus.OK);
        

    }
    
    
}
