/*
 * Read an integer and a string,  merge them and then print them 
 */
package askhsh1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class Askhsh1 {
    
    public static int check_value(Scanner input){
       
        while(true) {
         try {   
           return input.nextInt();
         } catch (InputMismatchException e) {
             System.out.println("Throw expection " +e);
             input.next();
           }
        }     
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int x;
        String str;
        
        System.out.println("Give an integer number");
        x = check_value(input);
        System.out.println("Give a string ");
        str = input.next();
        
        System.out.println(x + str);
    }
    
}
