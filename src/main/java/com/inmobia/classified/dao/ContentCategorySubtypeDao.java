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

    private String getAllContentCategorySubtypeSql = "select * from inmobiaclassified.content_category_subtype";
    private String getContentCategorySubtypeByNameSql = "select sub_type_id from inmobiaclassified.content_category_subtype where sub_type_name=? and content_category_id=?";
    private String getContentCategorySubtypeByIdSql = "select sub_type_name from inmobiaclassified.content_category_subtype where sub_type_id=?";

    
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
            while (rs.next()) {
                contentCategorySubtype = new ContentCategorySubtype();

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

    public int getContentCategorySubtypeByName(String subTypeName, int categoryId) {
        Connection con = null;
        int subCatId = -1;
        PreparedStatement pst = null;
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getContentCategorySubtypeByNameSql);
            pst.setString(1, subTypeName);
            pst.setInt(2, categoryId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                subCatId = rs.getInt("sub_type_id");
            }

            logger.debug("getContentCategorySubtypeByName completed");
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
        return subCatId;
    }
    
    public String getContentCategorySubtypeById(int subTypeId) {
        Connection con = null;
        String subCatName = "";
        PreparedStatement pst = null;
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getContentCategorySubtypeByIdSql);
            pst.setInt(1, subTypeId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                subCatName = rs.getString("sub_type_name");
            }

            logger.debug("getContentCategorySubtypeById completed");
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
        return subCatName;
    }
}
