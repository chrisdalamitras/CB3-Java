/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class LoginScreen {
    
    private Scanner input = new Scanner(System.in);
    private Console console = System.console();
    private String userName;
    private String passWord;
    private byte tries = 3;
    private ResultSet ID_userName = null;
    private DataBaseAccess DB;
    
    public LoginScreen(DataBaseAccess DB){
        this.DB = DB;    
    }
    
    public boolean CheckCredentials(){
        
        while(tries > 0){
             System.out.print("Please give your username: ");
             this.userName = input.nextLine();
             char[] pw = console.readPassword("Please give your Password: ");
             this.passWord = String.valueOf(pw);
             ID_userName = DB.login(userName, passWord);
            try {
                if(ID_userName.first())   
                    return true;    
            } catch (SQLException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println("Wrong credentials!!!");
             tries -= 1;             
        }
        System.out.println("You have been locked out of your account");
        System.out.println("The application will now close.");
        return false;
    }
    
    public ResultSet getIdUserName(){
        return this.ID_userName;
    }
}