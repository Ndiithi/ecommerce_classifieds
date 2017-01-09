/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inmobia.test;

import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.ContentBuilder;
import com.inmobia.classified.service.ContentService;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author Duncan
 */
public class ContentServiceTest {
   
    
    Content content=new Content();
    
    
    @Test
    public void testContentSubmit(){
    content.setContentId(1);
    content.setContent_category("Classifieds-Land for sale");
    content.setCountry("zambia");
    content.setEmail("email@dkdkd.com");
    content.setLocation("Lusaka");
    content.setShortDescription("description");
    content.setSub_category("Classifieds-Land for sale");
    
    ContentService cs=new ContentService();
    cs.submitContent(content, "Classifieds-Land for sale", "Lusaka", 203);
    
        Assert.assertNotNull(cs.getData());
    
    }
    
}
