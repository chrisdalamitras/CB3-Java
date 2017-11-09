/*
 * Read three integers. The second integer must be be at least three times higher
 * than the first integer and the third must be higher than the sum of the other two.
 */
package askhsh2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class Askhsh2 {
    
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
        
      int x1 , x2 , x3;
      boolean flag;
          
      Scanner input = new Scanner(System.in);
         
      do {
          
         System.out.println("Give first number");
         x1 = check_value(input);
         System.out.println("Give second number");
         x2 = check_value(input);
         System.out.println("Give third number");
         x3 = check_value(input);
         
         flag = (x2 >= 3*x1) && (x3 > x1+x2);
         
         if (!flag) {
           System.out.println("Second number needs to be at least 3 times higher than the first number");
           System.out.println("Third number needs to be higher than the sum of first and second number\n");
         }
         else 
           System.out.println("Good job!!!");
         
      } while(!flag); 
        
    }
    
}
