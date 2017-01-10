package com.inmobia.classified.service.Bean;

import java.util.Date;

/**
 *
 * @author Duncan Ndiithi
 */
public class ContentDetail {
   
	private Integer id;
	private Integer contentId;
	private String phoneNumber;
	private String location;
	private String description;
	private Date expiryDate;
	private String price;
	private boolean negotiable;
	private String source;
	private String email;
	private boolean uploadedBySubscriber;
	private String cmd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isNegotiable() {
        return negotiable;
    }

    public void setNegotiable(boolean negotiable) {
        this.negotiable = negotiable;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUploadedBySubscriber() {
        return uploadedBySubscriber;
    }

    public void setUploadedBySubscriber(boolean uploadedBySubscriber) {
        this.uploadedBySubscriber = uploadedBySubscriber;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
        
        
        
}
