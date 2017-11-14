/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.util.Calendar;

/**
 *
 * @author chris
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthDate;
    private int age;
    
    public String getName(String name) {
        switch (name) {
            case "last":
                return this.lastName;
            case "first":
                return this.firstName;
            case "father":
                return this.fatherName;
            default:
                System.out.println("Method getName failed to get the given name because of wrong arguments");
                return "Wrong";
        }
    }

    public String getBirthD() {
        return birthDate;
    }
    
    public int getAge() {
        return age;
    }

    public void setName(String name, String Name) {
        switch (name) {
            case "last":
                this.lastName = Name;
                break;
            case "first":
                this.firstName = Name;
                break;
            case "father":
                this.fatherName = Name;
                break;
            default:
                System.out.println("Method setName failed to set the given name because of wrong arguments");
                break;
        }
    }

    public void setBirthD_Age(String birthDate) {
        this.birthDate = birthDate;
        String[] bd = birthDate.split("/");
        this.age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(bd[2]);
    }
       
}
