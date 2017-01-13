package com.inmobia.classified.service;

import com.inmobia.classified.dao.ContentDao;
import com.inmobia.classified.dto.Content;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Duncan Ndiithi
 */
@EnableAsync
public class ContentDeleter {
    Logger logger=Logger.getLogger(ContentDeleter.class.getName());
    
    @Autowired
    ContentDao contentDao;
    @Async
    public void deleteContent(Content cnt) {
        logger.info("content id to delete: "+cnt.getContentId());
       
       logger.info("Remote content id to delete: "+cnt.getRemoteContentId());
        String url = "http://m.inmobia.com/icpc/main/content/{id}";
logger.debug("Transmitting content for delete...: ");
        RestTemplate restTemplate = new RestTemplate();

        
        try{
            restTemplate.delete(url, cnt.getRemoteContentId());}
        catch(Exception e){
            logger.error("Failed to delete remote content");
            logger.error(e.getMessage());
        }
    }

}
