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
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        
        Person person = new Person();
        Scanner input = new Scanner(System.in);
        String DateBirth;
        String[] line = new String[3];
        
        System.out.println("Give your first name:");
        person.setName("first",input.nextLine());
        System.out.println("Give your last name:");
        person.setName("last",input.nextLine());
        System.out.println("Give your fathers name:");
        person.setName("father",input.nextLine());
        System.out.println("Give your date of birth in the form DD/MM/YYYY e.g. 22/05/1990:");
        DateBirth = input.nextLine();
        while(!CheckDate.checkIdate(DateBirth)){
             System.out.println("Wrong date of birth, give again:");
             DateBirth = input.nextLine();
        }
        person.setBirthD_Age(DateBirth);
        
        line[0] = person.getName("last")+", "+person.getName("first")+", "+person.getName("father");
        line[1] = person.getBirthD();
        line[2] = Integer.toString(person.getAge());
        
        FileWrite.filewriter(line,person);
             
    }
    
}
