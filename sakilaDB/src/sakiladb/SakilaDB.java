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

       private static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
       private static final String USER = "root";
       private static final String PASS = "chris"; 
    
    public static void main(String[] args) {
        
       Connection conn = null;
       Statement stmt = null; 
       ResultSet rs = null; 
       
       try { 
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database.");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement");
            stmt = conn.createStatement( );
            String sql;
            sql = " SELECT actor_id, first_name, last_name FROM actor";
            System.out.println("Excecuting statement");
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int actor_id = rs.getInt("actor_id");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                
                System.out.print("ActorID: "+ actor_id);
                System.out.print(", First name: " + firstname);
                System.out.println(", Last name: "+ lastname);
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SakilaDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           
           try{
               if(stmt != null)
                   stmt.close();
           }catch(SQLException se2){
               
           }
           try{
               if(conn != null)
                   conn.close();                              
           }catch(SQLException se){
               
               se.printStackTrace();              
           }           
       } 
        
       System.out.println("Finished!");
       
    }
    
    
    
}
