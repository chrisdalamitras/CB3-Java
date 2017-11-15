/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class FileRead {
    
    public static void filereader(String pathName, Person person, String[] NamesBirthAge){
        
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(pathName+person.getName("last")+"."+person.getName("first")+".txt"));
            int i , counter = 0;
            while ((i = br.read()) != -1){
                if ((char) i == ':'){
                    NamesBirthAge[counter] = br.readLine();
                    counter += 1;
                }                             
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
