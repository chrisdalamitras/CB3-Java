/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

/**
 *
 * @author chris
 */
public class SetPerson {
    
    public static void setperson(String[] NamesBirthAge, Person person){
        
        String[] Names = NamesBirthAge[0].split(",");
        
        person.setName("last", Names[0].trim());
        person.setName("first", Names[1].trim());
        person.setName("father", Names[2].trim());
        person.setBirthD_Age(NamesBirthAge[1].trim());
    }
    
}
