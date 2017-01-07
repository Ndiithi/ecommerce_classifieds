package com.inmobia.classified.dto;

/**
 *
 * @author Duncan Ndiithi
 */
public class ContentCategorySubtype {
    private int id;
    private int contentCategoryId; //the foreign key of contetn_category it belongs too
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContentCategoryId() {
        return contentCategoryId;
    }

    public void setContentCategoryId(int contentCategoryId) {
        this.contentCategoryId = contentCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
