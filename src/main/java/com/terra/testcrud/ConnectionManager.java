package com.terra.testcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/terra_store_test?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private Connection c;
    public Connection getConnection() {        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                c = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }        
        if (c != null) {
            System.out.println("Database connected");
        } else {
            System.out.println("Database not connected");
        }
        return c;
    }
    
    public void closeConnection(){       
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
