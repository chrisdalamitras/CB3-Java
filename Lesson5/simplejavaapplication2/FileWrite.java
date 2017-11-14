/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author chris
 */
public class FileWrite {
    
    public static void filewriter(String[] line, Person person) throws FileNotFoundException, UnsupportedEncodingException{
        
        PrintWriter writer = new PrintWriter(person.getLastN()+"."+person.getFirstN()+".txt", "UTF-8");
        for(int i=0; i<3; i++){
            writer.println("Line " + (i+1) + ": " + line[i]);
        }
         writer.close();
        
    }
    
}
