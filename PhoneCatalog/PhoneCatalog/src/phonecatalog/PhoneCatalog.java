/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonecatalog;

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
public class PhoneCatalog {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/phonecatalog?autoReconnect=true&useSSL=false";
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
            sql = " SELECT * FROM members";
            System.out.println("Excecuting statement");
            rs = stmt.executeQuery(sql);
           
            while(rs.next()){
                int id = rs.getInt("ID");
                String firstname = rs.getString("Fname");
                String lastname = rs.getString("Lname");
                String phone = rs.getString("phone");
                
                System.out.print("ID: "+ id);
                System.out.print(", First name: " + firstname);
                System.out.print(", Last name: "+ lastname);
                System.out.println(", phone: "+ phone);
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PhoneCatalog.class.getName()).log(Level.SEVERE, null, ex);
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
    

