/*
 * It computes and print the factorial of a given number.
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author chris
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int num;
        long fact;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Give an integer number:");
        num = input.nextInt();
        fact = factorial(num);
        System.out.println("The factorial of "+num+" is "+fact);
        
    }
    
    public static long factorial(int n){
        
        if(n == 1)
            return 1;
        else
            return n*factorial(n-1);       
    }   
    
}
