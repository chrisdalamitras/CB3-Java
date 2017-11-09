/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askhsh1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class Askhsh1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int x = 0;
        String str;
        boolean flag = true;
        
        System.out.println("Give an integer number");
        
        while(flag) {
         try {   
           x = input.nextInt();
           flag = false;
         } catch (InputMismatchException e) {
            System.out.println("Throw expection " +e);
            input.next();
           }
        }
        
        System.out.println("Give a string ");
        str = input.next();
        
        System.out.println(str + x);
    }
    
}
