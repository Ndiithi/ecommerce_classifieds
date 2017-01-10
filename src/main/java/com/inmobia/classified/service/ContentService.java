package com.inmobia.classified.service;

import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.Bean.ContentDetail;
import com.inmobia.classified.service.Bean.SmsContent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;

import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Duncan Ndiithi
 */
public class ContentService{

    private static Logger logger = Logger.getLogger(ContentService.class.getName());
  
  
    public void submitContent(Content cnt, String content, String category, int telcoId) {
        Thread t = new Thread(new ContentSaver(cnt, content, category, telcoId));
        t.setName("ContentId: " + cnt.getContentId());
        t.start();
    }

    
    public void editContent(Content cnt, String content, String category, int telcoId){
        
    }
}
