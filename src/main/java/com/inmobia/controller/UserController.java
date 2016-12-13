/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.controller;

import com.inmobia.dao.UserDao;
import com.inmobia.dto.User;
import com.inmobia.services.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Duncan
 */
@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    
    public UserService getUserservice() {
        return userservice;
    }

    public void setUserservice(UserService userservice) {
        this.userservice = userservice;
    }

}
