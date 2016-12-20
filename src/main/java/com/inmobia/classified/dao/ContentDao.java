package com.inmobia.classified.dao;

import com.inmobia.classified.dto.Content;
import com.inmobia.classified.utility.DatabaseSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 *
 * @author Duncan
 */
public class ContentDao {

    Logger logger = Logger.getLogger(ContentDao.class.getName());
    private String saveContentSql = "insert into "
            + "inmobiaclassified.content(content_category,short_description,location,msisdn_id,expiry_date,email) "
            + "values(?,?,?,?,?,?)";

    public boolean saveContent(Content content) throws SQLException {
        try {
            Connection con = DatabaseSource.getDatabaseConnection();

            PreparedStatement pst = con.prepareStatement(saveContentSql);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            pst.setInt(1, 10);
            pst.setString(2, content.getShortDescription());
            MsisdnDto msisdnDto = new MsisdnDto();
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

}
