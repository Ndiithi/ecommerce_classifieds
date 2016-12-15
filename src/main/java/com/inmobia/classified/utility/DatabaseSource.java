/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.utility;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author Duncan
 */
public class DatabaseSource {
    private Connection dbconnection=null;
    public DatabaseSource(){
        createDatabaseConnection();
    }
    
    public Connection getDatabaseConnection(){
         createDatabaseConnection();
        return dbconnection;
        
    }
    
    private void createDatabaseConnection(){
        try {
            DataSource ds=(DataSource) InitialContext.doLookup("inmobiaclassifiedsite");
           dbconnection=ds.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(DatabaseSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Connection getDbconnection() {
        return dbconnection;
    }
    
    
}
