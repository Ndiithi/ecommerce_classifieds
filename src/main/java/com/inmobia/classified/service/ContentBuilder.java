package com.inmobia.classified.service;


import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.Bean.ContentType;
import com.inmobia.classified.service.Bean.SmsContent;
import com.inmobia.classified.utility.DatabaseSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;
import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author Duncan Ndiithi
 */
public class ContentBuilder {
    Logger logger=Logger.getLogger(ContentBuilder.class.getName());
    
    public ContentBuilder(){
        
    }
    
    private String buildContentText(Content content) {
        StringBuilder sb = new StringBuilder();
        sb.append(content.getShortDescription() + ' ');

        sb.append("Phone:" + content.getPhone() + " ");
        sb.append("Location:" + content.getLocation() + " ");
        sb.append("Price:" + content.getPrice() + " ");
        try {
            if (content.getEmail().length() != 0) {
                sb.append("Email: " + content.getEmail() + " ");
            }
        } catch (Exception e) {
        }
        try {
            if (content.getExpiryDate().length() != 0) {
                sb.append("Expiry: " + content.getExpiryDate() + " ");
            }
        } catch (Exception e) {
        }
        if (content.getIsNegotiable() == 1) {
            sb.append("Negotiable: Yes");
        } else {
            sb.append("Negotiable: No");
        }

        return sb.toString();
    }
    
//    public ContentDetail buildContentDetail(){
//        
//    }
    
    public SmsContent buildContent(Content cnt,String content,String category,int telcoId){
        logger.info("values passed to builder:(category) "+content+" telcoId: "+telcoId);
        ContentType ct=fetchContentType(content,category,telcoId);
        logger.info("After fetch content from remote - id: "+ ct.getId());
        logger.info("After fetch content from remote -category id: "+ ct.getCategory());
        logger.info("After fetch content from remote -keyword id: "+ ct.getKeyword());
        logger.info("After fetch content from remote -service id: "+ ct.getServiceId());
        
        int contentId=ct.getId();
        SmsContent contentObj=new SmsContent();
        contentObj.setCategory(category);
        contentObj.setContentId(contentId);
        logger.debug("and the id again: "+contentId);
        contentObj.setDirty(0);
        contentObj.setLocaleId(2);
        contentObj.setText(buildContentText(cnt));
        contentObj.setTimestamp(fetchContentTimestamp(cnt));
        contentObj.setUserId(225);
        logger.debug("content built successfully");
        return contentObj;
    }
    
    private ContentType fetchContentType(String content,String category,int telcoId){
        logger.info("Data to use to fetch remoter content type (content)"+content+"(category)"+category+"telco(id)"+telcoId);
        RestTemplate restTemplate = new RestTemplate();
        
        ContentType[] data = restTemplate .
                getForObject
        ("http://m.inmobia.com/icpc/main/contentType/{category}/{content}/{telcoId}", ContentType[].class,category,content,telcoId);
        ContentType ct=null;
        try{
             ct=data[0];
        }catch(ArrayIndexOutOfBoundsException e){
            logger.error("Could not fetch content type from remote");
        }
        
        return ct;
    }
    
    
    
    private Date fetchContentTimestamp(Content cnt){
        String getContentTimeStampSql="select timestamp from inmobiaclassified.content where contentid=?";
        Connection con = null;
        Timestamp timestamp=new Timestamp(new Date().getTime());
        PreparedStatement pst = null;
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getContentTimeStampSql);
            pst.setInt(1, cnt.getContentId());
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()) timestamp=rs.getTimestamp("timestamp");
            
            
    }   catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return new Date(timestamp.getTime());
        
}
}
