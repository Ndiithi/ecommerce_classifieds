package com.inmobia.classified.service;


import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Duncan Ndiithi
 * 
 * Resolves mapping for the content with those declared from remote server(panama)
 */
public class CategoryResolver {
    Logger logger=Logger.getLogger(CategoryResolver.class.getName());
   //categoryMap holds key inform of 'category-opcoid' and value as 'category' 
    Map<String,String> categoryMap; //category is synonymous for location
    //categoryMap holds key inform of 'content-opcoid' and value as 'content'
    Map<String, String> contentMap;
    //contService.submitContent(content, "Classifieds-Land for sale", "Lusaka", 203);
    
    private String content;
    private String category;
    private int countryId;
    
    public CategoryResolver(String location,String subCategory,int countryId){
        logger.debug("Category resolver started");
        this.content=subCategory;
        this.category=location;
        this.countryId=countryId;
    }
    
    public String getContentNameUsedInRemote(){
        logger.debug("Category resolver getContentNameUsedInRemote");
         //e.g Classifieds-Housing-Flat for rent
     //   String rContent=contentMap.get(this.content+"-"+countryId);
        
        return "Classifieds-Housing-Flat for rent";
    }
    
     public String getCategoryNameUsedInRemote(){            
        //e.g Lusaka
      //   String rCategory=categoryMap.get(this.category+"-"+countryId);
        
        return "Lusaka";
    }
    
    private void initializeCategoryMap(){
        categoryMap=new HashMap();
    }
    
    private void initializeContentMap(){
        categoryMap=new HashMap();
    }
    
}
