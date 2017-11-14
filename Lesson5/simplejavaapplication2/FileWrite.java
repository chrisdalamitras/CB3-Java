/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class FileWrite {
    
    public static void filewriter(String[] line, Person person) {
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(person.getName("last")+"."+person.getName("first")+".txt", "UTF-8");
            for(int i=0; i<line.length; i++)
                writer.println("Line " + (i+1) + ": " + line[i]);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
