/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author chris
 */
public class SimpleJavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        
        String firstName, lastName, fatherName, dateBirth;
        int age;
        String[] birthDate = new String[3];
        Scanner input = new Scanner(System.in);
        String[] line = new String[3];
        
        System.out.println("Give your first name:");
        firstName = input.nextLine();
        System.out.println("Give your last name:");
        lastName = input.nextLine();
        System.out.println("Give your fathers name:");
        fatherName = input.nextLine();
        System.out.println("Give your date of birth in the form DD/MM/YYYY e.g. 22/05/1990:");
        dateBirth = input.nextLine();
        while(!checkDate(dateBirth,birthDate)){
             System.out.println("Wrong date of birth, give again:");
             dateBirth = input.nextLine();
        }
        age = 2017-Integer.parseInt(birthDate[2]);
        
        line[0] = lastName+", "+firstName+", "+fatherName;
        line[1] = dateBirth;
        line[2] = Integer.toString(age);
        
        PrintWriter writer = new PrintWriter(lastName+"."+firstName+".txt", "UTF-8");
        for(int i=0; i<3; i++){
            writer.println("Line " + (i+1) + ": " + line[i]);
        }
         writer.close();
    }
    
    public static boolean checkDate(String strD, String[] bd){
        
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
