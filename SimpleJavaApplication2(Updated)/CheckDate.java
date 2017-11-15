/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.util.Calendar;

/**
 *
 * @author chris
 */
public class CheckDate {
    
    public static boolean checkIdate(String strD){
        
        String[] birthDate = strD.split("/"); 
        if (birthDate.length != 3)
            return false;
                
        try{
            int i = Integer.parseInt(birthDate[0]);
            boolean flag1 = 0 >= i || i > 31;
            i = Integer.parseInt(birthDate[1]);
            boolean flag2 = 0 >= i || i > 12;
            i = Integer.parseInt(birthDate[2]);
            boolean flag3 = 1900 >= i || i > Calendar.getInstance().get(Calendar.YEAR);
            if(flag1 || flag2 || flag3)
                return false;    
            else
                return true;            
        }catch(NumberFormatException e){
            System.out.println("Throws exceprion"+e);
            return false;
        }   
        
    }
    
}
