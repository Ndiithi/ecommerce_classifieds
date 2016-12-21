package com.inmobia.classified.controller;

import com.inmobia.classified.dao.ContentDao;
import com.inmobia.classified.dto.Content;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Duncan
 */
@Controller
public class ClassifiedManagerController {
    Logger logger=Logger.getLogger(ClassifiedManagerController.class.getName());
    @Autowired
    ContentDao contentDao;
    
    @ResponseBody
    @RequestMapping(value = "/getAllContentByMsisdn", method = RequestMethod.GET)
    public List<Content> getAllContentByMsisdn(@RequestParam String msisdn){
        List<Content> contentList=contentDao.getAllContentByMsisdn(msisdn);
        return contentList;
    }
}
