package com.inmobia.classified.dao;

import com.inmobia.classified.utility.DatabaseSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author Duncan
 */
public class ContentCategoryDao {

    private String selectContentCategoryByNameSql = "select content_category_id from inmobiaclassified.content_category where name=?";
    private String selectContentCategoryNameByIdSql = "select name from inmobiaclassified.content_category where content_category_id=?";
    
    Logger logger = Logger.getLogger(ContentCategoryDao.class.getName());

    public int getContentCategoryByName(String name) throws SQLException {

        int contentCategoryId = -1;

        Connection con = null;
        try {

            con = DatabaseSource.getDatabaseConnection();

            PreparedStatement ps = con.prepareStatement(selectContentCategoryByNameSql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                contentCategoryId = rs.getInt(1);
                return contentCategoryId;
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new SQLException(ex.getMessage());

        } finally {
            con.close();
        }

        return contentCategoryId;

    }
    
    
    
     public String getContentCategoryNameByID(int id) throws SQLException {

        String contentCategoryName = "";

        Connection con = null;
        try {

            con = DatabaseSource.getDatabaseConnection();

            PreparedStatement ps = con.prepareStatement(selectContentCategoryNameByIdSql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                contentCategoryName = rs.getString(1);
                return contentCategoryName;
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new SQLException(ex.getMessage());

        } finally {
            con.close();
        }

        return contentCategoryName;

    }
    
    
    
    
    
    
    
    
    
}
