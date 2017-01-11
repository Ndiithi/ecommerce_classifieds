package com.inmobia.classified.service;

import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.Bean.ContentDetail;
import com.inmobia.classified.service.Bean.SmsContent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Duncan Ndiithi
 */
@Service
public class ContentService{
    
    @Autowired
    ContentSaver contentSaver;
    @Autowired
    ContentEditor contentEditor;
    @Autowired 
    ContentDeleter contentDeleter;

    private static Logger logger = Logger.getLogger(ContentService.class.getName());
  
  
    public void submitContent(Content cnt) {
        logger.info("Submitting Content to remote");
        
        contentSaver.sendContent(cnt);
       
    }

    
    public void editContent(Content cnt){
        contentEditor.editContent(cnt);
    }
    
    public void deleteContent(Content content){
       
        contentDeleter.deleteContent(content);
      
    }
}
