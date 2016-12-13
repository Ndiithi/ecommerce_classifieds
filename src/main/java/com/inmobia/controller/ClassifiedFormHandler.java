/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.controller;

import com.inmobia.dao.Content;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Duncan
 */
@Controller
public class ClassifiedFormHandler {
    @RequestMapping(value ="/process-content.html")
    public ResponseEntity<Void> saveContent(ServletRequest request, HttpSession session){
        
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
