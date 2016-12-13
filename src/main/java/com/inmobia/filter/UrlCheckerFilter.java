/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Duncan
 */
public class UrlCheckerFilter implements Filter {

    public void init(FilterConfig fc) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            System.out.println("processin :<<<<<<<<>??????>>>>>>");
            if (request instanceof HttpServletRequest) {
                String url = ((HttpServletRequest) request).getRequestURL().toString();
                String queryString = ((HttpServletRequest) request).getQueryString();
                String uri=url+queryString;
                System.out.println("The url is: "+uri);
                if(!uri.contains(".html")) {
                    request.getRequestDispatcher("classified-home.html")
                    .forward(request, response);
                    
                }//else {
//                System.out.println("chain Forwading");
//                chain.doFilter(request, response);
//            }
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex);
            request.getRequestDispatcher("/WEB-INF/view/jsp/classified-home.jsp")
                    .forward(request, response);

        }
    }

    public void destroy() {

    }

}
