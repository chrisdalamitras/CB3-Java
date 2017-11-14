/*
 * It computes the fibonacci of a given number.
 */
package fibbonaci;

import java.util.Scanner;

/**
 *
 * @author chris
 */
public class Fibbonaci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int num, result;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Give an integer number:");
        num = input.nextInt();
        result = fibonacciN(num);
        System.out.println("The fibonacci of "+num+" is "+result);
        
    }
    
    public static int fibonacciN(int n){
        
        if(n==0 || n==1)
            return n;
        else
            return fibonacciN(n-2) + fibonacciN(n-1);  
    }
    
}
