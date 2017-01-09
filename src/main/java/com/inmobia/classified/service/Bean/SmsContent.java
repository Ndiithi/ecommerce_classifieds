package com.inmobia.classified.service.Bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Duncan Ndiithi
 *
 * Bean class representing content sent to server (inmobia servers)
 */
public class SmsContent implements Serializable{

    private int id;
    private int ContentId; //maps to id in SmsContent pojo
    private String category;
    private String text;
    private String headline;
    private Date timestamp;
    private Integer dirty = 0;
    private Integer contentItemId;
    private Integer userId = 225;
    private Integer localeId = 2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContentId() {
        return ContentId;
    }

    public void setContentId(int ContentId) {
        this.ContentId = ContentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getDirty() {
        return dirty;
    }

    public void setDirty(Integer dirty) {
        this.dirty = dirty;
    }

    public Integer getContentItemId() {
        return contentItemId;
    }

    public void setContentItemId(Integer contentItemId) {
        this.contentItemId = contentItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLocaleId() {
        return localeId;
    }

    public void setLocaleId(Integer localeId) {
        this.localeId = localeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    

}
