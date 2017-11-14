/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.util.regex.PatternSyntaxException;

/**
 *
 * @author chris
 */
public class CheckDate {
    
    public static boolean checkIdate(String strD){
        
        String[] bd = new String[3];
        
        try{
            String[] birthDate = strD.split("/");
            if( birthDate.length > 3)
                return false;    
            else
                for(int i=0; i<birthDate.length; i++)
                    bd[i] = birthDate[i];                    
        } catch(PatternSyntaxException e){
            System.out.println("Throws exceprion"+e);
            return false;
        }
        
        try{
            if(Integer.parseInt(bd[0]) > 31 || Integer.parseInt(bd[1]) > 12 || Integer.parseInt(bd[2]) > 2017)
                return false;    
            else
                return true;            
        }catch(NumberFormatException e){
            System.out.println("Throws exceprion"+e);
            return false;
        }   
        
    }
    
}
