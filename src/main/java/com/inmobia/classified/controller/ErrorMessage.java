package com.inmobia.classified.controller;

import java.io.Serializable;

/**
 *
 * @author Duncan
 */
public class ErrorMessage implements Serializable {
    private String message;
    private String id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
