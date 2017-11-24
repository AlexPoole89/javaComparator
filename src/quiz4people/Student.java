
package quiz4people;

import java.math.BigDecimal;


public class Student extends Person {

     private String program; // 2 or more characters
    private BigDecimal gpa; // from 0 to 4.0
    
    public Student(String name, int age, String program, BigDecimal gpa) throws InvalidArgumentException {
        super(name, age);
        setProgram(program);
        setGpa(gpa);
    }

     public final void setProgram(String program) throws InvalidArgumentException{
        if(program.length() < 2) {
            throw new InvalidArgumentException("Program must be 2 or more characters");
        }
        this.program = program;
    }
    
    public final void setGpa(BigDecimal gpa) throws InvalidArgumentException {
        if (gpa.intValue() < 0 || gpa.intValue() > 4){
            throw new InvalidArgumentException("GPA must be between 0 and 4.0");
        }
        this.gpa = gpa;
    }
    
    public String getProgram() {
        return program;
    }
    
    public BigDecimal getGpa() {
        return gpa;
    }
    
    
    
    @Override
    public void print() {
        System.out.printf("%s is %s y/o in %s with GPA of %s", name, age, program, gpa.toString());
    }
    
}
