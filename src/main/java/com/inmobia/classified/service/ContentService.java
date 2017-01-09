package com.inmobia.classified.service;

import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.Bean.ContentType;
import com.inmobia.classified.service.Bean.SmsContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Duncan Ndiithi
 */
public class ContentService implements  Runnable{
    
    @Autowired
    ContentBuilder contentBuilder;
    Content data;
    
    Content cnt;
    String content;
    int telcoId;
    String category;
    
    public void run(){
        SmsContent smsContent=contentBuilder.buildContent(cnt, content, category, telcoId);
        String url=" https://m.inmobia.com/icpc/content";
        
         RestTemplate restTemplate = new RestTemplate();
        
         data = restTemplate.postForObject(url, smsContent,Content.class);
        
                     
    }
    
    public void submitContent(Content cnt,String content,String category,int telcoId){
        this.cnt=cnt;
        this.content=content;
        this.telcoId=telcoId;
        this.category=category;
        
        Thread t=new Thread(new ContentService());
        t.setName("ContentId: "+cnt.getContentId());
        t.start();
    }

    public Content getData() {
        return data;
    }
    
   
}
