package com.inmobia.classified.dao;


import com.inmobia.classified.dto.Location;
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
public class LocationDao {
    
    @Autowired
    CountryDao countryDao;
    
     Logger logger = Logger.getLogger(LocationDao.class.getName());
    
     private String getAllLocationSql="select * from inmobiaclassified.location";
     private String getLocationId="select location_id where location_name=? and country_id=?";
     
     public List<Location> getAllLocation() {
        Connection con = null;
        List<Location> locationList = null;
        PreparedStatement pst = null;
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getAllLocationSql);
            
            
            ResultSet rs = pst.executeQuery();
            locationList = new ArrayList();
            Location location;
            Set<Integer> countryIdSet=new HashSet();
            Map<Integer,String> symbolMapper=new HashMap();
            while (rs.next()) {
                String symbol;
                int countryId=rs.getInt("country_id");
                
                if(!countryIdSet.contains(countryId)){
                    symbol=countryDao.getCountrySysmbolById(countryId);
                    symbolMapper.put(countryId, symbol);
                    countryIdSet.add(countryId);
                }
                
                location = new Location();
                location.setLocation(rs.getString("location_name"));
                location.setCountrySymbol(symbolMapper.get(countryId));
                locationList.add(location);
            }
            logger.debug("getAllLocation completed");
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
        return locationList;
    }
     
     
      public int getLocationId(String name, int id) {
        Connection con = null;
        int locationId=-1;
        PreparedStatement pst = null;
        try {
            logger.debug("Trying to make db connection");
            con = DatabaseSource.getDatabaseConnection();
            logger.debug("Db connection made");
            pst = con.prepareStatement(getLocationId);      
            pst.setString(1, name);
           pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
           
 
            if (rs.next()) {
               locationId=rs.getInt("location_id");
            }
            logger.debug("getLocationId completed");
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
        return locationId;
    }
}
