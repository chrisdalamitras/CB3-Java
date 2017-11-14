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
public class Person {
    
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthDate;
    private int age;
    
    public String getFirstN() {
	return firstName;
    }

    public String getLastN() {
        return lastName;
    }

    public String getFatherN() {
        return fatherName;
    }

    public String getBirthD() {
        return birthDate;
    }
    
    public int getAge() {
        return age;
    }

    public void setFirstN(String firstName) {
        this.firstName = firstName;
    }

    public void setLastN(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherN(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBirthD_Age(String birthDate) {
        this.birthDate = birthDate;
        String[] bd = birthDate.split("/");
        this.age = 2017 - Integer.parseInt(bd[2]);
    }
       
}
