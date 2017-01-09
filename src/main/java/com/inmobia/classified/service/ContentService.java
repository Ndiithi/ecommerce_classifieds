package com.inmobia.classified.service;

import com.inmobia.classified.dto.Content;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Duncan Ndiithi
 */
public class ContentService implements  Runnable{
    
    @Autowired
    ContentBuilder contentBuilder;
    
    Content cnt;
    String content;
    int telcoId;
    
    public ContentService(Content cnt,String content,String category,int telcoId){
        this.cnt=cnt;
        this.content=content;
        this.telcoId=telcoId;
    }
        
    }
    public void run(){
        contentBuilder.buildContent(cnt, content, category, 0)
    }
    public void submitContent() {
        
        
        
     //   https://m.inmobia.com/icpc/main/contentType/Lusaka/Classifieds-Land for sale/203
        
    }
}
