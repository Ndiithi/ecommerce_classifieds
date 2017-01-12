package com.inmobia.classified.dao;

import com.inmobia.classified.dto.Content;
import com.inmobia.classified.service.ContentService;
import com.inmobia.classified.utility.DatabaseSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
    CountryDao countryDao;
    @Autowired
    LocationDao locatioDao;
    @Autowired
    ContentCategoryDao contentCategoryDao;
    @Autowired
    ContentCategorySubtypeDao contentCategorySubtypeDao;
    @Autowired
    ContentService contService;
    
    int submitUpdateToRemote=0; //field that specifies on content update, submit content to remeote server
    
    Logger logger = Logger.getLogger(ContentDao.class.getName());
    private String saveContentSql = "insert into "
            + "inmobiaclassified.content(content_category_id,short_description,location_id,msisdn_id,expiry_date,email,negotiable,country_id,sub_category,price) "
            + "values(?,?,?,?,?,?,?,?,?,?)";

    private String getContentById="Select * from inmobiaclassified.content where contentid=?";
    
    private String getAllContentByMsisdn = "Select * from inmobiaclassified.content where msisdn_id=?";
//    private String updateContentByIdSql = "Update inmobiaclassified.content set "
//            + "content_category=?,short_description=?,location=?,msisdn_id=?,expiry_date=?,email=?,negotiable=? "
//            + "where contentid=?";

    private String updateContentByIdSql = "Update inmobiaclassified.content set "
            + "short_description=?,location_id=?,msisdn_id=?,expiry_date=?,email=?,negotiable=?,sub_category=?,price=?,"
            + "remote_content_id=?,remote_content_detail_id=? ,submitted_to_remote=? "
            + "where contentid=?";

    private String deleteContentByIdSql = "delete from inmobiaclassified.content where contentid=?";

    public boolean saveContent(Content content) throws SQLException {
        try {
            Connection con = DatabaseSource.getDatabaseConnection();

            PreparedStatement pst = con.prepareStatement(saveContentSql, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            int msisdnId = msisdnDao.getMsisdnIdByNumber(content.getPhone());
            int contentCategory = contentCategoryDao.getContentCategoryByName(content.getContent_category());
            pst.setInt(1, contentCategory);
            pst.setString(2, content.getShortDescription());
            int cocuntryId = countryDao.getCountryIdBySysmbol(content.getCountry());
            int locationId = locatioDao.getLocationId(content.getLocation(), cocuntryId);
            pst.setInt(3, locationId);
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
            pst.setInt(8, cocuntryId);
            int subCatID = contentCategorySubtypeDao.getContentCategorySubtypeByName(content.getSub_category(), contentCategory);
            pst.setInt(9, subCatID);
            pst.setString(10, content.getPrice());
            int execStatus = pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (execStatus == 1) {

                
                if (rs.next()) {
                     
                    content.setContentId(rs.getInt("GENERATED_KEY"));
                }
                contService.submitContent(content);
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

                categoryName = contentCategoryDao.getContentCategoryNameByID(rs.getInt("content_category_id"));
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
                int price = rs.getInt("price");
                content.setPrice(Integer.toString(price));
                String subCatName = contentCategorySubtypeDao.getContentCategorySubtypeById(rs.getInt("sub_category"));
                content.setSub_category(subCatName);
                
                content.setLocation(locatioDao.getLocationById(rs.getInt("location_id")));
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
            logger.info("contnet msisdn: "+content.getPhone());
            int msisdnId = msisdnDao.getMsisdnIdByNumber(content.getPhone());
            pst = con.prepareStatement(updateContentByIdSql);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            pst.setString(1, content.getShortDescription());
            int locationId = locatioDao.getLocationId(content.getLocation(), countryDao.getCountryIdBySysmbol(content.getCountry()));
            pst.setInt(2, locationId);

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

            int contentCategory = contentCategoryDao.getContentCategoryByName(content.getContent_category());
            logger.info("the con cat: " + contentCategory);

            int subCatID = contentCategorySubtypeDao.getContentCategorySubtypeByName(content.getSub_category(), contentCategory);
            logger.info("the con cat: " + subCatID);
            pst.setInt(7, subCatID);
            pst.setString(8, content.getPrice());
            pst.setInt(9, content.getRemoteContentId());
            pst.setInt(10, content.getRemoteContentDetailId());
            pst.setInt(11, content.getSubmittedToRemote());
            pst.setInt(12, contentId);
            int execStatus = pst.executeUpdate();
            if (execStatus == 1) {
                logger.info("Content update finished(con id: )"+content.getContentId());
              //  if(submitUpdateToRemote==1)
                contService.editContent(content);
                return true;
            } else {
                logger.info("content update failed(content id:)"+content.getContentId());
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
        Content cnt=getContentById(contentId);
        try {
            con = DatabaseSource.getDatabaseConnection();
            pst = con.prepareStatement(deleteContentByIdSql);
            pst.setInt(1, contentId);
            if (pst.executeUpdate() == 1) {
                contService.deleteContent(cnt);
                return true;
            } else {
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
    
    public Content getContentById(int id){
         Connection con = null;
         Content content=null;
        PreparedStatement pst = null;
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getContentById);
            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            
            if (rs.next()) {
                content = new Content();
                String categoryName;

                categoryName = contentCategoryDao.getContentCategoryNameByID(rs.getInt("content_category_id"));
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
                int price = rs.getInt("price");
                content.setPrice(Integer.toString(price));
                String subCatName = contentCategorySubtypeDao.getContentCategorySubtypeById(rs.getInt("sub_category"));
                content.setSub_category(subCatName);
                content.setLocation(rs.getString("location_id"));
                content.setShortDescription(rs.getString("short_description"));
               content.setRemoteContentDetailId(rs.getInt("remote_content_detail_id"));
               content.setRemoteContentId(rs.getInt("remote_content_id"));
               content.setSubmittedToRemote(rs.getInt("submitted_to_remote"));

            }
            logger.debug("getContentById completed");
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
        return content;
    }
}
