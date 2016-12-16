package com.inmobia.classified.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inmobia.classified.annotation.StringVal;
import java.util.Date;
import javax.validation.constraints.Digits;
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
    
    @Digits(integer=20,fraction = 0,message = "Please provide valid phone number")
    @NotNull(message = "Please include a phone number")
    private Long phone;
   
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyy", timezone="GMT")
    @Future(message = "Please include a future date")
    private Date expiryDate;
    
//    @Pattern(regexp="^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n" +
//"		 \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$",message = "please include correct email")
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
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
