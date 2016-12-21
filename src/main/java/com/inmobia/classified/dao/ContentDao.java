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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Duncan
 */
public class ContentDao {

    @Autowired
    MsisdnDao msisdnDto;
    Logger logger = Logger.getLogger(ContentDao.class.getName());
    private String saveContentSql = "insert into "
            + "inmobiaclassified.content(content_category,short_description,location,msisdn_id,expiry_date,email,negotiable) "
            + "values(?,?,?,?,?,?,?)";

    private String getAllContentByMsisdn = "Select * from inmobiaclassified.content where msisdn_id=?";

    public boolean saveContent(Content content) throws SQLException {
        try {
            Connection con = DatabaseSource.getDatabaseConnection();

            PreparedStatement pst = con.prepareStatement(saveContentSql);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            pst.setInt(1, 10);
            pst.setString(2, content.getShortDescription());

            int msisdnId = msisdnDto.getMsisdnIdByNumber(content.getPhone());
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
            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new SQLException(ex.getMessage());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return false;
        }

    }

    public List<Content> getAllContentByMsisdn(String msisdn) {
        Connection con = DatabaseSource.getDatabaseConnection();
        List<Content> contentList = null;

        try {
            PreparedStatement pst = con.prepareStatement(getAllContentByMsisdn);
            int msisdnId = msisdnDto.getMsisdnIdByNumber(msisdn);
            pst.setInt(1, msisdnId);
            ResultSet rs = pst.executeQuery();
            contentList = new ArrayList();
            Content content;
            while (rs.next()) {
                content = new Content();
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
                content.setLocation(rs.getString("location"));
                content.setShortDescription(rs.getString("short_description"));
                contentList.add(content);

            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return contentList;
    }

}
