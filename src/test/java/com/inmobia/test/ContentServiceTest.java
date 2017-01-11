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
import org.junit.Ignore;
import org.junit.Test;
/**
 *
 * @author Duncan
 */
public class ContentServiceTest {
   
    
    Content content=new Content();
    
    
    @Test
    @Ignore
    public void testContentSubmit(){
    content.setContentId(1);
    content.setContent_category("Classifieds-Land for sale");
    content.setCountry("zambia");
    content.setEmail("email@dkdkd.com");
    content.setLocation("Lusaka");
    content.setShortDescription("description");
    content.setSub_category("Classifieds-Land for sale");
    
    System.out.println("test begin");
    
    ContentService cs=new ContentService();
    System.out.println("submit data");
 //   cs.submitContent(content, "Classifieds-Land for sale", "Lusaka", 203);
    System.out.println("con submitted");
    
    
   //     Assert.assertNotNull(cs.getData());
    
    }
    
}
