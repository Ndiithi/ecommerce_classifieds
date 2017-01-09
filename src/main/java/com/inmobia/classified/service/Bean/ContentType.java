package com.inmobia.classified.service.Bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 *
 * @author Duncan Ndiithi
 */


public class ContentType implements Serializable{
    
	
	private int id;
	private String content;	
	private String category;	
	private String servlet;	
	private int priority;	
	private int urlCreated;	
	private int telcoId;	
	private int contentTypeId;
	private String keyword;	
	private int maxLength;
	private int poolId;
	private int localeId;	
	private int languageId;
	private int goal;	
	private int oldId;	
	private String shortCode;	
	private int usexHtml;	
	private String serviceId;	
	private int instantDelete;	
	private int wapOnly;	
	private int maxDownTime;	
	private int contentCount;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getServlet() {
        return servlet;
    }

    public void setServlet(String servlet) {
        this.servlet = servlet;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getUrlCreated() {
        return urlCreated;
    }

    public void setUrlCreated(int urlCreated) {
        this.urlCreated = urlCreated;
    }

    public int getTelcoId() {
        return telcoId;
    }

    public void setTelcoId(int telcoId) {
        this.telcoId = telcoId;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getPoolId() {
        return poolId;
    }

    public void setPoolId(int poolId) {
        this.poolId = poolId;
    }

    public int getLocaleId() {
        return localeId;
    }

    public void setLocaleId(int localeId) {
        this.localeId = localeId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getOldId() {
        return oldId;
    }

    public void setOldId(int oldId) {
        this.oldId = oldId;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public int getUsexHtml() {
        return usexHtml;
    }

    public void setUsexHtml(int usexHtml) {
        this.usexHtml = usexHtml;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getInstantDelete() {
        return instantDelete;
    }

    public void setInstantDelete(int instantDelete) {
        this.instantDelete = instantDelete;
    }

    public int getWapOnly() {
        return wapOnly;
    }

    public void setWapOnly(int wapOnly) {
        this.wapOnly = wapOnly;
    }

    public int getMaxDownTime() {
        return maxDownTime;
    }

    public void setMaxDownTime(int maxDownTime) {
        this.maxDownTime = maxDownTime;
    }

    public int getContentCount() {
        return contentCount;
    }

    public void setContentCount(int contentCount) {
        this.contentCount = contentCount;
    }

        
        
        
}
