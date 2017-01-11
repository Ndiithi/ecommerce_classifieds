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

    private static Logger logger = Logger.getLogger(ContentService.class.getName());
  
  
    public void submitContent(Content cnt) {
        logger.info("Submitting Content to remote");
        contentSaver=new ContentSaver(cnt);
        Thread t = new Thread(contentSaver);
        t.setName("ContentId: " + cnt.getContentId());
        t.start();
    }

    
    public void editContent(Content cnt, String content, String category, int telcoId){
        
    }
}
