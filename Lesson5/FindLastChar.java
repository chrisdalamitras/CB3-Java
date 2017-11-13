/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findlastchar;

/**
 *
 * @author chris
 */
public class FindLastChar {
    
    public static int bufferIndL(StringBuilder strB){
       
        int i = strB.length()-1 , counter = -1;
        
        do{
           if(strB.charAt(i) == 'l'){
             counter = i;
             break;
           }  
           i -= 1;  
        } while(i >= 0);      
        return counter;       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StringBuilder buffer1 = new StringBuilder("kekkllekkp");
        int indexL;
        
        indexL = bufferIndL(buffer1);
        
        if(indexL == -1)
            System.out.println("Not found");
        else
            System.out.println("Fount in position: " + indexL);
    }
    
}
