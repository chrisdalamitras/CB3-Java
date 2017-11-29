/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakiladb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class SakilaDB {

       private static Connection conn = null;
       private static Statement stmt = null;
       private static ResultSet rs = null;
       private static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
       private static final String USER = "root";
       private static final String PASS = "chris"; 
    
    public static void main(String[] args) {
        
       try { 
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database.");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement( );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SakilaDB.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    
}
