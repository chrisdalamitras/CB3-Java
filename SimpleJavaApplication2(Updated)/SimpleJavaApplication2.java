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
        
        String pathName = PathName.pathFname();
        String[] NamesBirthAge = new String[3];
        
        FileWrite.filewriter(line,person,pathName);
        FileRead.filereader(pathName, person, NamesBirthAge);
        
        Person person2 = new Person();
        
        SetPerson.setperson(NamesBirthAge, person2);
        
        System.out.println("Your first name is: "+person2.getName("first"));
        System.out.println("Your last name is: "+person2.getName("last"));
        System.out.println("Your fathers name is: "+person2.getName("father"));
        System.out.println("Your birth date is: "+person2.getBirthD());
        System.out.println("Your age is: "+person2.getAge());     
    }
    
}
