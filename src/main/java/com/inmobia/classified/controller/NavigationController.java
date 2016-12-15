/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Duncan
 */
@Controller
public class NavigationController {
    
     @RequestMapping(value = "/", method = RequestMethod.GET)
    public String returnIndexPage(HttpSession session){
        session.setAttribute("currentpage","classified-home");
        return "classified-home";
    }
    
    
     @RequestMapping(value = "/classified-home", method = RequestMethod.GET)
    public String returnClassifiedHome(HttpSession session){
        session.setAttribute("currentpage","classified-home");
        return "classified-home";
    }
    
    @RequestMapping(value = "/classified-upload", method = RequestMethod.GET)
    public String returnClassifiedUpload(HttpSession session){
                session.setAttribute("currentpage","classified-upload");
                return "classified-upload";
    }
    
    @RequestMapping(value = "/classified-login", method = RequestMethod.GET)
    public ModelAndView returnClassifiedLogin(){
            
                return new ModelAndView("login");
    }
}
