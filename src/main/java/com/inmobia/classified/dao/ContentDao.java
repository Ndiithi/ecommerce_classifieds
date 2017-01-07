package com.inmobia.classified.dao;

import com.inmobia.classified.dto.Content;
import com.inmobia.classified.utility.DatabaseSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Duncan
 */
public class ContentDao {

    @Autowired
    MsisdnDao msisdnDao;
    @Autowired 
    ContentCategoryDao contentCategoryDao;
    @Autowired 
    ContentCategorySubtypeDao contentCategorySubtypeDao;
    
    Logger logger = Logger.getLogger(ContentDao.class.getName());
    private String saveContentSql = "insert into "
            + "inmobiaclassified.content(content_category_id,short_description,location,msisdn_id,expiry_date,email,negotiable,sub_category,price) "
            + "values(?,?,?,?,?,?,?,?,?)";

    private String getAllContentByMsisdn = "Select * from inmobiaclassified.content where msisdn_id=?";
//    private String updateContentByIdSql = "Update inmobiaclassified.content set "
//            + "content_category=?,short_description=?,location=?,msisdn_id=?,expiry_date=?,email=?,negotiable=? "
//            + "where contentid=?";

    private String updateContentByIdSql = "Update inmobiaclassified.content set "
            + "short_description=?,location=?,msisdn_id=?,expiry_date=?,email=?,negotiable=?,sub_category=?,price=? "
            + "where contentid=?";
    
    private String deleteContentByIdSql = "delete from inmobiaclassified.content where contentid=?";

    public boolean saveContent(Content content) throws SQLException {
        try {
            Connection con = DatabaseSource.getDatabaseConnection();

            PreparedStatement pst = con.prepareStatement(saveContentSql);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            int msisdnId = msisdnDao.getMsisdnIdByNumber(content.getPhone());
            int contentCategory = contentCategoryDao.getContentCategoryByName(content.getContent_category());
            pst.setInt(1, contentCategory);
            pst.setString(2, content.getShortDescription());
            pst.setString(3, content.getLocation());
            pst.setInt(4, msisdnId);
            String expiryDateString = content.getExpiryDate();
            Date expiryDate = null;
            java.sql.Date expiryDateToSave = null;
            if (expiryDateString.trim().length() != 0) {
                try {
                    expiryDate = sdf.parse(expiryDateString);
                    expiryDateToSave = new java.sql.Date(expiryDate.getTime());
                } catch (ParseException ex) {
                    logger.error("Could not parse date: " + expiryDateString);
                    logger.error(ex.getMessage());
                }
            }
            pst.setDate(5, expiryDateToSave);
            pst.setString(6, content.getEmail());
            pst.setInt(7, content.getIsNegotiable());
            int subCatID=contentCategorySubtypeDao.getContentCategorySubtypeByName(content.getSub_category(),contentCategory);
            pst.setInt(8, subCatID);
            pst.setString(9, content.getPrice());
            int execStatus = pst.executeUpdate();
            if (execStatus == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new SQLException(ex.getMessage());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return false;
        }

    }

    public List<Content> getAllContentByMsisdn(String msisdn) {
        Connection con = null;
        List<Content> contentList = null;
        PreparedStatement pst = null;
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getAllContentByMsisdn);
            int msisdnId = msisdnDao.getMsisdnIdByNumber(msisdn);
            pst.setInt(1, msisdnId);
            ResultSet rs = pst.executeQuery();
            contentList = new ArrayList();
            Content content;
            while (rs.next()) {
                content = new Content();
                String categoryName;
                
                categoryName=contentCategoryDao.getContentCategoryNameByID(rs.getInt("content_category_id"));
                content.setContent_category(categoryName);
                content.setContentId(rs.getInt("contentid"));
                content.setEmail(rs.getString("email"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Long time = rs.getDate("expiry_date").getTime();
                    content.setExpiryDate(sdf.format(time));
                } catch (NullPointerException ex) {
                    content.setExpiryDate("");
                }
                content.setIsNegotiable(rs.getInt("negotiable"));
                int price=rs.getInt("price");
                content.setPrice(Integer.toString(price));
                String subCatName=contentCategorySubtypeDao.getContentCategorySubtypeById(rs.getInt("sub_category"));
                content.setSub_category(subCatName);
                content.setLocation(rs.getString("location"));
                content.setShortDescription(rs.getString("short_description"));
                contentList.add(content);

            }
            logger.debug("getAllContentByMsisdn completed");
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
        return contentList;
    }

    public boolean updateContentById(int contentId, Content content) {

        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DatabaseSource.getDatabaseConnection();
            int msisdnId = msisdnDao.getMsisdnIdByNumber(content.getPhone());
            pst = con.prepareStatement(updateContentByIdSql);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            pst.setString(1, content.getShortDescription());
            pst.setString(2, content.getLocation());
            pst.setInt(3, msisdnId);
            String expiryDateString = content.getExpiryDate();
            Date expiryDate = null;
            java.sql.Date expiryDateToSave = null;
            if (expiryDateString.trim().length() != 0) {
                try {
                    expiryDate = sdf.parse(expiryDateString);
                    expiryDateToSave = new java.sql.Date(expiryDate.getTime());
                } catch (ParseException ex) {
                    logger.error("Could not parse date: " + expiryDateString);
                    logger.error(ex.getMessage());
                }
            }
            pst.setDate(4, expiryDateToSave);
            pst.setString(5, content.getEmail());
            pst.setInt(6, content.getIsNegotiable());
            
            
            logger.info("the con cat: "+contentId);
            
            int contentCategory = contentCategoryDao.getContentCategoryByName(content.getContent_category());
            logger.info("the con cat: "+contentCategory);
            
            int subCatID=contentCategorySubtypeDao.getContentCategorySubtypeByName(content.getSub_category(),contentCategory);
            logger.info("the con cat: "+subCatID);
            pst.setInt(7, subCatID);
            pst.setString(8, content.getPrice());
            pst.setInt(9, contentId);
            int execStatus = pst.executeUpdate();
            if (execStatus == 1) {
                logger.info("the con cat: works");
                return true;
            } else {
                logger.info("the con cat: dint work");
                return false;
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            return false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                logger.error(ex.getMessage());
            }
        }
    }

    public boolean deleteContentById(int contentId) {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DatabaseSource.getDatabaseConnection();
            pst = con.prepareStatement(deleteContentByIdSql);
            pst.setInt(1, contentId);
            if (pst.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            return false;
        }finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                logger.error(ex.getMessage());
            }
        }
    }
}
