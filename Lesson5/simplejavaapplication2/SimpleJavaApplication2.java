/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class SimpleJavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        
        Person person = new Person();
        Scanner input = new Scanner(System.in);
        String DateBirth;
        String[] line = new String[3];
        
        System.out.println("Give your first name:");
        person.setFirstN(input.nextLine());
        System.out.println("Give your last name:");
        person.setLastN(input.nextLine());
        System.out.println("Give your fathers name:");
        person.setFatherN(input.nextLine());
        System.out.println("Give your date of birth in the form DD/MM/YYYY e.g. 22/05/1990:");
        DateBirth = input.nextLine();
        while(!CheckDate.checkIdate(DateBirth)){
             System.out.println("Wrong date of birth, give again:");
             DateBirth = input.nextLine();
        }
        person.setBirthD_Age(DateBirth);
        
        line[0] = person.getLastN()+", "+person.getFirstN()+", "+person.getFatherN();
        line[1] = person.getBirthD();
        line[2] = Integer.toString(person.getAge());
        
        FileWrite.filewriter(line);
             
    }
    
}
