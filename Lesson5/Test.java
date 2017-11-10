/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author chris
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int i,j,k;
        int sum1 = 0,sum2 = 0,sum3 = 0;
        int[][][] counts = new int[3][3][3];
        
        
        for (i = 0; i< counts.length; i++)
            for(j = 0; j<counts[i].length; j++)
                for(k = 0; k<counts[i][j].length; k++)
                   counts[i][j][k] = i+j+k;
        
        for (i = 0; i< counts.length; i++)
            for(j = 0; j<counts[i].length; j++)
                for(k = 0; k<counts[i][j].length; k++)
                  System.out.println("["+i+"]"+"["+j+"]"+"["+k+"]"+"="+counts[i][j][k]);
        
        for (i = 0; i< counts.length; i++){
            sum1 = sum1+counts[i][0][0];
        
            for(j = 0; j<counts[i].length; j++){
                sum2 = sum2 + counts[i][j][0];
            
                for(k = 0; k<counts[i][j].length; k++){
                    sum3 = sum3+counts[i][j][k];
                }
            }
        }    
        System.out.println("First dimension sum: " +sum1);
        System.out.println("Second dimension sum: " +sum2);
        System.out.println("Third dimension sum: " +sum3);  
       
    }
    
}
