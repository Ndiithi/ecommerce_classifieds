/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobia.classified.utility;

import java.sql.Connection;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Duncan
 */
public class DatabaseSource {

    Logger logger = Logger.getLogger(DatabaseSource.class.getName());

    protected DatabaseSource() {

    }

    public static Connection getDatabaseConnection() {
        DatabaseSource dbobj = new DatabaseSource();
        Connection dbconnection = dbobj.createDatabaseConnection();
        if (dbconnection == null) {
            dbobj.logger.error("Failed to create database connection");
        }

        return dbconnection;

    }

    private Connection createDatabaseConnection() {
        Connection dbconnection = null;
        try {
            DbProperties.getJndiName();
            DataSource ds = (DataSource) InitialContext.doLookup(DbProperties.getJndiName());
            dbconnection = ds.getConnection();
            return dbconnection;
        } catch (NamingException ex) {
            logger.error(ex.getMessage());
            return dbconnection;

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            return dbconnection;
        }

    }

}
