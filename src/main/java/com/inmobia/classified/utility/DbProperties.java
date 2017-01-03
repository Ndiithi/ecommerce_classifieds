package com.inmobia.classified.utility;

/**
 *
 * @author Duncan
 */
public class DbProperties {
    //Dev enviroment;
    private static String jndiName="inmobiaclassifiedsite";
    //production;
//     private static String jndiName="java:/inmobiaclassifiedsite";
    //Developement envin
    public static String userName="";
    public static String password="";
    public static int port=0;
    
    private DbProperties(){}
    
    public static String getJndiName() {
        return jndiName;
    }

    public static void setJndiName(String jndiName) {
        DbProperties.jndiName = jndiName;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        DbProperties.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DbProperties.password = password;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        DbProperties.port = port;
    }
            
   
}
