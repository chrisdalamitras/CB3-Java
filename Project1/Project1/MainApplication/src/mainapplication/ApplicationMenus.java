/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class ApplicationMenus {
    
    private Scanner input = new Scanner(System.in);
    private LocalDateTime now = LocalDateTime.now();
    private String YearMonthDate = now.format(DateTimeFormatter.ofPattern("yyyy_MM_dd", Locale.ENGLISH));
    private String userName;
    private int user_id;
    private DataBaseAccess DB;
    
    public ApplicationMenus(ResultSet rs, DataBaseAccess DB){
        try {
            this.user_id = rs.getInt("id");
            this.userName = rs.getString("username");
            this.DB = DB;
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationMenus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DisplayMenu(){
        if(userName.equals("admin"))
            SuperAdminAccount();
        else
            SimpleMemberAccount();
    }
    
    private void SuperAdminAccount(){
        System.out.println("****************************************************");
        System.out.println("1: View Cooperative's internal bank account");
        System.out.println("2: View Members' bank accounts");
        System.out.println("3: Deposit to Member's bank account");
        System.out.println("4: Withdraw from Member's bank account");
        System.out.println("5: Send to Statement_admin_" + this.YearMonthDate + ".txt and exit.");
        System.out.println("6: Exit application"); 
        System.out.println("****************************************************");
        
        InternalBankAccounts operations = new InternalBankAccounts(user_id, userName, DB);
        int option;        
        do{
            option = CheckInput(); 
            operations.SuperAdminActions(option);
        } while(option <= 4 );   
    }
    
    private void SimpleMemberAccount(){
        System.out.println("****************************************************");
        System.out.println("1: View your bank account");
        System.out.println("2: Deposit to Cooperative's internal bank account");
        System.out.println("3: Deposit to another Member's bank account");
        System.out.println("4: Send to Statement_user_" + userName.charAt(userName.length()-1) + "_" + this.YearMonthDate + ".txt and exit.");
        System.out.println("5: Exit application"); 
        System.out.println("****************************************************");
        
        InternalBankAccounts operations = new InternalBankAccounts(user_id, userName, DB);
        int option;   
        do{
            option = CheckInput(); 
            operations.SimpleMemberActions(option);
        } while(option <= 3 );  
    }
    
    private int CheckInput(){
        int userInput = 0;
        int MaxMenuNumber = (userName.equals("admin")) ? 6 : 5;
        do{
            System.out.print("Please press a number between 1 and " + MaxMenuNumber + " to choose an operation: ");
            try{
                userInput = Integer.parseInt(input.nextLine());
            } catch(NumberFormatException e){
               // System.out.println("Throws exception "+e);
            }   
        }while(userInput <= 0 || userInput > MaxMenuNumber );
        return userInput;
    }
    
}