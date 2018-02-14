/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication;

import java.io.IOException;



/**
 *
 * @author chris
 */
public class MainApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataBaseAccess DB = new DataBaseAccess();
        DB.ConnectToDatabase();
        LoginScreen login = new LoginScreen(DB);      
        if(!login.CheckCredentials()){
           DB.closeResources(); 
           System.exit(0);
        }
        ApplicationMenus display = new ApplicationMenus(login.getIdUserName(), DB);
        clrscr();
        display.DisplayMenu();
        DB.closeResources();
    }
    
    private static void clrscr(){
    //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println("Throws exception"+ex);
        }
    }
     
}