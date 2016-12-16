package com.inmobia.classified.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inmobia.classified.annotation.validator.DateVal;
import com.inmobia.classified.annotation.validator.EMailVal;
import com.inmobia.classified.annotation.validator.IntegerVal;
import com.inmobia.classified.annotation.validator.StringVal;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Duncan
 */
public class Content {
    
    private int contentId; 
    @StringVal(message ="{StringVal.shortDescription}")
    private String shortDescription;
//    @NotNull(message = "Please include a loccation.")
    @NotEmpty(message ="{NotEmpty.location}")
    private String location;
    
    @IntegerVal(message ="{IntergerVal.phone}")
    @NotNull(message = "Please include a phone number")
    private String phone;
    
    @DateVal(message ="{DateVal.expiryDate}")
    private String expiryDate;
    
    @EMailVal
    private String email;
 
    private int isNegotiable;
    
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsNegotiable() {
        return isNegotiable;
    }

    public void setIsNegotiable(int isNegotiable) {
        this.isNegotiable = isNegotiable;
    }

    public int getContentId() {
        return contentId;
    }
    
    @JsonIgnore
    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

   
    
    
}
