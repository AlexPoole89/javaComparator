/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz4people;

import java.math.BigDecimal;

/**
 *
 * @author 1795647
 */
public class Teacher extends Person {

    String subject; // 2 or more characters
    int yearsOfExperience;

    public Teacher(String name, int age, String subject, int yearsOfExperience) throws InvalidArgumentException {
        super(name, age);
        setSubject(subject);
        setYears(yearsOfExperience);
    }

    public final void setSubject(String subject) throws InvalidArgumentException{
        if(subject.length() < 2) {
            throw new InvalidArgumentException("Program must be 2 or more characters");
        }
        this.subject = subject;
    }
    
    public final void setYears(int yearsOfExperience) throws InvalidArgumentException {
        if (yearsOfExperience < 0){
            throw new InvalidArgumentException("Years of experience must be more than 0");
        }
        this.yearsOfExperience = yearsOfExperience;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public int getYears() {
        return yearsOfExperience;
    }
    
    
    @Override
    public void print() {
        System.out.printf("%s is %s y/o and teaches %s with %s years of experience", name, age, subject, String.valueOf(yearsOfExperience));
    }

}
