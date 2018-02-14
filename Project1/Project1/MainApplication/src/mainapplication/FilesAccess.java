/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class FilesAccess {
    
    public static void filewriter(StringBuilder transactions, String userName) {        
        LocalDateTime now = LocalDateTime.now();
        String YearMonthDate = now.format(DateTimeFormatter.ofPattern("yyyy_MM_dd", Locale.ENGLISH));
        File log;
        if(userName.equals("admin"))
            log = new File("Statement_admin_" + YearMonthDate + ".txt");
        else
            log = new File("Statement_user_" + userName.charAt(userName.length()-1) + "_" + YearMonthDate + ".txt");
        try {
            FileWriter writeFile = new FileWriter(log, true);
            PrintWriter writer = new PrintWriter(writeFile);
            writer.printf(transactions.toString());
            writer.close();
            System.out.println("Successfully wrote to file!!!");
        } catch (IOException ex) {
            Logger.getLogger(FilesAccess.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }  
}