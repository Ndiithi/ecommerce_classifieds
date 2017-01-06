package com.inmobia.classified.controller;

import com.inmobia.classified.Message;
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Duncan Ndiithi
 */
@Controller
public class UserGeoLocation {

    static Logger logger = Logger.getLogger(UserGeoLocation.class.getName());
   
    @RequestMapping(value = "/getUserIp", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Message> getUserCountry(HttpServletRequest request) {

        String ip = request.getRemoteAddr();
        Message msg=new Message();
        msg.setMessage(ip);
        return new ResponseEntity<Message>(msg, HttpStatus.OK);
    }

}
