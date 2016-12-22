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
public class MsisdnDao {

    private String getMsisdnIdSql = "Select msisdn_id from inmobiaclassified.phone_number where msisdn=?";
    private String insertNewMsisdnSql = "insert into inmobiaclassified.phone_number(msisdn) value(?)";

    Logger logger = Logger.getLogger(MsisdnDao.class.getName());

    public int getMsisdnIdByNumber(String msisdn) throws SQLException {
            Connection con=null;
        try {
            int msisdnId = 0;
             con= DatabaseSource.getDatabaseConnection();

            PreparedStatement ps = con.prepareStatement(getMsisdnIdSql);
            ps.setString(1, msisdn);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                msisdnId = rs.getInt(1);
                return msisdnId;
            } else {
                ps = con.prepareStatement(insertNewMsisdnSql);
                ps.setString(1, msisdn);
                ps.executeUpdate();
                return (getMsisdnIdByNumber(msisdn));
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }finally{
            con.close();
        }
    }
}
