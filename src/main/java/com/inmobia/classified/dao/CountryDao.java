package com.inmobia.classified.dao;

import com.inmobia.classified.dto.Location;
import com.inmobia.classified.utility.DatabaseSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Duncan Ndiithi
 */
public class CountryDao {

    Logger logger = Logger.getLogger(ContentDao.class.getName());
    
    private String getCountrySymbolByIdSql="select symbol from inmobiaclassified.country where country_id=?";
    
    public String getCountrySysmbolById(int countryId) {
        Connection con = null;
        PreparedStatement pst = null;
        String countrySymbol="";
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getCountrySymbolByIdSql);
            pst.setInt(1, countryId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                countrySymbol=rs.getString("symbol");
            }
            logger.debug("getCountrySymbolById completed");
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
        return countrySymbol;
    }
}
