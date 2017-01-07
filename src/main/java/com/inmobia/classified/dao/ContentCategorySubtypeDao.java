package com.inmobia.classified.dao;

import com.inmobia.classified.dto.ContentCategorySubtype;
import com.inmobia.classified.utility.DatabaseSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Duncan Ndiithi
 */
public class ContentCategorySubtypeDao {
  
     Logger logger = Logger.getLogger(ContentCategorySubtypeDao.class.getName());
    
     private String getAllContentCategorySubtypeSql="select * from inmobiaclassified.content_category_subtype";
    
     public List<ContentCategorySubtype> getAllContentCategorySubtype() {
        Connection con = null;
        List<ContentCategorySubtype> contentCategorySubtypeList = null;
        PreparedStatement pst = null;
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getAllContentCategorySubtypeSql);
            
            
            ResultSet rs = pst.executeQuery();
            contentCategorySubtypeList = new ArrayList();
            ContentCategorySubtype contentCategorySubtype;
             while(rs.next()){
                 contentCategorySubtype =new ContentCategorySubtype();
                 
                 contentCategorySubtype.setId(rs.getInt("sub_type_id"));
                 contentCategorySubtype.setContentCategoryId(rs.getInt("content_category_id"));
                 contentCategorySubtype.setName(rs.getString("sub_type_name"));
                 contentCategorySubtypeList.add(contentCategorySubtype);
                 
             }
            
            logger.debug("getAllContentCategorySubtype completed");
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                logger.error(ex.getMessage());
            }
        }
        return contentCategorySubtypeList;
    }
}
