/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.controller;

import com.inmobia.classified.dao.UserDao;
import com.inmobia.classified.dto.User;
import com.inmobia.classified.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Duncan
 */
@RestController
public class UserController {

    @Autowired
    private UserService userservice;

    
    

    @RequestMapping( value = "/data.html", produces="application/json" )
    public User getUser(){
        User user=new User();
        user.setEmail("my email");
        return  user;
      
}
    
    
    
    public UserService getUserservice() {
        return userservice;
    }

    public void setUserservice(UserService userservice) {
        this.userservice = userservice;
    }

}
