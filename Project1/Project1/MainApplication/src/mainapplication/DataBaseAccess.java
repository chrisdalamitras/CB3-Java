/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
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
public class DataBaseAccess {
    
    private Connection conn = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project1?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "chris";
    
    public void ConnectToDatabase(){      
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Could not establish connection with database!!!");
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet login(String userName, String passWord){        
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, username FROM users WHERE username = ? AND CAST(AES_DECRYPT(password,'key12345') as char(30)) = ?");
            pstmt.setString(1, userName);
            pstmt.setString(2, passWord);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return rs;      
    }
    
    public void DisplayUserBalance(int userID, String userName, StringBuilder sbTran){
        ResultSet rs;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT amount, transaction_date FROM accounts WHERE user_id = ?");
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            if (rs.first()) {
                double amount = rs.getDouble("amount");
                String date = rs.getString("transaction_date");
                System.out.println(userName+", "+date+", "+displayNumber(amount)+" EUR");
                sbTran.append(getDateHour()).append(" ").append(userName).append(" has ").append(displayCurrency(amount)).append("\r\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void DisplayALLUsersBalance(String userName, StringBuilder sbTran){
        ResultSet rs;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT username, amount, transaction_date FROM users, accounts WHERE users.username != ? AND accounts.user_id = users.id");
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                double amount = rs.getDouble("amount");
                String usrName = rs.getString("username");
                String date = rs.getString("transaction_date");
                System.out.println(usrName+", "+date+", "+displayNumber(amount)+" EUR");
                sbTran.append(getDateHour()).append(" ").append(usrName).append(" has ").append(displayCurrency(amount)).append("\r\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void DepositToCooperativeAccount(int userID, StringBuilder sbTran, String userName){
        double depositMoneyAdmin = getInputMoney(userID);
        DepositWithDrawHelper(1, userID, depositMoneyAdmin);
        ChangeDate(userID, 1);
        sbTran.append(getDateHour()).append(" ").append(userName).append(" deposit to admin: ").append(displayCurrency(depositMoneyAdmin)).append("\r\n");
    }
    
    public void DepositToMembersAccount(int userID, StringBuilder sbTran,String userName){
        int userIDeposit = SelectMember(userID);
        double depositMoney = getInputMoney(userID);        
        DepositWithDrawHelper(userIDeposit, userID, depositMoney);
        ChangeDate(userID, userIDeposit);
        sbTran.append(getDateHour()).append(" ").append(userName).append(" deposit to ").append(getUserName(userIDeposit)).append(": ").append(displayCurrency(depositMoney)).append("\r\n");
    }
    
    public void DepositToAllMembersAccount(int userID, StringBuilder sbTran, String userName){
        ResultSet rs;
        try {
            PreparedStatement pstmt3 = conn.prepareStatement("SELECT id, username FROM users WHERE id != ?");
            pstmt3.setInt(1, userID);
            rs = pstmt3.executeQuery();
            while(rs.next()){
                int user_id = rs.getInt("id");
                String usrName = rs.getString("username");
                System.out.print("Deposit to "+ usrName +", ");
                double depositMoney = getInputMoney(userID);
                DepositWithDrawHelper(user_id, userID, depositMoney);
                ChangeDate(userID, user_id);
                sbTran.append(getDateHour()).append(" ").append(userName).append(" deposit to ").append(usrName).append(": ").append(displayCurrency(depositMoney)).append("\r\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void WithDrawFromMembersAccount(int userID, StringBuilder sbTran, String userName){
        ResultSet rs;
        try {
            PreparedStatement pstmt3 = conn.prepareStatement("SELECT id, username FROM users WHERE id != ?");
            pstmt3.setInt(1, userID);
            rs = pstmt3.executeQuery();
            while(rs.next()){
                int user_id = rs.getInt("id");
                String usrName = rs.getString("username");
                System.out.print("Withdraw from "+ usrName +", ");
                double withdrawMoney = getInputMoney(user_id);
                DepositWithDrawHelper(userID, user_id, withdrawMoney);
                ChangeDate(userID, user_id);
                sbTran.append(getDateHour()).append(" ").append(userName).append(" withdraw from ").append(usrName).append(": ").append(displayCurrency(withdrawMoney)).append("\r\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private int SelectMember(int userID){
        ResultSet rs;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT username FROM users WHERE username != 'admin' AND id != ?");
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            System.out.println("You can select from one of the following users");
            while (rs.next()) {
                String usrName = rs.getString("username");
                System.out.println(usrName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        int userIDepositWithdraw = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM users WHERE username != 'admin' AND id != ? AND username = ?");
            pstmt.setInt(1, userID);
            System.out.print("Choose username: ");
            do{
                pstmt.setString(2, input.nextLine());
                rs = pstmt.executeQuery();
                if (rs.first()){ 
                    userIDepositWithdraw = rs.getInt("id");
                    flag = false;
                }
                else
                    System.out.print("Invalid username, pls give again: ");
            }while(flag);        
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userIDepositWithdraw;
    }
    
    private double getAmount(int userID){
        ResultSet rs;
        double amount = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT amount FROM accounts WHERE user_id = ?");
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            if (rs.first()) {
                amount = rs.getDouble("amount");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }
    
    private double getInputMoney(int userID){
        Scanner input = new Scanner(System.in);
        System.out.print("Please give the amount of money: ");
        double money;
        double accountMoney = getAmount(userID);        
        while(true){
            try{
                money = Double.parseDouble(input.nextLine().replace("," , "."));
                if(money < 0)
                    System.out.print("Negative amount of money, please give again: ");
                else if(money > accountMoney)
                    System.out.print("Money in account: " + displayNumber(accountMoney) + " EUR, pls give again: ");
                else
                    return money;
            } catch(NumberFormatException e){
              //  System.out.println("Throws exception "+e);
                System.out.print("Thats not a number, please give again: ");
            }   
        }  
    }
    
    private String getUserName(int userID){
        ResultSet rs;
        String userName = "";
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT username FROM users WHERE id = ?");
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            if (rs.first())
                userName = rs.getString("username");
            else
                System.out.println("Couldnt get username");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return userName;    
    }
    
    private void DepositWithDrawHelper(int userID1, int userID2, double DepWithMoney){
        try {
            PreparedStatement pstmt1 = conn.prepareStatement("UPDATE accounts SET amount = amount + ? WHERE user_id = ?");
            PreparedStatement pstmt2 = conn.prepareStatement("UPDATE accounts SET amount = amount - ? WHERE user_id = ?");
            pstmt1.setDouble(1, DepWithMoney);
            pstmt2.setDouble(1, DepWithMoney);
            pstmt1.setInt(2, userID1);
            pstmt2.setInt(2, userID2);
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    private void ChangeDate(int userID1, int userID2){     
        try {
            PreparedStatement pstmt1 = conn.prepareStatement("UPDATE accounts SET transaction_date = localtime() WHERE user_id = ?");
            PreparedStatement pstmt2 = conn.prepareStatement("UPDATE accounts SET transaction_date = localtime() WHERE user_id = ?");
            pstmt1.setInt(1, userID1);
            pstmt2.setInt(1, userID2);
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    private String displayCurrency(double amount) {
        Locale grLocale = new Locale("el", "GR");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(grLocale);
        return currencyFormatter.format(amount);
    }
    
    private String displayNumber(double amount) {
        Locale grLocale = new Locale("el", "GR");
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(grLocale);
        return numberFormatter.format(amount);
    }
    
    private String getDateHour(){  
        LocalDateTime now = LocalDateTime.now();
        String YearMonthDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH));
        return YearMonthDate; 
    }
    
    public void closeResources(){
        try {
            if(conn!=null)
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}